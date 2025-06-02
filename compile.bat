@echo off
echo === Compilando Little Duck Compiler (Sin Maven) ===

echo.
echo 1. Creando directorios de salida...
if not exist "out" mkdir out
if not exist "out\classes" mkdir out\classes

echo.
echo 2. Compilando clases Java...
javac -d out\classes -cp . src\main\java\com\littleduck\semantic\*.java src\main\java\com\littleduck\SimpleLittleDuckCompiler.java

if %ERRORLEVEL% EQU 0 (
    echo.
    echo === Compilación completada exitosamente ===
    echo.
    echo Para ejecutar: java -cp out\classes com.littleduck.SimpleLittleDuckCompiler archivo.ld
    echo.
) else (
    echo.
    echo === Error en la compilación ===
    echo.
)

pause 