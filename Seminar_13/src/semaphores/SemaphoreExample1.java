package semaphores;

import java.util.concurrent.Semaphore;

public class SemaphoreExample1 {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);
        new IncrementThread(s, "A");
        new DecrementThread(s, "B");
    }
}

class SharedResource {
    static int count = 0;
}

class IncrementThread implements Runnable {
    private String name;
    private Semaphore s;

    IncrementThread (Semaphore sem, String n) {
        s = sem;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Starting " + name);
        try {
            // get a permit:
            System.out.println(name + " is waiting for a permit.");
//            s.acquire(); //TODO: comment & uncomment it...
            System.out.println(name + " got a permit.");
            // access a resource:
            for (int i = 0; i < 5; i++) {
                SharedResource.count++;
                System.out.println(name + ": " + SharedResource.count);
             // allow context switch
                Thread.sleep(10);
            }
            Thread.sleep(10);
        } catch (InterruptedException ie) {
            System.out.println("got exception: " + ie);
        }
        // release the permit
        System.out.println(name + " releases the permit.");
//        s.release(); //TODO: comment & uncomment it...
    }
}
class DecrementThread implements Runnable {
    private String name;
    private Semaphore s;

    DecrementThread(Semaphore sem, String n) {
        s = sem;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Starting " + name);
        try {
            // get a permit:
            System.out.println(name + " is waiting for a permit.");
//            s.acquire(); //TODO: comment & uncomment it...
            System.out.println(name + " got a permit.");
            // access a resource:
            for (int i = 0; i < 5; i++) {
                SharedResource.count--;
                System.out.println(name + ": " + SharedResource.count);
                // allow context switch
                Thread.sleep(10);
            }
        } catch (InterruptedException ie) {
            System.out.println("got exception: " + ie);
        }
        // release the permit
        System.out.println(name + " releases the permit.");
//        s.release(); //TODO: comment & uncomment it...
    }
}
