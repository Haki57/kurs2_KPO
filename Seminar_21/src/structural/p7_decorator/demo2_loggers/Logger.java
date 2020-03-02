package structural.p7_decorator.demo2_loggers;

public interface Logger {

    public void log(String msg);

    // we need to close file in FileLogger...Can we avoid having the following method in this interface? How?
    public void close();
}
