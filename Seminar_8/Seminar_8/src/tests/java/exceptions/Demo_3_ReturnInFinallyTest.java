package exceptions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Demo_3_ReturnInFinallyTest {

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @Test
    void testGetNumber1(){
        assertEquals(0, Demo_3_ReturnInFinally.getNumber1(5));
    }
    @Test
    void testGetNumber2(){
        assertEquals(7, Demo_3_ReturnInFinally.getNumber2(5));
    }
}