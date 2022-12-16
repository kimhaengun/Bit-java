@echo off
set /p cname="class name?"
del %cname%.class
cls
javac -encoding utf-8 %cname%.java
java %cname%
