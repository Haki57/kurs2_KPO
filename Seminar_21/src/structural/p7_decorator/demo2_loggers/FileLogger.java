package structural.p7_decorator.demo2_loggers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements Logger {

    public static final String FILENAME = "log.txt";

    private PrintWriter out;

    public FileLogger() {
        try {
            out = new PrintWriter(new FileOutputStream(FILENAME), true);
        } catch (IOException ex){
            System.out.println("IOException: " + ex);
        }
    }

    public void log(String msg) {
        if (out != null)
            out.println(msg);
    }

    public void close(){
        if (out != null)
            out.close();
    }
}
