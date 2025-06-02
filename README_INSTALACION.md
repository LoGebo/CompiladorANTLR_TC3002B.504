# Compilador Little Duck - Guía de Instalación y Uso

Este proyecto implementa un compilador completo para el lenguaje Little Duck según las especificaciones del documento "Entrega 2: Analizador Léxico y Sintáctico para Little Duck (Expandido con Entrega 3: Análisis Semántico)".

## Requisitos del Sistema

### Opción 1: Versión Completa con ANTLR (Recomendada)
- **Java 11 o superior**
- **Maven 3.6 o superior**
- **ANTLR 4.13.1** (incluido en las dependencias de Maven)

### Opción 2: Versión Simplificada (Sin Maven)
- **Java 11 o superior** únicamente

## Instalación de Java

### Windows
1. Descargar Java desde: https://www.oracle.com/java/technologies/downloads/
2. Instalar el JDK (Java Development Kit)
3. Agregar Java al PATH del sistema:
   - Ir a "Variables de entorno del sistema"
   - Agregar `C:\Program Files\Java\jdk-XX\bin` al PATH
   - Verificar con: `java -version` y `javac -version`

### Verificación
```bash
java -version
javac -version
```

## Instalación de Maven (Solo para Versión Completa)

### Windows
1. Descargar Maven desde: https://maven.apache.org/download.cgi
2. Extraer en `C:\Program Files\Apache\maven`
3. Agregar `C:\Program Files\Apache\maven\bin` al PATH
4. Verificar con: `mvn -version`

## Estructura del Proyecto

```
Compilador/
├── src/main/
│   ├── java/com/littleduck/
│   │   ├── LittleDuckCompiler.java          # Compilador completo con ANTLR
│   │   ├── SimpleLittleDuckCompiler.java    # Versión simplificada
│   │   └── semantic/                        # Clases de análisis semántico
│   │       ├── DataType.java
│   │       ├── Variable.java
│   │       ├── VarTable.java
│   │       ├── Function.java
│   │       ├── ProcTable.java
│   │       ├── SemanticCube.java
│   │       └── LittleDuckSemanticListener.java
│   └── antlr4/                             # Gramáticas ANTLR
│       ├── LittleDuckLexer.g4
│       └── LittleDuckParser.g4
├── test_files/                             # Archivos de prueba
│   ├── test1_minimal.ld
│   ├── test2_variables.ld
│   ├── test3_expressions.ld
│   ├── test4_control_structures.ld
│   ├── test5_print.ld
│   ├── error1_undeclared_variable.ld
│   ├── error2_duplicate_variable.ld
│   └── error3_type_mismatch.ld
├── pom.xml                                 # Configuración Maven
├── build.bat                               # Script de compilación Maven
├── run_tests.bat                           # Script de pruebas Maven
├── compile.bat                             # Script de compilación simple
├── test_simple.bat                         # Script de pruebas simple
└── README.md
```

## Opción 1: Compilación con Maven (Versión Completa)

### 1. Compilar el proyecto
```bash
# Windows
build.bat

# O manualmente:
mvn clean compile
mvn antlr4:antlr4
mvn package
```

### 2. Ejecutar pruebas
```bash
# Windows
run_tests.bat

# O manualmente:
java -jar target/little-duck-compiler-1.0.0.jar test_files/test1_minimal.ld
```

## Opción 2: Compilación Simple (Sin Maven)

### 1. Compilar el proyecto
```bash
# Windows
compile.bat

# O manualmente:
mkdir out\classes
javac -d out\classes src\main\java\com\littleduck\semantic\*.java src\main\java\com\littleduck\SimpleLittleDuckCompiler.java
```

### 2. Ejecutar pruebas
```bash
# Windows
test_simple.bat

# O manualmente:
java -cp out\classes com.littleduck.SimpleLittleDuckCompiler test_files/test1_minimal.ld
```

## Uso del Compilador

### Sintaxis del Lenguaje Little Duck

```littleduck
program NombrePrograma;
var
    variable1, variable2 : int;
    variable3 : float;
main()
{
    variable1 = 10;
    variable2 = variable1 + 5;
    variable3 = variable1 * 2.5;
    
    if (variable1 > 5) {
        print("Mayor que 5");
    } else {
        print("Menor o igual a 5");
    }
    
    while (variable2 < 20) do {
        variable2 = variable2 + 1;
        print("Valor:", variable2);
    }
}
end.
```

### Características Implementadas

#### Análisis Léxico
- ✅ Palabras reservadas: `program`, `main`, `end`, `var`, `int`, `float`, `void`, `if`, `else`, `while`, `do`, `print`
- ✅ Identificadores: `[a-zA-Z][a-zA-Z0-9]*`
- ✅ Constantes enteras: `[0-9]+`
- ✅ Constantes flotantes: `[0-9]+.[0-9]+`
- ✅ Constantes de texto: `"..."`
- ✅ Operadores: `+`, `-`, `*`, `/`, `=`, `==`, `!=`, `<`, `>`
- ✅ Delimitadores: `(`, `)`, `{`, `}`, `;`, `,`, `:`, `.`

#### Análisis Sintáctico
- ✅ Estructura del programa: `program ID; [var ...] main() {...} end.`
- ✅ Declaración de variables: `var id1, id2 : tipo;`
- ✅ Tipos de datos: `int`, `float`, `void`
- ✅ Estatutos: asignación, condición, ciclos, escritura
- ✅ Expresiones aritméticas con precedencia correcta
- ✅ Estructuras de control: `if-else`, `while-do`, `do-while`

