package com.example;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class FelineTest {
    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> actualResult = feline.eatMeat();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedResult, actualResult);


    }

    @Test
    public void tstGetFamily() {
        Feline feline = new Feline();
        String actualResult = feline.getFamily();
        String expectedResult = "Кошачьи";
        assertEquals(expectedResult, actualResult);
    }

    @Spy
    private Feline feline;

    @Test
    public void testGetKittensPositiveAmount() {
        int expected = 100;
        int actual = feline.getKittens(100);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetKittensNegativeAmount() {
        int expected = -100;
        int actual = feline.getKittens(-100);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testGetKittensCheckMethodCall() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }
}

