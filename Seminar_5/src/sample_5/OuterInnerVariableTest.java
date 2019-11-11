package sample_5;

//TODO: what will be printed and why?
//TODO: run as is, then try with line 13 commented out...what's up?

class OuterClass {

    private int v = 7;
    private int w = 1;

    class InnerClass {

        private int w = 2; //TODO: comment it out...

        void output1(){
            System.out.println("output1(): " + OuterClass.this.w);
            System.out.println("output1(): " + OuterClass.this.v);
        }
        void output2(){
            System.out.println("output2(): " + w); // variable is directly accessible from outer class instance
            System.out.println("output2(): " + v);
        }
        //TODO: explain the difference - this.w vs. w:
        void output3(){
            System.out.println("output3(): " + this.w); // this in inner class means exactly this...
            System.out.println("output3(): " + w); // var in inner class means any var accessible from inner class instance
            System.out.println("output3(): " + v);
        }
    }
}

public class OuterInnerVariableTest {
    public static void main(String[] args) {
        OuterClass.InnerClass myInnerObject = new OuterClass().new InnerClass();
//        OuterClass.InnerClass myInnerObject = new OuterInnerVariableTest().new OuterClass().new InnerClass();
        myInnerObject.output1();
        myInnerObject.output2();
        myInnerObject.output3();
    }
}
