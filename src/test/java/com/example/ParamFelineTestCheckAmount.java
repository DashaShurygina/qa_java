package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParamFelineTestCheckAmount {

    private final int expected;
    private final int actual;

    public ParamFelineTestCheckAmount(int expected, int actual) {
        this.expected = expected;
        this.actual = actual;
    }

    @Parameterized.Parameters
    public static Object[][] checkAmount() {
        return new Object[][]{
                {-100, -100},
                {100, 100},
        };
    }
    @Test
    public void testCheckAmount() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(actual));
    }
}
