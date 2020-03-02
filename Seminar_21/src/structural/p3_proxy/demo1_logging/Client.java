package structural.p3_proxy.demo1_logging;

public class Client {

    public static void main(String[] args) {
        ICachedLogging logger = new CachedLoggingProxy();

        for (int i = 1; i < 5; i++) {
            logger.logRequest("logString "+i);
        }
    }
}
