package katas.exercises;

import org.junit.jupiter.api.Test;

import static katas.exercises.ArrayReducer.reduceArray;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayReducerTest {

    @Test
    public void testArrayReducer() {
        assertArrayEquals(new int[]{10, 10, -5, 15}, reduceArray(new int[]{10, 20, 15, 30}));
        assertArrayEquals(new int[]{10, 0, 5, 15}, reduceArray(new int[]{10, 10, 15, 30}));
        assertArrayEquals(new int[]{0, 0, 0, 5}, reduceArray(new int[]{0, 0, 0, 5}));
        assertArrayEquals(new int[]{10}, reduceArray(new int[]{10}));
    }

    @Test public void testArrayReducerEmpty_Null(){
        assertThrows(IllegalArgumentException.class, () ->
            ArrayReducer.reduceArray(new int[]{}));
    }







}

