package exceptions;

// TODO: show incorrect text in the book "Java [Notes] for Professionals", section 68.1 (the book is uploaded in moodle)

public class Demo_2_ExceptionHandling {
    public static void main(String[] args) {
        try{
            test2();
        }catch (Throwable throwable){
            System.out.println("throwable = " + throwable);
        }
    }

    private static void test1(){
        try{
            doSomething1();
        } catch (Exception e){
            System.out.println("Exception");
            e = new RuntimeException("ququ");
            throw new RuntimeException(e);
        } // todo uncomment below to see the Compile Error! (and the sample in the book is just wrong...)
//          catch (RuntimeException re) {
//              System.out.println("RuntimeException");
//          }
    }

    private static void test2(){
        try{
            doSomething2();
        } catch (RuntimeException re){
            System.out.println("RuntimeException: " + re);
            re = new RuntimeException("ququ");
            throw new RuntimeException(re);
        } catch (Exception e) {
              System.out.println("Exception: " + e);
          }
    }

    private static void doSomething1() throws Exception {
        throw new Exception();
    }
    private static void doSomething2() throws Exception {
        throw new RuntimeException();
    }
}
