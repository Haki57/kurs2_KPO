package edu.hse.cs.se;

public class Q3_ExceptionsQuiz {
    public static void main(String[] args) {
        try {
            myMethod();
        } catch (StackOverflowError soe) {
            for (int i = 0; i < 2; ++i) {
                System.out.println(i);
            }
        }
    }

    private static void myMethod(){
        myMethod();
    }
}
