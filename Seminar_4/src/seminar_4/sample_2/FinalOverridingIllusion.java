package seminar_4.sample_2;

// This sample is extracted from B.Eckel, Thinking in Java, ed.4, page 186.

// It only looks like you can override a private or private final method.
// TODO: explain - why there are warnings, and what's going on in main()-method (why commented calls cannot work...)

/*
Any private methods in a class are implicitly final.
Because you can’t access a private method, you can’t override it.
You can add the final specifier to a private method, but it does not give that method any extra meaning.

This issue can cause confusion, because if you try to override a private method (which is implicitly final),
it seems to work, and the compiler does not give an error message...

“Overriding” can only occur if something is part of the base-class interface.
That is, you must be able to upcast an object to its base type and call the same method (the point of this will become clear in the next chapter).

If a method is private, it isn’t part of the base-class interface.
It is just some code that’s hidden away inside the class, and it just happens to have that name,
but if you create a public, protected, or package-access method with the same name in the derived class,
there’s no connection to the method that might happen to have that name in the base class.
You haven’t overridden the method; you’ve just created a new method.
Since a private method is unreachable and effectively invisible, it does not factor into anything
except for the code organization of the class for which it was defined.
//*/

class WithFinals {

    // Print with a newline:
    public static void print(Object obj) {
        System.out.println(obj);
    }

    private final void f() { print("WithFinals.f()"); } // explicit final is not needed here (private means final)
    // Also automatically "final":
    private void g() { print("WithFinals.g()"); }
}

class OverridingPrivate extends WithFinals {
    private void f() {
        print("OverridingPrivate.f()");
    }
    private void g() {
        print("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate {

    public final void f() {
        print("OverridingPrivate2.f()");
    }
    public void g() {
        print("OverridingPrivate2.g()");
    }
}

public class FinalOverridingIllusion {

    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();

    //  You can upcast:
        OverridingPrivate op = op2;
//      But you can't call the methods;
//TODO: When we uncomment the following it we get strange error message in IDEA ("Ambiguous method call: two methods match...")
//TODO: IDEA just shows the wrong error message(s): compiler itself works fine (just press Recompile for this file in Build...)
//         op.f();
//         op.g();

    //  Same here: // TODO: note, that error message in IDEA is different !!!
        WithFinals wf = op2;

//         wf.f(); //TODO: but when we uncomment it we get good error message about private method access...
//         wf.g();
    }
}

// TODO: note that the same error message we get if we declare in the first line of main()-method the following:
//  OverridingPrivate op = new OverridingPrivate2();
//  op.f(); // etc.
//  The Last version of IDEA has some errors...