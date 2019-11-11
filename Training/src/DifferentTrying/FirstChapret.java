package DifferentTrying;

import java.io.Console;
import java.util.ArrayList;

public class FirstChapret {
    public static void main(String[] args) {
        System.out.println("We will not use 'Hello, World! '");

        double х = 3.905f;
        int nx = (int) х;
        System.out.println(nx);



        int n = 1;
        double r = 2.0;
//        System.out.println(true ? n : r);
lol bob = new lol();
//bob.name = "bob";
//        lol alic = new lol();
//        alic.name = "alic";
//ee(bob);
//        swap(bob, alic);
//        IntHolder
//System.out.println(bob.name);
        int[] arr =  {22, 4, 1};
//method(22, 4);
        //var a = (int x, int y) -> x + y;

        //b.g();
        //a.q(4);
    }
    public static void ee(lol l){
        //l.name += "qqq";
    }

    public static void swap(lol a, lol b){
        lol temp = a;
        a = b;
        b = temp;
    }

    public static void method(Object... kk){
        System.out.println(kk[0]);
    }
}

class lol {
    int k = 0;
}
class kek extends lol{
    void kk() {

    }
}

//    public void jj() {
//        System.out.println("kk");
//    }
//}

interface Io{
    int k = 0;
    static void kk(){
        System.out.println("kk");
    }
    private static void ll(){
        System.out.println("kk");
    }
    default void jj(){
        System.out.println("jj");

    }
    //abstract void hh();
}
interface Ip extends Io{
    int k = 3;
    default void jj(){
        System.out.println("oo");

    }
}