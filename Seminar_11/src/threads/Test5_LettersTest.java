package threads;

/**
 * TODO: explain - what the following program is doing. Then:
 * 1. Show wrong run()-method first to illustrate synchronization missing...
 * 2. Change run()-implementation with the synchronized block.
 */
public class Test5_LettersTest extends Thread {

    private final StringBuffer letter;

    private Test5_LettersTest(StringBuffer letter){
        this.letter = letter;
    }

    public static void main(String[] args){
        StringBuffer sb = new StringBuffer("A");
        new Test5_LettersTest(sb).start();
        new Test5_LettersTest(sb).start();
        new Test5_LettersTest(sb).start();
    }

    public void run(){
        for(int i = 1; i <= 100; ++i)
            System.out.print(letter);
        System.out.println();
        char temp = letter.charAt(0);
        ++temp;
        letter.setCharAt(0, temp);
    }

//    public void run(){
//        synchronized (letter) {
//            for (int i = 1; i <= 100; ++i)
//                System.out.print(letter);
//            System.out.println();
//            char temp = letter.charAt(0);
//            ++temp;
//            letter.setCharAt(0, temp);
//        }
//    }

}
