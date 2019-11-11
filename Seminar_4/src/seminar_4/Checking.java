package seminar_4;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class Checking {

    public static void main(String[] args) {
//        boolean isCorrect = false;
//        int n = -1;
//        do{
//            Scanner scanner = new Scanner(System.in);
//            try{
//                n = scanner.nextInt();
//                isCorrect = true;
//            } catch (Exception ex){}
//        }while (!isCorrect);


        Random rnd = new Random();

        String[][] a = new String[3][2];

//        System.out.println(a[0].length);
//        System.out.println(rnd.nextInt(1));
//
//        System.out.println(rnd.nextInt(1));
//
//        System.out.println(rnd.nextInt(1));
    A q = new B();
    q.a = 10;
    //q.a;
//System.out.println(q);
        System.out.println(q.a);
        q.kek();



    }


}

class A {
    void kek(){
        System.out.println(a);
    }
    int a = 1;
}
class B extends A{
    int a = 2;
void kek(){
    System.out.println(a);
}
}