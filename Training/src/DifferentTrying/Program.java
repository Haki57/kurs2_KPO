package DifferentTrying;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

class JThread extends Thread {

    JThread(String name){
        super(name);
    }
    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов
        while(!isInterrupted()){

            System.out.println("Loop " + counter++);
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
interface MyPredicate {
    Integer test(Integer value);
}

public class Program {

    public static void main(String[] args) {

//        System.out.println("Main thread started...");
//        JThread t = new JThread("JThread");
//        t.start();
//        try{
//            Thread.sleep(150);
//            t.interrupt();
//
//            Thread.sleep(1500);
//        }
//        catch(InterruptedException e){
//            System.out.println("Thread has been interrupted");
//        }
//        System.out.println("Main thread finished...");

        Predicate<Integer> kek = x -> x + x > 0;
        UnaryOperator<Integer> lol = x -> x + x;
        //UnaryOperator
        //System.out.println(lol.);
    }
}