#### Análisis Semántico
- ✅ **Directorio de Funciones (ProcTable)**: Gestión de ámbitos
- ✅ **Tablas de Variables (VarTable)**: Variables por ámbito
- ✅ **Cubo Semántico**: Compatibilidad de tipos en operaciones
- ✅ **Validaciones**:
  - Variables declaradas antes de su uso
  - No re-declaración de variables en el mismo ámbito
  - Compatibilidad de tipos en asignaciones
  - Promoción automática de tipos (int → float)
  - Tipos válidos en expresiones y condiciones

### Ejemplos de Uso

#### Programa Válido
```bash
java -cp out\classes com.littleduck.SimpleLittleDuckCompiler test_files/test2_variables.ld
```

**Salida esperada:**
```
=== COMPILADOR LITTLE DUCK (VERSIÓN SIMPLIFICADA) ===
Compilando archivo: test_files/test2_variables.ld

=== FASE 1: ANÁLISIS LÉXICO ===
Análisis léxico completado. Tokens encontrados: 25

=== FASE 2: ANÁLISIS SINTÁCTICO ===
Análisis sintáctico completado exitosamente.

=== FASE 3: ANÁLISIS SEMÁNTICO ===
Variable 'i' de tipo INT declarada en ámbito global
Variable 'j' de tipo INT declarada en ámbito global
Variable 'k' de tipo INT declarada en ámbito global
Variable 'x' de tipo FLOAT declarada en ámbito global
Variable 'y' de tipo FLOAT declarada en ámbito global
Variable 'flag' de tipo INT declarada en ámbito global
Entrando al ámbito 'main'

=== TABLA DE SÍMBOLOS ===
[Información de las tablas de símbolos]

Análisis semántico completado exitosamente.

=== COMPILACIÓN EXITOSA ===
```

#### Programa con Error
```bash
java -cp out\classes com.littleduck.SimpleLittleDuckCompiler test_files/error2_duplicate_variable.ld
```

**Salida esperada:**
```
=== COMPILADOR LITTLE DUCK (VERSIÓN SIMPLIFICADA) ===
Compilando archivo: test_files/error2_duplicate_variable.ld

=== FASE 1: ANÁLISIS LÉXICO ===
Análisis léxico completado. Tokens encontrados: 18

=== FASE 2: ANÁLISIS SINTÁCTICO ===
Análisis sintáctico completado exitosamente.

=== FASE 3: ANÁLISIS SEMÁNTICO ===
Variable 'x' de tipo INT declarada en ámbito global
Error: Variable 'x' doblemente declarada
Entrando al ámbito 'main'

=== TABLA DE SÍMBOLOS ===
[Información de las tablas de símbolos]

Se encontraron 1 errores semánticos:
  Error: Variable 'x' doblemente declarada

=== COMPILACIÓN FALLIDA ===
```

## Archivos de Prueba Incluidos

### Programas Válidos
1. **test1_minimal.ld**: Programa mínimo válido
2. **test2_variables.ld**: Declaración de múltiples variables
3. **test3_expressions.ld**: Expresiones aritméticas y asignaciones
4. **test4_control_structures.ld**: Estructuras de control completas
5. **test5_print.ld**: Uso del statement print

### Programas con Errores
1. **error1_undeclared_variable.ld**: Variable no declarada
2. **error2_duplicate_variable.ld**: Variable doblemente declarada
3. **error3_type_mismatch.ld**: Incompatibilidad de tipos

## Solución de Problemas

### Error: "java no se reconoce como comando"
- Instalar Java JDK
- Agregar Java al PATH del sistema
- Reiniciar la terminal

### Error: "mvn no se reconoce como comando"
- Instalar Maven
- Agregar Maven al PATH del sistema
- Usar la versión simplificada como alternativa

### Error de compilación
- Verificar que todos los archivos estén presentes
- Verificar la versión de Java (mínimo Java 11)
- Usar la versión simplificada si hay problemas con Maven

## Diferencias entre Versiones

### Versión Completa (con ANTLR)
- ✅ Análisis léxico, sintáctico y semántico completo
- ✅ Manejo robusto de errores con números de línea
- ✅ Árbol de sintaxis abstracta
- ✅ Listener pattern para análisis semántico
- ✅ Generación automática de código desde gramáticas

### Versión Simplificada (sin ANTLR)
- ✅ Análisis léxico básico con expresiones regulares
- ✅ Análisis sintáctico simplificado
- ✅ Análisis semántico usando las mismas clases
- ✅ Funciona sin dependencias externas
- ⚠️ Manejo de errores más básico
- ⚠️ Análisis sintáctico menos robusto

## Extensiones Futuras

El compilador está diseñado para ser extensible:

1. **Generación de Código Intermedio**
2. **Optimización de Código**
3. **Generación de Código Objeto**
4. **Soporte para Funciones Definidas por el Usuario**
5. **Arreglos y Estructuras de Datos**
6. **Manejo de Errores Mejorado**

## Contacto y Soporte

Este compilador fue implementado siguiendo las especificaciones del documento académico proporcionado. Para preguntas o mejoras, consulte la documentación del código fuente. 