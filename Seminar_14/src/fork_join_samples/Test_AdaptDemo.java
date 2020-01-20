package fork_join_samples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

// TODO: read:  https://www.concretepage.com/java/jdk7/example-of-forkjoinpool-in-java
// TODO: read:  https://github.com/javacreed/java-fork-join-example

public class Test_AdaptDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ForkJoinPool fjp = new ForkJoinPool();
        DemoTask task = new DemoTask();
        ForkJoinTask<String> fjt = ForkJoinTask.adapt(task);
        String result = fjp.invoke(fjt);
        System.out.println("isDone = " + fjt.isDone() + "; result = " + result);
    }
}

class DemoTask implements Callable<String> {
    public String call() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return "Task Done";
    }
}
