package structural.p7_decorator.demo2_loggers;

public class ConsoleLogger implements Logger {

    public void log(String msg) {
        System.out.println("We put logs into console: "+  msg);
    }

    public void close(){}
}
