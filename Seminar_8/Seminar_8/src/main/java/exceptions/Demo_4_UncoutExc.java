package exceptions;

public class Demo_4_UncoutExc {}

class Exc1 {
    public static void main(String[] args) throws RuntimeException {
        subroutine();
    }

    private static void subroutine() throws RuntimeException {
        int a = 42 / 0;
    }
}

class Exc2 {
    public static void main(String[] args) {
        guru();
    }
    static void guru (){
        throw new StackOverflowError();
    }
}
