package sample_package;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

class MyProductClassTest {

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @Test
    void test1(){
        System.out.println("Test1");
        Class c = MyProductClass.Helper.class;
        Constructor[] constructors = c.getDeclaredConstructors();
        assertNotNull(constructors[0]);
        assertEquals(1, constructors[0].getParameterCount());
    }

    @Test
    void test2(){
        System.out.println("Test2");
        MyProductClass myProductClass = new MyProductClass();
        assertEquals(9, myProductClass.new Helper().help(3));
//        assertEquals(7, myProductClass.new Helper().help(3)); //TODO: see how it might be failed...
    }

    @Test
    void test3(){
        System.out.println("Test3");
    }
}