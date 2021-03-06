package sample_4;

public class OuterClass {

//    public static final Object INNER_OBJECT = new Object();
    private static final int STATIC_FINAL_INT = 2;

    //TODO: show warning (... may be static) and explain it...
    private class InnerClass {
//        public static final Object INNER_OBJECT = new Object();   // compile error! why?
//        public static int STATIC_INT = 2;                         // compile error! why?
        static final int STATIC_FINAL_INT = 3; //todo; explain - why it's ok (instead of attempts above)?

        private int getInnerStaticFinalIntValue(){
            return STATIC_FINAL_INT;
        }

        private int getOuterStaticFinalIntValue(){
//            return OuterClass.this.STATIC_FINAL_INT; // access to static field by instance reference (see Warning!)
            System.out.println(OuterClass.this); // TODO: comment it out and explain warning that's shown...
            return OuterClass.STATIC_FINAL_INT; // access to static field by class reference
        }
    }

    OuterClass.InnerClass getInnerInstance(OuterClass o){
        OuterClass.InnerClass res = o.new InnerClass();
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        InnerClass innerInstance = new OuterClass().new InnerClass();
        System.out.println("value = " + innerInstance.getInnerStaticFinalIntValue());
        System.out.println("value = " + innerInstance.getOuterStaticFinalIntValue());
    }
}

class A{
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        Object obj = outerClass.getInnerInstance(outerClass);
        System.out.println(obj);
    }
}