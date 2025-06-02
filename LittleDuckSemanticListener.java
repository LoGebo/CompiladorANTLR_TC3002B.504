package com.littleduck.semantic;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Listener para análisis semántico de Little Duck
 * Implementa las validaciones en los puntos neurálgicos identificados
 */
public class LittleDuckSemanticListener {
    
    private ProcTable procTable;
    private SemanticCube semanticCube;
    private List<String> errors;
    private Stack<DataType> typeStack;
    private Stack<String> operatorStack;
    
    public LittleDuckSemanticListener() {
        this.procTable = new ProcTable();
        this.semanticCube = new SemanticCube();
        this.errors = new ArrayList<>();
        this.typeStack = new Stack<>();
        this.operatorStack = new Stack<>();
    }
    
    // ===== PUNTO NEURÁLGICO 1: Regla programa =====
    public void enterPrograma(ParserRuleContext ctx) {
        // Crear la entrada "global" en el Directorio de Funciones
        String programName = ctx.getChild(1).getText(); // ID después de PROGRAM
        procTable.addFunction("global", DataType.VOID);
        procTable.setCurrentScope("global");
        System.out.println("Iniciando análisis semántico del programa: " + programName);
    }
    
    public void exitPrograma(ParserRuleContext ctx) {
        // Finalizar análisis semántico
        System.out.println("Análisis semántico completado.");
        if (!errors.isEmpty()) {
            System.out.println("Errores encontrados:");
            for (String error : errors) {
                System.err.println(error);
            }
        } else {
            System.out.println("No se encontraron errores semánticos.");
        }
    }
    
    // ===== PUNTO NEURÁLGICO 2: Regla dec_var_aux =====
    public void exitDec_var_aux(ParserRuleContext ctx) {
        // Obtener el tipo del último hijo (antes del SEMICOLON)
        DataType tipo = getDataTypeFromString(ctx.getChild(ctx.getChildCount() - 2).getText());
        
        // Para cada ID en lista_ids (primer hijo)
        ParserRuleContext listaIds = (ParserRuleContext) ctx.getChild(0);
        for (int i = 0; i < listaIds.getChildCount(); i += 2) { // IDs están en posiciones pares
            if (i < listaIds.getChildCount()) {
                String varName = listaIds.getChild(i).getText();
                
                // Intentar añadir la variable a la VarTable del ámbito actual
                boolean added = procTable.addVariableToFunction(procTable.getCurrentScope(), varName, tipo);
                
                if (!added) {
                    errors.add("Error: Variable '" + varName + "' doblemente declarada");
                } else {
                    System.out.println("Variable '" + varName + "' de tipo " + tipo + 
                                     " declarada en ámbito " + procTable.getCurrentScope());
                }
            }
        }
    }
    
    // ===== PUNTO NEURÁLGICO 3: Regla bloque_principal =====
    public void enterBloque_principal(ParserRuleContext ctx) {
        // Intentar añadir "main" al Directorio de Funciones
        boolean added = procTable.addFunction("main", DataType.VOID);
        
        if (!added) {
            errors.add("Error: Función 'main' ya existe");
        } else {
            // Establecer "main" como el ámbito actual
            procTable.setCurrentScope("main");
            System.out.println("Entrando al ámbito 'main'");
        }
    }
    
    // ===== PUNTO NEURÁLGICO 4: Regla factor =====
    public void exitFactor(ParserRuleContext ctx) {
        String text = ctx.getText();
        
        if (text.matches("[a-zA-Z][a-zA-Z0-9]*")) {
            // Es un identificador
            String varName = text;
            Variable var = procTable.searchVariable(varName);
            
            if (var == null) {
                errors.add("Error: Variable '" + varName + "' no declarada");
                typeStack.push(DataType.ERROR);
            } else {
                typeStack.push(var.getType());
                System.out.println("Variable '" + varName + "' encontrada con tipo " + var.getType());
            }
        } else if (text.matches("[0-9]+")) {
            // Es una constante entera
            typeStack.push(DataType.INT);
        } else if (text.matches("[0-9]+\\.[0-9]+")) {
            // Es una constante flotante
            typeStack.push(DataType.FLOAT);
        }
    }
    
    // ===== PUNTO NEURÁLGICO 5: Reglas de Expresión =====
    public void exitExp_arit(ParserRuleContext ctx) {
        processArithmeticExpression(ctx);
    }
    
