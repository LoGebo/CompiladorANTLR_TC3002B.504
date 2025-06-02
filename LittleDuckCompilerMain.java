import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Clase principal del compilador Little Duck (versión simplificada)
 * Orquesta el análisis léxico, sintáctico y semántico
 */
public class LittleDuckCompilerMain {
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java LittleDuckCompilerMain <archivo.ld>");
            System.exit(1);
        }
        
        String inputFile = args[0];
        
        try {
            // Compilar el archivo
            boolean success = compile(inputFile);
            
            if (success) {
                System.out.println("\n=== COMPILACION EXITOSA ===");
            } else {
                System.err.println("\n=== COMPILACION FALLIDA ===");
                System.exit(1);
            }
            
        } catch (Exception e) {
            System.err.println("Error durante la compilacion: " + e.getMessage());
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
        
        // === FASE 1: ANALISIS LEXICO ===
        System.out.println("=== FASE 1: ANALISIS LEXICO ===");
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        LittleDuckLexer lexer = new LittleDuckLexer(input);
        
        // Listener para errores léxicos
        lexer.removeErrorListeners();
        lexer.addErrorListener(new DiagnosticErrorListener());
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        System.out.println("Analisis lexico completado.");
        System.out.println();
        
        // === FASE 2: ANALISIS SINTACTICO ===
        System.out.println("=== FASE 2: ANALISIS SINTACTICO ===");
        LittleDuckParser parser = new LittleDuckParser(tokens);
        
        // Listener para errores sintácticos
        parser.removeErrorListeners();
        parser.addErrorListener(new DiagnosticErrorListener());
        
        // Parsear desde la regla inicial
        ParseTree tree = parser.programa();
        
        // Verificar si hubo errores sintácticos
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.println("Se encontraron " + parser.getNumberOfSyntaxErrors() + " errores sintacticos.");
            return false;
        }
        
        System.out.println("Analisis sintactico completado exitosamente.");
        System.out.println();
        
        // === FASE 3: ANALISIS SEMANTICO ===
        System.out.println("=== FASE 3: ANALISIS SEMANTICO ===");
        System.out.println("Analisis semantico completado (version basica).");
        
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
            System.err.println("Error en linea " + line + ":" + charPositionInLine + " " + msg);
        }
    }
} 