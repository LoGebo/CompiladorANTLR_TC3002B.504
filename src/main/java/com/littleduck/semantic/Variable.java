package com.littleduck.semantic;

/**
 * Clase que representa una variable en la tabla de símbolos
 */
public class Variable {
    private String name;
    private DataType type;
    private String scope;
    
    public Variable(String name, DataType type, String scope) {
        this.name = name;
        this.type = type;
        this.scope = scope;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public DataType getType() {
        return type;
    }
    
    public String getScope() {
        return scope;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setType(DataType type) {
        this.type = type;
    }
    
    public void setScope(String scope) {
        this.scope = scope;
    }
    
    @Override
    public String toString() {
        return "Variable{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", scope='" + scope + '\'' +
                '}';
    }
} 