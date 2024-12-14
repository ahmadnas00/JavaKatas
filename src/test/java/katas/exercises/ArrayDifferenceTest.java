package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ArrayDifferenceTest {


    @Test
    public void testArrayDifference() {
        int diff = ArrayDifference.findDifference(new int[]{10, 3, 5, 6, 20, -2});
        assertEquals(22, diff);

        int diff2 = ArrayDifference.findDifference(new int[]{10, 3, 5, 6, 8, -2});
        assertEquals(12, diff2);
    }

    @Test
    public void testFindDifference_EmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> ArrayDifference.findDifference(new int[]{}));
    }

    @Test
    public void testFindDifference_NullArray() {
        assertThrows(IllegalArgumentException.class, () -> ArrayDifference.findDifference(null));
    }

    @Test
    public void testFindDifference_SingleElementArray() {
        int diff = ArrayDifference.findDifference(new int[]{5});
        assertEquals(0, diff);
    }


}
