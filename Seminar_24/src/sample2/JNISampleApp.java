package sample2;

public class JNISampleApp {

    static {
        System.loadLibrary("MyJNILib");
    }

    public static void main(String[] args) {
        int count = print(8, 4, 3.14);
        count += print(8, 4, count);
        System.out.println();
        for (int i = 0; i < count; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static native int print(int width, int precision, double x);
}
