package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringDigitSumTest {

    @Test
    public void testStringDigitSum(){

        assertEquals(6,StringDigitSum.sumOfDigits("abc123"));
        assertEquals(6,StringDigitSum.sumOfDigits("0123"));
        assertEquals(0,StringDigitSum.sumOfDigits(""));
        assertEquals(0,StringDigitSum.sumOfDigits("abc"));

    }

    @Test
    public void testStringDigitSumNull(){
        assertThrows(IllegalArgumentException.class, () -> StringDigitSum.sumOfDigits(null));

    }


}
