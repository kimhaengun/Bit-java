@echo off
cls
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_202\bin
set path=%JAVA_HOME%;%path%
echo "dirname : "
set /p dirname=
mkdir %dirname%