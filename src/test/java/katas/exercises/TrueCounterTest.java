package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrueCounterTest {

    @Test
    public void testTrueCounter() {
        assertEquals(3, TrueCounter.countTrueValues(new boolean[] {true, false, true, true, false}));
        assertEquals(0, TrueCounter.countTrueValues(new boolean[] { false, false}));

    }

    @Test
    public void testTrueCounterNull(){
        assertThrows(IllegalArgumentException.class, () ->TrueCounter.countTrueValues(null));

    }
}
