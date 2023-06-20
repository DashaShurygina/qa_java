package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParamLionTest {
    private final String sex;
    private final boolean hasMane;

    public ParamLionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Parameterized.Parameters
    public static Object[][] checkDoesHaveMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(new Feline(), sex);
        boolean actualHasMane = lion.hasMane;
        Assert.assertEquals(hasMane, actualHasMane);
    }
}
