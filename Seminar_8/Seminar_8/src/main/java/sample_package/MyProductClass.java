package sample_package;

public class MyProductClass {
    public static void main(String[] args) {
        new MyProductClass();
    }

    public MyProductClass(){
    }

    class Helper {
        int help (int i){
//            System.out.println("help()-method invoked.");
            return i * i;
        }
    }
}
