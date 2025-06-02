# Compilador Little Duck

Este proyecto implementa un compilador completo para el lenguaje Little Duck, incluyendo análisis léxico, sintáctico y semántico usando ANTLR 4.

## Descripción

Little Duck es un lenguaje de programación educativo diseñado para enseñar los conceptos fundamentales de compiladores. Este compilador implementa:

- **Análisis Léxico**: Reconocimiento de tokens (palabras reservadas, identificadores, constantes, operadores, delimitadores)
- **Análisis Sintáctico**: Validación de la estructura gramatical del programa
- **Análisis Semántico**: Verificación de tipos, gestión de símbolos y validación de ámbitos

## Características del Lenguaje

### Palabras Reservadas
- `program`, `main`, `end`, `var`
- `int`, `float`, `void`
- `if`, `else`, `while`, `do`, `print`

### Tipos de Datos
- `int`: Números enteros
- `float`: Números de punto flotante

### Operadores
- Aritméticos: `+`, `-`, `*`, `/`
- Comparación: `==`, `!=`, `<`, `>`
- Asignación: `=`

### Estructura de un Programa
```littleduck
program NombrePrograma;
var
    variable1, variable2 : int;
    variable3 : float;
main()
{
    // estatutos
}
end.
```

## Requisitos

- Java 11 o superior
- Maven 3.6 o superior
- ANTLR 4.13.1 (incluido en las dependencias)

## Instalación

1. **Clonar el repositorio:**
```bash
git clone <url-del-repositorio>
cd Compilador
```

2. **Compilar el proyecto:**
```bash
mvn clean compile
```

3. **Generar las clases de ANTLR:**
```bash
mvn antlr4:antlr4
```

4. **Crear el JAR ejecutable:**
```bash
mvn package
```

## Uso

### Compilar desde línea de comandos

```bash
# Usando Maven
mvn exec:java -Dexec.mainClass="com.littleduck.LittleDuckCompiler" -Dexec.args="test_files/test1_minimal.ld"

# Usando el JAR ejecutable
java -jar target/little-duck-compiler-1.0.0.jar test_files/test1_minimal.ld
```

### Archivos de Prueba

El proyecto incluye varios archivos de prueba en el directorio `test_files/`:

#### Programas Válidos:
- `test1_minimal.ld`: Programa mínimo válido
- `test2_variables.ld`: Declaración de variables
- `test3_expressions.ld`: Expresiones aritméticas y asignaciones
- `test4_control_structures.ld`: Estructuras de control (if, while, do-while)
- `test5_print.ld`: Uso del statement print

#### Programas con Errores:
- `error1_undeclared_variable.ld`: Variable no declarada
- `error2_duplicate_variable.ld`: Variable doblemente declarada
- `error3_type_mismatch.ld`: Incompatibilidad de tipos

### Ejemplo de Uso

```bash
# Compilar un programa válido
java -jar target/little-duck-compiler-1.0.0.jar test_files/test3_expressions.ld

# Salida esperada:
=== COMPILADOR LITTLE DUCK ===
Compilando archivo: test_files/test3_expressions.ld

=== FASE 1: ANÁLISIS LÉXICO ===
Análisis léxico completado.

=== FASE 2: ANÁLISIS SINTÁCTICO ===
Análisis sintáctico completado exitosamente.

=== FASE 3: ANÁLISIS SEMÁNTICO ===
Iniciando análisis semántico del programa: TestExpr
Variable 'i' de tipo INT declarada en ámbito global
Variable 'j' de tipo INT declarada en ámbito global
Variable 'result' de tipo FLOAT declarada en ámbito global
Entrando al ámbito 'main'
Variable 'i' encontrada con tipo INT
Asignación válida: i = INT
Variable 'i' encontrada con tipo INT
Variable 'j' encontrada con tipo INT
Asignación válida: j = FLOAT
Variable 'i' encontrada con tipo INT
Variable 'j' encontrada con tipo INT
Variable 'result' encontrada con tipo FLOAT
Asignación válida: result = FLOAT
Análisis semántico completado exitosamente.

=== TABLA DE SÍMBOLOS ===
[Información de las tablas de símbolos]

=== COMPILACIÓN EXITOSA ===
```

