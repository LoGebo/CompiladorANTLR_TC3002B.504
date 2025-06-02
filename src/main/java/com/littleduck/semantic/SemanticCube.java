package com.littleduck.semantic;

import java.util.HashMap;
import java.util.Map;

/**
 * Cubo Semántico - define el tipo resultante de aplicar un operador a operandos de tipos específicos
 */
public class SemanticCube {
    private Map<String, DataType> cube;
    
    public SemanticCube() {
        cube = new HashMap<>();
        initializeCube();
    }
    
    /**
     * Inicializa el cubo semántico según las reglas definidas en el documento
     */
    private void initializeCube() {
        // Operadores aritméticos: +, -, *
        cube.put("+" + DataType.INT + DataType.INT, DataType.INT);
        cube.put("+" + DataType.INT + DataType.FLOAT, DataType.FLOAT);
        cube.put("+" + DataType.FLOAT + DataType.INT, DataType.FLOAT);
        cube.put("+" + DataType.FLOAT + DataType.FLOAT, DataType.FLOAT);
        
        cube.put("-" + DataType.INT + DataType.INT, DataType.INT);
        cube.put("-" + DataType.INT + DataType.FLOAT, DataType.FLOAT);
        cube.put("-" + DataType.FLOAT + DataType.INT, DataType.FLOAT);
        cube.put("-" + DataType.FLOAT + DataType.FLOAT, DataType.FLOAT);
        
        cube.put("*" + DataType.INT + DataType.INT, DataType.INT);
        cube.put("*" + DataType.INT + DataType.FLOAT, DataType.FLOAT);
        cube.put("*" + DataType.FLOAT + DataType.INT, DataType.FLOAT);
        cube.put("*" + DataType.FLOAT + DataType.FLOAT, DataType.FLOAT);
        
        // Operador de división: / (siempre resulta en FLOAT)
        cube.put("/" + DataType.INT + DataType.INT, DataType.FLOAT);
        cube.put("/" + DataType.INT + DataType.FLOAT, DataType.FLOAT);
        cube.put("/" + DataType.FLOAT + DataType.INT, DataType.FLOAT);
        cube.put("/" + DataType.FLOAT + DataType.FLOAT, DataType.FLOAT);
        
        // Operadores de comparación: ==, !=, <, >
        cube.put("==" + DataType.INT + DataType.INT, DataType.BOOLEAN_CONDITION);
        cube.put("==" + DataType.FLOAT + DataType.FLOAT, DataType.BOOLEAN_CONDITION);
        cube.put("==" + DataType.INT + DataType.FLOAT, DataType.BOOLEAN_CONDITION);
        cube.put("==" + DataType.FLOAT + DataType.INT, DataType.BOOLEAN_CONDITION);
        
        cube.put("!=" + DataType.INT + DataType.INT, DataType.BOOLEAN_CONDITION);
        cube.put("!=" + DataType.FLOAT + DataType.FLOAT, DataType.BOOLEAN_CONDITION);
        cube.put("!=" + DataType.INT + DataType.FLOAT, DataType.BOOLEAN_CONDITION);
        cube.put("!=" + DataType.FLOAT + DataType.INT, DataType.BOOLEAN_CONDITION);
        
        cube.put("<" + DataType.INT + DataType.INT, DataType.BOOLEAN_CONDITION);
        cube.put("<" + DataType.FLOAT + DataType.FLOAT, DataType.BOOLEAN_CONDITION);
        cube.put("<" + DataType.INT + DataType.FLOAT, DataType.BOOLEAN_CONDITION);
        cube.put("<" + DataType.FLOAT + DataType.INT, DataType.BOOLEAN_CONDITION);
        
        cube.put(">" + DataType.INT + DataType.INT, DataType.BOOLEAN_CONDITION);
        cube.put(">" + DataType.FLOAT + DataType.FLOAT, DataType.BOOLEAN_CONDITION);
        cube.put(">" + DataType.INT + DataType.FLOAT, DataType.BOOLEAN_CONDITION);
        cube.put(">" + DataType.FLOAT + DataType.INT, DataType.BOOLEAN_CONDITION);
        
        // Operador de asignación: =
        cube.put("=" + DataType.INT + DataType.INT, DataType.INT);
        cube.put("=" + DataType.FLOAT + DataType.FLOAT, DataType.FLOAT);
        cube.put("=" + DataType.FLOAT + DataType.INT, DataType.FLOAT); // Promoción permitida
        // INT = FLOAT resulta en ERROR (pérdida de precisión)
    }
    
    /**
     * Obtiene el tipo resultante de una operación
     * @param operator El operador (+, -, *, /, ==, !=, <, >, =)
     * @param leftType Tipo del operando izquierdo
     * @param rightType Tipo del operando derecho
     * @return Tipo resultante o ERROR si la operación no es válida
     */
    public DataType getResultType(String operator, DataType leftType, DataType rightType) {
        String key = operator + leftType + rightType;
        return cube.getOrDefault(key, DataType.ERROR);
    }
    
    /**
     * Verifica si una operación es válida
     * @param operator El operador
     * @param leftType Tipo del operando izquierdo
     * @param rightType Tipo del operando derecho
     * @return true si la operación es válida, false si no
     */
    public boolean isValidOperation(String operator, DataType leftType, DataType rightType) {
        return getResultType(operator, leftType, rightType) != DataType.ERROR;
    }
    
    /**
     * Verifica si una asignación es válida
     * @param targetType Tipo de la variable de destino
     * @param sourceType Tipo de la expresión a asignar
     * @return true si la asignación es válida, false si no
     */
    public boolean isValidAssignment(DataType targetType, DataType sourceType) {
        return getResultType("=", targetType, sourceType) != DataType.ERROR;
    }
    
    @Override
    public String toString() {
        return "SemanticCube{" +
                "cube=" + cube +
                '}';
    }
} 