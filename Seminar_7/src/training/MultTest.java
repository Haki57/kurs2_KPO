package training;

class Mult {
    public Mult getMultiplier(int x) {
        return new Mult() {
           public void multiply() {
               System.out.println(x * 2);
           }
        };
    }
}

class Mult2 {
    public void multiply(int x){
        new Mult2() {
            private void doIt(){
                System.out.println(getClass() + ": " + x * 2);
            }
        }.doIt(); //TODO:  note - it works since we do know exactly that the object is of type that has doIt()- method...
    }
}

public class MultTest {
    public static void main(String[] args) {
//        new Mult().getMultiplier(3).multiply(); // it does not work: multiply() is not visible...

        System.out.println(new Mult().getMultiplier(3).getClass()); // the similar anonymous class, but cannot work...
        new Mult2().multiply(3); // it does work !!!
    }
}

