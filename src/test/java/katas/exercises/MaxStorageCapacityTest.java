package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaxStorageCapacityTest {

    @Test
    public void MaxStorageCapacitytest(){
        int[] container1 = {2, 1, 5, 6, 2, 3};
        assertEquals(10,MaxStorageCapacity.maxStorageArea(container1));
        int[] container2 = {0, 0, 5, 6, 0, 0};
        assertEquals(10,MaxStorageCapacity.maxStorageArea(container2));
        int[] container3 = {0, 0, 0, 0, 0, 1};
        assertEquals(1,MaxStorageCapacity.maxStorageArea(container3));
    }

    @Test
    public void MaxStorageCapacitytestnull() {
        assertThrows(IllegalArgumentException.class, () -> MaxStorageCapacity.maxStorageArea(null));

    }

}
