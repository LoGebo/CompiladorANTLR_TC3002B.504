@echo off
echo Descargando ANTLR...
powershell.exe -Command "(New-Object System.Net.WebClient).DownloadFile('https://www.antlr.org/download/antlr-4.13.1-complete.jar', 'antlr-4.13.1-complete.jar')"
echo ANTLR descargado!
pause 