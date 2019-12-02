package threads;
public class Test6_Counter { // todo: note, that process is not finished with main thread...
    public static void main(String[] args) {
        Storage store = new Storage(); new Counter(store); new Printer(store); //todo: note, that objects are not GC'ed...
    }
}
class Storage { // TODO: reimplement this class only - so that console output prints numbers in natural order...
    private int value;
    /* synchronized */ void setValue(int newValue) { value = newValue; }
    /* synchronized */ int getValue() { return value; }
}
class Counter implements Runnable {
    private Storage storage;
    Counter(Storage target) { storage = target; new Thread(this).start(); }
    public void run() {
        int i = 0;
        while (true) { storage.setValue(i++); }
    }
}
class Printer implements Runnable {
    private Storage storage;
    Printer(Storage source) { storage = source;  new Thread(this).start(); }
    public void run() {
        while (true) { System.out.println(storage.getValue()); }
    }
}








//======================================================================================================================
/*
class Storage {
    int value;
    boolean isUnread = false; // i.e. is read - the value was delivered for printing...

    synchronized void setValue(int newValue) {
        ensureUnread(false); // we are to set new value, and we need to wait if the value is not printed yet
        value = newValue;
        setUnread(true); // set the unread state: the value is new and should be read (printed)...
    }
    synchronized int getValue() {
        ensureUnread(true); // we want to read value, but we need to wait if the value is not written yet
        setUnread(false); // the value is printed, we can write a new one now...
        return value;
    }
    private void ensureUnread(boolean shouldHaveUnread) {
        while (shouldHaveUnread != isUnread){
            try {
                wait();
            }
            catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                System.out.println("Exception: " + ie);

            }
        }
    }
    private void setUnread(boolean b) {
        isUnread = b;
        notify();
    }
}
//*/

