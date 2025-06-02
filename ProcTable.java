package com.littleduck.semantic;

import java.util.HashMap;
import java.util.Map;

/**
 * Directorio de Funciones (ProcTable) - almacena información sobre las funciones definidas
 */
public class ProcTable {
    private Map<String, Function> functions;
    private String currentScope;
    
    public ProcTable() {
        this.functions = new HashMap<>();
        this.currentScope = "global";
    }
    
    /**
     * Añade una nueva función al directorio. Verifica si ya existe para evitar redefiniciones.
     * Crea su VarTable asociada.
     */
    public boolean addFunction(String name, DataType returnType) {
        if (functions.containsKey(name)) {
            return false; // Función ya existe
        }
        functions.put(name, new Function(name, returnType));
        return true;
    }
    
    /**
     * Retorna el objeto con la información de la función
     */
    public Function getFunction(String name) {
        return functions.get(name);
    }
    
    /**
     * Verifica si una función ya ha sido declarada
     */
    public boolean doesFunctionExist(String name) {
        return functions.containsKey(name);
    }
    
    /**
     * Delega la adición de una variable a la VarTable de la función especificada
     */
    public boolean addVariableToFunction(String functionName, String varName, DataType varType) {
        Function function = functions.get(functionName);
        if (function == null) {
            return false;
        }
        return function.getVarTable().addVariable(varName, varType);
    }
    
    /**
     * Busca una variable en la VarTable de la función
     */
    public Variable getVariableFromFunction(String functionName, String varName) {
        Function function = functions.get(functionName);
        if (function == null) {
            return null;
        }
        return function.getVarTable().getVariable(varName);
    }
    
    /**
     * Busca una variable en el ámbito actual primero, luego en global
     */
    public Variable searchVariable(String varName) {
        // Buscar en ámbito actual
        Variable var = getVariableFromFunction(currentScope, varName);
        if (var != null) {
            return var;
        }
        
        // Si no está en ámbito actual y no es global, buscar en global
        if (!currentScope.equals("global")) {
            var = getVariableFromFunction("global", varName);
        }
        
        return var;
    }
    
    /**
     * Obtiene el tipo de una variable buscando en los ámbitos apropiados
     */
    public DataType getVariableType(String varName) {
        Variable var = searchVariable(varName);
        return var != null ? var.getType() : null;
    }
    
    // Getters y Setters
    public String getCurrentScope() {
        return currentScope;
    }
    
    public void setCurrentScope(String currentScope) {
        this.currentScope = currentScope;
    }
    
    public Map<String, Function> getAllFunctions() {
        return new HashMap<>(functions);
    }
    
    @Override
    public String toString() {
        return "ProcTable{" +
                "currentScope='" + currentScope + '\'' +
                ", functions=" + functions +
                '}';
    }
} 