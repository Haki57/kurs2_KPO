package structural.p7_decorator.demo2_loggers;

public class EncryptLogger extends LoggerDecorator {

    public EncryptLogger(Logger logger) {
        super(logger);
    }

    public void log(String msg) {
        msg = encrypt(msg);
        logger.log(msg);
    }

    private String encrypt(String msg) {
        msg = msg.substring(msg.length() - 1) + msg.substring(0, msg.length() - 1);
        return msg;
    }
}
