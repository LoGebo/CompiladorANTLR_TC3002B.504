package com.littleduck;

import com.littleduck.semantic.LittleDuckSemanticListener;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Clase principal del compilador Little Duck
 * Orquesta el análisis léxico, sintáctico y semántico
 */
public class LittleDuckCompiler {
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java LittleDuckCompiler <archivo.ld>");
            System.exit(1);
        }
        
        String inputFile = args[0];
        
        try {
            // Compilar el archivo
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
    
    /**
     * Compila un archivo Little Duck
     * @param inputFile Ruta al archivo de entrada
     * @return true si la compilación fue exitosa, false si hubo errores
     */
    public static boolean compile(String inputFile) throws IOException {
        System.out.println("=== COMPILADOR LITTLE DUCK ===");
        System.out.println("Compilando archivo: " + inputFile);
        System.out.println();
        
        // Crear input stream
        InputStream inputStream = new FileInputStream(inputFile);
        
        // === FASE 1: ANÁLISIS LÉXICO ===
        System.out.println("=== FASE 1: ANÁLISIS LÉXICO ===");
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        LittleDuckLexer lexer = new LittleDuckLexer(input);
        
        // Listener para errores léxicos
        lexer.removeErrorListeners();
        lexer.addErrorListener(new DiagnosticErrorListener());
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Mostrar tokens (opcional, para debugging)
        // tokens.fill();
        // System.out.println("Tokens encontrados:");
        // for (Token token : tokens.getTokens()) {
        //     System.out.println(token);
        // }
        
        System.out.println("Análisis léxico completado.");
        System.out.println();
        
        // === FASE 2: ANÁLISIS SINTÁCTICO ===
        System.out.println("=== FASE 2: ANÁLISIS SINTÁCTICO ===");
        LittleDuckParser parser = new LittleDuckParser(tokens);
        
        // Listener para errores sintácticos
        parser.removeErrorListeners();
        parser.addErrorListener(new DiagnosticErrorListener());
        
        // Parsear desde la regla inicial
        ParseTree tree = parser.programa();
        
        // Verificar si hubo errores sintácticos
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.println("Se encontraron " + parser.getNumberOfSyntaxErrors() + " errores sintácticos.");
            return false;
        }
        
        System.out.println("Análisis sintáctico completado exitosamente.");
        System.out.println();
        
        // === FASE 3: ANÁLISIS SEMÁNTICO ===
        System.out.println("=== FASE 3: ANÁLISIS SEMÁNTICO ===");
        
        // Crear el listener semántico
        LittleDuckSemanticListener semanticListener = new LittleDuckSemanticListener();
        
        // Recorrer el árbol de sintaxis
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(semanticListener, tree);
        
        // Verificar errores semánticos
        if (semanticListener.hasErrors()) {
            System.err.println("Se encontraron " + semanticListener.getErrors().size() + " errores semánticos:");
            for (String error : semanticListener.getErrors()) {
                System.err.println("  " + error);
            }
            return false;
        }
        
        System.out.println("Análisis semántico completado exitosamente.");
        System.out.println();
        
        // Mostrar información de las tablas de símbolos
        System.out.println("=== TABLA DE SÍMBOLOS ===");
        System.out.println(semanticListener.getProcTable());
        
        return true;
    }
    
    /**
     * Listener personalizado para errores de ANTLR
     */
    static class DiagnosticErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                              int line, int charPositionInLine, String msg, 
                              RecognitionException e) {
            System.err.println("Error en línea " + line + ":" + charPositionInLine + " " + msg);
        }
    }
} 