    public void exitExp_comp(ParserRuleContext ctx) {
        processArithmeticExpression(ctx);
    }
    
    public void exitExpresion(ParserRuleContext ctx) {
        processComparisonExpression(ctx);
    }
    
    private void processArithmeticExpression(ParserRuleContext ctx) {
        // Buscar operadores en el contexto
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            String operator = ctx.getChild(i).getText();
            if (operator.matches("[+\\-*/]")) {
                if (typeStack.size() >= 2) {
                    DataType rightType = typeStack.pop();
                    DataType leftType = typeStack.pop();
                    
                    DataType resultType = semanticCube.getResultType(operator, leftType, rightType);
                    
                    if (resultType == DataType.ERROR) {
                        errors.add("Error: Tipos incompatibles en operación '" + operator + 
                                  "' entre " + leftType + " y " + rightType);
                        typeStack.push(DataType.ERROR);
                    } else {
                        typeStack.push(resultType);
                    }
                }
            }
        }
    }
    
    private void processComparisonExpression(ParserRuleContext ctx) {
        // Buscar operadores de comparación
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            String operator = ctx.getChild(i).getText();
            if (operator.matches("==|!=|<|>")) {
                if (typeStack.size() >= 2) {
                    DataType rightType = typeStack.pop();
                    DataType leftType = typeStack.pop();
                    
                    DataType resultType = semanticCube.getResultType(operator, leftType, rightType);
                    
                    if (resultType == DataType.ERROR) {
                        errors.add("Error: Tipos incompatibles en comparación '" + operator + 
                                  "' entre " + leftType + " y " + rightType);
                        typeStack.push(DataType.ERROR);
                    } else {
                        typeStack.push(resultType);
                    }
                }
            }
        }
    }
    
    // ===== PUNTO NEURÁLGICO 6: Regla asignacion =====
    public void exitAsignacion(ParserRuleContext ctx) {
        String varName = ctx.getChild(0).getText(); // ID
        
        // Obtener tipo de ID (LHS)
        Variable var = procTable.searchVariable(varName);
        if (var == null) {
            errors.add("Error: Variable '" + varName + "' no declarada");
            return;
        }
        
        // Obtener tipo de expresion (RHS)
        if (typeStack.isEmpty()) {
            errors.add("Error: Expresión inválida en asignación");
            return;
        }
        
        DataType rhsType = typeStack.pop();
        DataType lhsType = var.getType();
        
        // Verificar compatibilidad en asignación
        if (!semanticCube.isValidAssignment(lhsType, rhsType)) {
            errors.add("Error: Tipo incompatible para asignación. No se puede asignar " + 
                      rhsType + " a '" + varName + "' de tipo " + lhsType);
        } else {
            System.out.println("Asignación válida: " + varName + " = " + rhsType);
        }
    }
    
    // ===== PUNTO NEURÁLGICO 7: Reglas de Control de Flujo =====
    public void exitCondicion(ParserRuleContext ctx) {
        validateControlFlowCondition("IF");
    }
    
    public void exitCiclo_w(ParserRuleContext ctx) {
        validateControlFlowCondition("WHILE");
    }
    
    public void exitCiclo_do_w(ParserRuleContext ctx) {
        validateControlFlowCondition("DO-WHILE");
    }
    
    private void validateControlFlowCondition(String statementType) {
        if (typeStack.isEmpty()) {
            errors.add("Error: Se esperaba una expresión en la condición de " + statementType);
            return;
        }
        
        DataType conditionType = typeStack.pop();
        if (conditionType != DataType.BOOLEAN_CONDITION && conditionType != DataType.INT) {
            errors.add("Error: Se esperaba una expresión booleana/comparación en la condición de " + 
                      statementType);
        }
    }
    
    // ===== MÉTODOS AUXILIARES =====
    private DataType getDataTypeFromString(String typeStr) {
        switch (typeStr) {
            case "int":
                return DataType.INT;
            case "float":
                return DataType.FLOAT;
            case "void":
                return DataType.VOID;
            default:
                return DataType.ERROR;
        }
    }
    
    // Getters para acceder a los resultados
    public List<String> getErrors() {
        return errors;
    }
    
    public ProcTable getProcTable() {
        return procTable;
    }
    
    public boolean hasErrors() {
        return !errors.isEmpty();
    }
} 