@echo off
echo === Compilando Little Duck Compiler ===

echo.
echo 1. Limpiando proyecto...
call mvn clean

echo.
echo 2. Generando clases ANTLR...
call mvn antlr4:antlr4

echo.
echo 3. Compilando proyecto...
call mvn compile

echo.
echo 4. Creando JAR ejecutable...
call mvn package

echo.
echo === Compilación completada ===
echo.
echo Para ejecutar: java -jar target/little-duck-compiler-1.0.0.jar archivo.ld
echo.
pause 