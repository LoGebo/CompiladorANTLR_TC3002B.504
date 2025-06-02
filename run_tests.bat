@echo off
echo === Ejecutando Pruebas del Compilador Little Duck ===

set JAR_FILE=target\little-duck-compiler-1.0.0.jar

if not exist %JAR_FILE% (
    echo ERROR: No se encontró el archivo JAR. Ejecute build.bat primero.
    pause
    exit /b 1
)

echo.
echo === PROGRAMAS VÁLIDOS ===

echo.
echo -- Test 1: Programa mínimo --
java -jar %JAR_FILE% test_files\test1_minimal.ld
echo.

echo -- Test 2: Declaración de variables --
java -jar %JAR_FILE% test_files\test2_variables.ld
echo.

echo -- Test 3: Expresiones aritméticas --
java -jar %JAR_FILE% test_files\test3_expressions.ld
echo.

echo -- Test 4: Estructuras de control --
java -jar %JAR_FILE% test_files\test4_control_structures.ld
echo.

echo -- Test 5: Print statements --
java -jar %JAR_FILE% test_files\test5_print.ld
echo.

echo === PROGRAMAS CON ERRORES (deben fallar) ===

echo.
echo -- Error 1: Variable no declarada --
java -jar %JAR_FILE% test_files\error1_undeclared_variable.ld
echo.

echo -- Error 2: Variable doblemente declarada --
java -jar %JAR_FILE% test_files\error2_duplicate_variable.ld
echo.

echo -- Error 3: Incompatibilidad de tipos --
java -jar %JAR_FILE% test_files\error3_type_mismatch.ld
echo.

echo === Todas las pruebas completadas ===
pause 