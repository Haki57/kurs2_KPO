package structural.p3_proxy.demo2_commandexecutor;

public class ProxyPatternTest {

    public static void main(String[] args){
        CommandExecutor executor = new CommandExecutorProxy("John", "abracadabra");
//        CommandExecutor executor = new CommandExecutorProxy("John", "dontknow");
        try {
            executor.runCommand("java -help");
            executor.runCommand(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::" + e.getMessage());
        }
    }
}
