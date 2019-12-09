package semaphores;

import java.util.concurrent.Semaphore;

public class SemaphoreExample2 {
    public static void main(String[] args) {
        Store store = new Store();
        new Consumer(store);
        new Producer(store);
    }
}

class Store {
    int n;
    // Start with consumer semaphore unavailable:
    static Semaphore consumerSemaphore = new Semaphore(0);
    static Semaphore producerSemaphore = new Semaphore(1);
    void get() {
        try {
            consumerSemaphore.acquire();
        } catch (InterruptedException e) {
            System.out.println("got exception: " + e);
        }
        System.out.println("got: " + n);
        producerSemaphore.release();
    }

    void put(int n) {
        try {
            producerSemaphore.acquire();
        } catch (InterruptedException e) {
            System.out.println("got exception: " + e);
        }
        this.n = n;
        System.out.println("put: " + n);
        consumerSemaphore.release();
    }
}

class Consumer implements Runnable {
    private Store store;
    Consumer(Store store) {
        this.store = store;
        new Thread(this, "Consumer").start();
    }
    public void run() {
        for (int i = 0; i < 20; i++) {
            store.get();
        }
    }
}

class Producer implements Runnable {
    private Store store;
    Producer(Store store) {
        this.store = store;
        new Thread(this, "Producer").start();
    }
    public void run() {
        for (int i = 0; i < 20; i++) store.put(i);
    }
}
