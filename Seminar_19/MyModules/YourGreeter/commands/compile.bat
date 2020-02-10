rem module-info.java - is not a class name (that cannot contain '-'), but it compiles into a module-info.class-file
cd ../src
javac -d ../out module-info.java com/grinkrug/greeter/Greeter.java com/grinkrug/greeter/internal/GreeterImpl.java