## Arquitectura del Compilador

### Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/littleduck/
│   │   ├── LittleDuckCompiler.java          # Clase principal
│   │   └── semantic/
│   │       ├── DataType.java                # Tipos de datos
│   │       ├── Variable.java                # Clase Variable
│   │       ├── VarTable.java                # Tabla de Variables
│   │       ├── Function.java                # Clase Function
│   │       ├── ProcTable.java               # Directorio de Funciones
│   │       ├── SemanticCube.java            # Cubo Semántico
│   │       └── LittleDuckSemanticListener.java # Listener semántico
│   └── antlr4/
│       ├── LittleDuckLexer.g4              # Gramática del lexer
│       └── LittleDuckParser.g4             # Gramática del parser
test_files/                                  # Archivos de prueba
```

### Componentes Principales

1. **Analizador Léxico (Lexer)**: Definido en `LittleDuckLexer.g4`
2. **Analizador Sintáctico (Parser)**: Definido en `LittleDuckParser.g4`
3. **Analizador Semántico**: Implementado en `LittleDuckSemanticListener.java`
4. **Tablas de Símbolos**: `ProcTable` y `VarTable`
5. **Cubo Semántico**: `SemanticCube` para verificación de tipos

## Análisis Semántico

El análisis semántico implementa:

### Gestión de Símbolos
- **Directorio de Funciones (ProcTable)**: Almacena información sobre funciones
- **Tablas de Variables (VarTable)**: Una por cada ámbito

### Verificación de Tipos
- **Cubo Semántico**: Define compatibilidad de tipos en operaciones
- Validación de asignaciones
- Promoción automática de tipos (int → float)

### Validaciones Implementadas
- Variables declaradas antes de su uso
- No re-declaración de variables en el mismo ámbito
- Compatibilidad de tipos en asignaciones
- Tipos válidos en expresiones aritméticas y de comparación
- Condiciones válidas en estructuras de control

## Desarrollo y Extensión

### Agregar Nuevas Características

1. **Modificar la gramática** en los archivos `.g4`
2. **Regenerar las clases ANTLR**:
   ```bash
   mvn antlr4:antlr4
   ```
3. **Actualizar el analizador semántico** si es necesario
4. **Agregar pruebas** en el directorio `test_files/`

### Ejecutar Pruebas

```bash
# Probar todos los archivos válidos
for file in test_files/test*.ld; do
    echo "Probando $file"
    java -jar target/little-duck-compiler-1.0.0.jar "$file"
    echo "---"
done

# Probar archivos con errores
for file in test_files/error*.ld; do
    echo "Probando $file (debe fallar)"
    java -jar target/little-duck-compiler-1.0.0.jar "$file"
    echo "---"
done
```

## Herramientas de Desarrollo

### ANTLR TestRig (grun)

Para debugging con la herramienta `grun` de ANTLR:

```bash
# Instalar ANTLR standalone
curl -O https://www.antlr.org/download/antlr-4.13.1-complete.jar

# Compilar gramáticas
java -jar antlr-4.13.1-complete.jar -cp . *.g4

# Probar lexer
java -jar antlr-4.13.1-complete.jar org.antlr.v4.gui.TestRig LittleDuckLexer tokens -tokens test_files/test1_minimal.ld

# Probar parser con GUI
java -jar antlr-4.13.1-complete.jar org.antlr.v4.gui.TestRig LittleDuckParser programa -gui test_files/test1_minimal.ld
```

## Autor

Implementado siguiendo las especificaciones del documento "Entrega 2: Analizador Léxico y Sintáctico para Little Duck (Expandido con Entrega 3: Análisis Semántico)".

## Licencia

Este proyecto es con fines educativos. 