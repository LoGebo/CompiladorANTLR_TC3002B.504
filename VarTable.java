package com.littleduck.semantic;

import java.util.HashMap;
import java.util.Map;

/**
 * Tabla de Variables para un ámbito específico
 */
public class VarTable {
    private Map<String, Variable> variables;
    private String scope;
    
    public VarTable(String scope) {
        this.variables = new HashMap<>();
        this.scope = scope;
    }
    
    /**
     * Añade una nueva variable a la tabla del ámbito actual.
     * Verifica si ya existe en ese ámbito para evitar re-declaraciones locales.
     */
    public boolean addVariable(String name, DataType type) {
        if (variables.containsKey(name)) {
            return false; // Variable ya existe
        }
        variables.put(name, new Variable(name, type, scope));
        return true;
    }
    
    /**
     * Retorna el objeto con la información de la variable
     */
    public Variable getVariable(String name) {
        return variables.get(name);
    }
    
    /**
     * Verifica si una variable ya ha sido declarada en el ámbito actual
     */
    public boolean doesVariableExist(String name) {
        return variables.containsKey(name);
    }
    
    /**
     * Retorna el tipo de la variable
     */
    public DataType getVariableType(String name) {
        Variable var = variables.get(name);
        return var != null ? var.getType() : null;
    }
    
    /**
     * Retorna todas las variables de esta tabla
     */
    public Map<String, Variable> getAllVariables() {
        return new HashMap<>(variables);
    }
    
    /**
     * Retorna el ámbito de esta tabla
     */
    public String getScope() {
        return scope;
    }
    
    @Override
    public String toString() {
        return "VarTable{" +
                "scope='" + scope + '\'' +
                ", variables=" + variables +
                '}';
    }
} 