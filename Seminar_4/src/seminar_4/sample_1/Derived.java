package seminar_4.sample_1;

public class Derived extends Base{
    public Derived() {
        this.f();
    }

//    @Override
    public void f() {
        print(" derived f()");
    }
}
