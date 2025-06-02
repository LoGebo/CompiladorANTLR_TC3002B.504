@echo off
echo Compilando proyecto Little Duck con ANTLR...

set JAVA_PATH="C:\Program Files\Java\jdk-17\bin"
set CLASSPATH=.;antlr-4.13.1-complete.jar

echo Paso 1: Generando lexer...
%JAVA_PATH%\java -jar antlr-4.13.1-complete.jar LittleDuckLexer.g4

echo Paso 2: Generando parser...
%JAVA_PATH%\java -jar antlr-4.13.1-complete.jar LittleDuckParser.g4

echo Paso 3: Compilando archivos Java...
%JAVA_PATH%\javac -cp %CLASSPATH% *.java

echo ¡Compilación completada!
echo Para probar: run_test.bat
pause 