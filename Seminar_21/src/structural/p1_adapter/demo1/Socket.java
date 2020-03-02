package structural.p1_adapter.demo1;

/**
 */
public class Socket {

    private static final Volt myBaseVolt = new Volt(120);

    public Volt getVolt(){
        return myBaseVolt; //new Volt(120);
    }
}
