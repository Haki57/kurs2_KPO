package behavioral.b11_interpreter;

/**
 * Class that does the actual interpretation...
 */
public class InterpreterContext {

    public String getBinaryFormat(int i){
        return Integer.toBinaryString(i);
    }
    public String getHexadecimalFormat(int i){
        return Integer.toHexString(i);
    }
}
