package com.littleduck.semantic;

/**
 * Clase que representa una función en el Directorio de Funciones
 */
public class Function {
    private String name;
    private DataType returnType;
    private VarTable varTable;
    
    public Function(String name, DataType returnType) {
        this.name = name;
        this.returnType = returnType;
        this.varTable = new VarTable(name);
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public DataType getReturnType() {
        return returnType;
    }
    
    public VarTable getVarTable() {
        return varTable;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setReturnType(DataType returnType) {
        this.returnType = returnType;
    }
    
    public void setVarTable(VarTable varTable) {
        this.varTable = varTable;
    }
    
    @Override
    public String toString() {
        return "Function{" +
                "name='" + name + '\'' +
                ", returnType=" + returnType +
                ", varTable=" + varTable +
                '}';
    }
} 