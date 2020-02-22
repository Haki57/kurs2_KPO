cd ../src
rem now we need to say what modules we do require to compile:
javac -d ../out --module-path ../../YourGreeter/out --add-modules YourGreeter module-info.java com/grinkrug/app/HelloApp.java

