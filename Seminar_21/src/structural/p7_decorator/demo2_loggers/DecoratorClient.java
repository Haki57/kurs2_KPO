package structural.p7_decorator.demo2_loggers;

public class DecoratorClient {

    public static void main(String[] args) {
        LoggerFactory factory = new LoggerFactory();

        Logger logger = factory.getLogger(LoggerFactory.TYPE_CONSOLE_LOGGER);
//        Logger logger = factory.getLogger(LoggerFactory.TYPE_FILE_LOGGER);

        HTMLLogger htmlLogger = new HTMLLogger(logger);
        htmlLogger.log("A message to log");

        EncryptLogger encryptLogger = new EncryptLogger(logger);
        encryptLogger.log("A message to log");

        logger.close();
    }
}
