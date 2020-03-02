package structural.p3_proxy.demo1_logging;

public class CachedLogger implements ICachedLogging {

    public void logRequest(String logString) {
        System.out.println("CachedLogger logging to some expensive resource: " + logString + "\n");
    }
}
