package com.littleduck;

import com.littleduck.semantic.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 * Versión simplificada del compilador Little Duck
 * Demuestra la funcionalidad sin depender de ANTLR
 */
public class SimpleLittleDuckCompiler {
    
    private static final Map<String, String> TOKENS = new HashMap<>();
    static {
        // Palabras reservadas
        TOKENS.put("program", "PROGRAM");
        TOKENS.put("main", "MAIN");
        TOKENS.put("end", "END");
        TOKENS.put("var", "VAR");
        TOKENS.put("int", "INT");
        TOKENS.put("float", "FLOAT");
        TOKENS.put("void", "VOID");
        TOKENS.put("if", "IF");
        TOKENS.put("else", "ELSE");
        TOKENS.put("while", "WHILE");
        TOKENS.put("do", "DO");
        TOKENS.put("print", "PRINT");
    }
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java SimpleLittleDuckCompiler <archivo.ld>");
            System.exit(1);
        }
        
        String inputFile = args[0];
        
        try {
            boolean success = compile(inputFile);
            
            if (success) {
                System.out.println("\n=== COMPILACIÓN EXITOSA ===");
            } else {
                System.err.println("\n=== COMPILACIÓN FALLIDA ===");
                System.exit(1);
            }
            
        } catch (Exception e) {
            System.err.println("Error durante la compilación: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public static boolean compile(String inputFile) throws IOException {
        System.out.println("=== COMPILADOR LITTLE DUCK (VERSIÓN SIMPLIFICADA) ===");
        System.out.println("Compilando archivo: " + inputFile);
        System.out.println();
        
        // Leer el archivo
        String sourceCode = readFile(inputFile);
        
        // === FASE 1: ANÁLISIS LÉXICO ===
        System.out.println("=== FASE 1: ANÁLISIS LÉXICO ===");
        List<Token> tokens = lexicalAnalysis(sourceCode);
        
        if (tokens == null) {
            System.err.println("Errores en el análisis léxico.");
            return false;
        }
        
        System.out.println("Análisis léxico completado. Tokens encontrados: " + tokens.size());
        System.out.println();
        
        // === FASE 2: ANÁLISIS SINTÁCTICO ===
        System.out.println("=== FASE 2: ANÁLISIS SINTÁCTICO ===");
        ParseResult parseResult = syntacticAnalysis(tokens);
        
        if (!parseResult.success) {
            System.err.println("Errores en el análisis sintáctico: " + parseResult.error);
            return false;
        }
        
        System.out.println("Análisis sintáctico completado exitosamente.");
        System.out.println();
        
        // === FASE 3: ANÁLISIS SEMÁNTICO ===
        System.out.println("=== FASE 3: ANÁLISIS SEMÁNTICO ===");
        boolean semanticSuccess = semanticAnalysis(parseResult);
        
        if (!semanticSuccess) {
            return false;
        }
        
        System.out.println("Análisis semántico completado exitosamente.");
        System.out.println();
        
        return true;
    }
    
    private static String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
    
    private static List<Token> lexicalAnalysis(String sourceCode) {
        List<Token> tokens = new ArrayList<>();
        
        // Patrones de tokens
        Pattern[] patterns = {
            Pattern.compile("\\b(program|main|end|var|int|float|void|if|else|while|do|print)\\b"),
            Pattern.compile("\\b[a-zA-Z][a-zA-Z0-9]*\\b"),
            Pattern.compile("\\b[0-9]+\\.[0-9]+\\b"),
            Pattern.compile("\\b[0-9]+\\b"),
            Pattern.compile("\"[^\"]*\""),
            Pattern.compile("==|!=|<=|>=|[+\\-*/=<>(){}:;,.]"),
            Pattern.compile("\\s+")
        };
        
        String[] tokenTypes = {"KEYWORD", "ID", "CTE_FLOAT", "CTE_INT", "CTE_STRING", "OPERATOR", "WHITESPACE"};
        
        int pos = 0;
        while (pos < sourceCode.length()) {
            boolean matched = false;
            
            for (int i = 0; i < patterns.length; i++) {
                Matcher matcher = patterns[i].matcher(sourceCode);
                matcher.region(pos, sourceCode.length());
                
                if (matcher.lookingAt()) {
                    String text = matcher.group();
                    
                    if (!tokenTypes[i].equals("WHITESPACE")) {
                        String type = tokenTypes[i];
                        if (type.equals("KEYWORD")) {
                            type = TOKENS.getOrDefault(text, "ID");
                        }
                        tokens.add(new Token(type, text, pos));
                    }
                    
                    pos = matcher.end();
                    matched = true;
                    break;
                }
            }
            
            if (!matched) {
                System.err.println("Error léxico: carácter no reconocido '" + sourceCode.charAt(pos) + "' en posición " + pos);
                return null;
            }
        }
        
        return tokens;
    }
    
    private static ParseResult syntacticAnalysis(List<Token> tokens) {
        // Análisis sintáctico simplificado
        // Verifica la estructura básica: program ID ; [var ...] main() { ... } end.
        
        int pos = 0;
        
        try {
            // program ID ;
            if (!expectToken(tokens, pos++, "PROGRAM")) return error("Se esperaba 'program'");
            if (!expectToken(tokens, pos++, "ID")) return error("Se esperaba identificador del programa");
            if (!expectToken(tokens, pos++, "OPERATOR", ";")) return error("Se esperaba ';'");
            
            // var declarations (opcional)
            if (pos < tokens.size() && tokens.get(pos).type.equals("VAR")) {
                pos++; // consume 'var'
                
                // Procesar declaraciones de variables
                while (pos < tokens.size() && !tokens.get(pos).type.equals("MAIN")) {
                    if (!expectToken(tokens, pos++, "ID")) return error("Se esperaba identificador de variable");
                    
                    // Puede haber más IDs separados por comas
                    while (pos < tokens.size() && tokens.get(pos).text.equals(",")) {
                        pos++; // consume ','
                        if (!expectToken(tokens, pos++, "ID")) return error("Se esperaba identificador de variable");
                    }
                    
                    if (!expectToken(tokens, pos++, "OPERATOR", ":")) return error("Se esperaba ':'");
                    if (!expectTokenType(tokens, pos++, "INT", "FLOAT", "VOID")) return error("Se esperaba tipo de dato");
                    if (!expectToken(tokens, pos++, "OPERATOR", ";")) return error("Se esperaba ';'");
                }
            }
            
            // main() { ... } end.
            if (!expectToken(tokens, pos++, "MAIN")) return error("Se esperaba 'main'");
            if (!expectToken(tokens, pos++, "OPERATOR", "(")) return error("Se esperaba '('");
            if (!expectToken(tokens, pos++, "OPERATOR", ")")) return error("Se esperaba ')'");
            if (!expectToken(tokens, pos++, "OPERATOR", "{")) return error("Se esperaba '{'");
            
            // Procesar estatutos dentro del bloque principal
            int braceCount = 1;
            while (pos < tokens.size() && braceCount > 0) {
                Token token = tokens.get(pos++);
                if (token.text.equals("{")) {
                    braceCount++;
                } else if (token.text.equals("}")) {
                    braceCount--;
                }
            }
            
            if (!expectToken(tokens, pos++, "END")) return error("Se esperaba 'end'");
            if (!expectToken(tokens, pos++, "OPERATOR", ".")) return error("Se esperaba '.'");
            
            return new ParseResult(true, null, tokens);
            
        } catch (IndexOutOfBoundsException e) {
            return error("Final inesperado del archivo");
        }
    }
    
    private static boolean expectToken(List<Token> tokens, int pos, String expectedType) {
        return pos < tokens.size() && tokens.get(pos).type.equals(expectedType);
    }
    
    private static boolean expectToken(List<Token> tokens, int pos, String expectedType, String expectedText) {
        return pos < tokens.size() && 
               tokens.get(pos).type.equals(expectedType) && 
               tokens.get(pos).text.equals(expectedText);
    }
    
    private static boolean expectTokenType(List<Token> tokens, int pos, String... expectedTypes) {
        if (pos >= tokens.size()) return false;
        String tokenType = tokens.get(pos).type;
        for (String expected : expectedTypes) {
            if (tokenType.equals(expected)) return true;
        }
        return false;
    }
    
    private static ParseResult error(String message) {
        return new ParseResult(false, message, null);
    }
    
    private static boolean semanticAnalysis(ParseResult parseResult) {
        // Análisis semántico simplificado usando las clases que creamos
        ProcTable procTable = new ProcTable();
        SemanticCube semanticCube = new SemanticCube();
        List<String> errors = new ArrayList<>();
        
        List<Token> tokens = parseResult.tokens;
        
        // Crear ámbito global
        procTable.addFunction("global", DataType.VOID);
        procTable.setCurrentScope("global");
        
        // Procesar declaraciones de variables
        int pos = 0;
        while (pos < tokens.size()) {
            Token token = tokens.get(pos);
            
            if (token.type.equals("VAR")) {
                pos++; // consume 'var'
                
                // Procesar declaraciones
                while (pos < tokens.size() && !tokens.get(pos).type.equals("MAIN")) {
                    List<String> varNames = new ArrayList<>();
                    
                    // Recoger nombres de variables
                    varNames.add(tokens.get(pos++).text); // primer ID
                    while (pos < tokens.size() && tokens.get(pos).text.equals(",")) {
                        pos++; // consume ','
                        varNames.add(tokens.get(pos++).text); // siguiente ID
                    }
                    
                    pos++; // consume ':'
                    DataType tipo = DataType.valueOf(tokens.get(pos++).type); // tipo
                    pos++; // consume ';'
                    
                    // Añadir variables a la tabla
                    for (String varName : varNames) {
                        boolean added = procTable.addVariableToFunction("global", varName, tipo);
                        if (!added) {
                            errors.add("Error: Variable '" + varName + "' doblemente declarada");
                        } else {
                            System.out.println("Variable '" + varName + "' de tipo " + tipo + " declarada en ámbito global");
                        }
                    }
                }
            } else if (token.type.equals("MAIN")) {
                // Crear ámbito main
                procTable.addFunction("main", DataType.VOID);
                procTable.setCurrentScope("main");
                System.out.println("Entrando al ámbito 'main'");
                break;
            }
            pos++;
        }
        
        // Mostrar tabla de símbolos
        System.out.println("\n=== TABLA DE SÍMBOLOS ===");
        System.out.println(procTable);
        
        if (!errors.isEmpty()) {
            System.err.println("Se encontraron " + errors.size() + " errores semánticos:");
            for (String error : errors) {
                System.err.println("  " + error);
            }
            return false;
        }
        
        return true;
    }
    
    // Clases auxiliares
    static class Token {
        String type;
        String text;
        int position;
        
        Token(String type, String text, int position) {
            this.type = type;
            this.text = text;
            this.position = position;
        }
        
        @Override
        public String toString() {
            return type + "(" + text + ")";
        }
    }
    
    static class ParseResult {
        boolean success;
        String error;
        List<Token> tokens;
        
        ParseResult(boolean success, String error, List<Token> tokens) {
            this.success = success;
            this.error = error;
            this.tokens = tokens;
        }
    }
} 