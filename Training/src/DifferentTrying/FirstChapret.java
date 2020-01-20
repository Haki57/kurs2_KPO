package DifferentTrying;

import java.io.Console;
import java.util.ArrayList;

class Out{
    int a = 1;

    class Inner{
        int a = 2;
    }
}





class test  {
//    public int q(){
//        return 2;

    class w {
        public  int r(){return 1;}

        class e{}
    }



    public static void main(String[] args) {
        try {
            int a = 1 /0;

        }
        catch (Exception ex){
            System.out.println(1);
            return;
        }finally {
            System.out.println(2);
            //return;
        }
        System.out.println(0);
        //System.out.println(3);
    }
}