package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SlidingWindowMaximumTest {

    @Test
    public void SlidingWindowMaximumtest(){

        int[] inputArray1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] expected1 = {3, 3, 5, 5, 6, 7};
        int[] resultArray1 = SlidingWindowMaximum.maxSlidingWindow(inputArray1,k1).stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expected1, resultArray1);


        int[] inputArray2 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k2 = 2;
        int[] expected2 = {3, 3, -1, 5, 5, 6, 7};
        int[] resultArray2 = SlidingWindowMaximum.maxSlidingWindow(inputArray2,k2).stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expected2, resultArray2);

    }

    @Test
    public void SlidingWindowMaximumnull(){

        assertThrows(IllegalArgumentException.class, () -> SlidingWindowMaximum.maxSlidingWindow(null,3));

    }
}
