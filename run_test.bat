@echo off
echo Ejecutando pruebas del compilador Little Duck...

set JAVA_PATH="C:\Program Files\Java\jdk-17\bin"
set CLASSPATH=.;antlr-4.13.1-complete.jar

echo Probando test1_minimal.ld...
%JAVA_PATH%\java -cp %CLASSPATH% LittleDuckCompilerMain test1_minimal.ld

echo.
echo Probando test2_variables.ld...
%JAVA_PATH%\java -cp %CLASSPATH% LittleDuckCompilerMain test2_variables.ld

echo.
echo Probando test3_expressions.ld...
%JAVA_PATH%\java -cp %CLASSPATH% LittleDuckCompilerMain test3_expressions.ld

echo.
echo Probando test4_control_structures.ld...
%JAVA_PATH%\java -cp %CLASSPATH% LittleDuckCompilerMain test4_control_structures.ld

echo.
echo Probando test5_print.ld...
%JAVA_PATH%\java -cp %CLASSPATH% LittleDuckCompilerMain test5_print.ld

echo.
echo === PROBANDO ARCHIVOS CON ERRORES ===
echo.
echo Probando error1_undeclared_variable.ld...
%JAVA_PATH%\java -cp %CLASSPATH% LittleDuckCompilerMain error1_undeclared_variable.ld

echo.
echo ¡Todas las pruebas completadas!
pause 