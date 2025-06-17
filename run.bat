@echo off
cd src
javac -d ../build/classes -cp ../build/classes Program.java && java -classpath ..\build\classes --module-path ..\build\classes Program