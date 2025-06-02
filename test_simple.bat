@echo off
echo === Ejecutando Pruebas del Compilador Little Duck (Versión Simplificada) ===

if not exist "out\classes" (
    echo ERROR: No se encontraron las clases compiladas. Ejecute compile.bat primero.
    pause
    exit /b 1
)

echo.
echo === PROGRAMAS VÁLIDOS ===

echo.
echo -- Test 1: Programa mínimo --
java -cp out\classes com.littleduck.SimpleLittleDuckCompiler test_files\test1_minimal.ld
echo.

echo -- Test 2: Declaración de variables --
java -cp out\classes com.littleduck.SimpleLittleDuckCompiler test_files\test2_variables.ld
echo.

echo -- Test 3: Expresiones aritméticas --
java -cp out\classes com.littleduck.SimpleLittleDuckCompiler test_files\test3_expressions.ld
echo.

echo -- Test 4: Estructuras de control --
java -cp out\classes com.littleduck.SimpleLittleDuckCompiler test_files\test4_control_structures.ld
echo.

echo -- Test 5: Print statements --
java -cp out\classes com.littleduck.SimpleLittleDuckCompiler test_files\test5_print.ld
echo.

echo === PROGRAMAS CON ERRORES (deben fallar) ===

echo.
echo -- Error 1: Variable no declarada --
java -cp out\classes com.littleduck.SimpleLittleDuckCompiler test_files\error1_undeclared_variable.ld
echo.

echo -- Error 2: Variable doblemente declarada --
java -cp out\classes com.littleduck.SimpleLittleDuckCompiler test_files\error2_duplicate_variable.ld
echo.

echo -- Error 3: Incompatibilidad de tipos --
java -cp out\classes com.littleduck.SimpleLittleDuckCompiler test_files\error3_type_mismatch.ld
echo.

echo === Todas las pruebas completadas ===
pause 