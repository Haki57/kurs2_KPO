package structural.p1_adapter.demo1;

/**
 */
public class SocketObjectAdapterImpl implements SocketAdapter {
    //Using Composition for adapter pattern
    private Socket sock = new Socket();
//    private Volt v1, v2, v3;

    @Override
    public Volt get120Volt() {
        return sock.getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v = sock.getVolt();
        return convertVolt(v,10);
    }

    @Override
    public Volt get3Volt() {
        Volt v = sock.getVolt();
        return convertVolt(v,40);
    }

    private Volt convertVolt(Volt v, int i) {
//        switch (i){
//            case 10:
//                if(v1 == null){
//                    v1 = new Volt(v.getVolts()/i);
//                }
//                return v1;
//        }
        return new Volt(v.getVolts()/i);
    }
}
