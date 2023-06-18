package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetFoodReturnList() throws Exception {
        Lion lion = new Lion( feline, "Самец");
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
    @Test
    public void testGetKittensReturnKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        assertEquals(0, lion.getKittens());
    }
    @Test
    public void testGetDoesHaveManeReturnTrue() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        assertEquals(true, lion.doesHaveMane());
    }
    @Test
    public void testGetDoesHaveManeReturnFalse() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        assertEquals(false, lion.doesHaveMane());
    }
    @Test
    public void testLionEatPredatorFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }

}