package p4_asynchronous_computations;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * TODO: 1. Run and see the result;
 * TODO: 2. Modify the code to see how the asynchronous calculation can be interrupted...
 */
public class Sample_2_CompletableFutureSample {
    private static final long SLEEP_TIME = 5000;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CompletableFuture<String> completableFuture_1 = CompletableFuture.supplyAsync(
                () -> {
                    String res = "done";
                    try {
                        System.out.println("I am thread " + Thread.currentThread() + ": going to sleep...");
                        long t0 = System.currentTimeMillis();
                        Thread.sleep(SLEEP_TIME);
                        long t1 = System.currentTimeMillis();
                        res += ": " + (t1 - t0) + " msec";
                    } catch (InterruptedException ie) {
                        System.out.println("I am thread " + Thread.currentThread() + ": got exception: " + ie);
                    }
                    return res;
                }, executorService);
        // the completableFuture can complete in 2 ways:
        // - with a result;
        // - with an exception.
        // to handle both cases use whenComplete - method:
        completableFuture_1.whenComplete((s, t) -> {
            if (t == null) {
                System.out.println("I am thread " + Thread.currentThread() + ": s = " + s);
            } else {
                System.out.println("I am thread " + Thread.currentThread() + ": t = " + t);
            }
        });

        //TODO: find a way to stop execution of the following looping behavior:
//        executorService.execute(() -> {
//            System.out.println("I am thread " + Thread.currentThread() + ": doing infinite loop...");
//            while (true);
//        }); // just to make a core busy

        Future<String> futureString = executorService.submit(() -> {
            System.out.println("I am thread " + Thread.currentThread() + ": doing infinite loop...");
            long t0 = System.currentTimeMillis();
            while (!Thread.currentThread().isInterrupted());
            return "interrupted at " + (System.currentTimeMillis() - t0) + " msec.";
        });

        try {
            int n = System.in.read(); // just to wait for any input...
        } catch (Exception ex) {
            //
        }
        Throwable t = new Throwable("it's my interruption");
        completableFuture_1.completeExceptionally(t);

        boolean v = futureString.cancel(true);
        System.out.println("I am thread " + Thread.currentThread() + ": looping task was interrupted: " + v);

        executorService.shutdown();
    }
}
