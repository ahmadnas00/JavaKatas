package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoNTimesTest {

    @Test
    public void testDoNTimes(){

        final int[] counter1 = {0};
        Runnable Addone = () -> counter1[0]++;
        DoNTimes.doNTimes(Addone,10);
        assertEquals(10,counter1[0]);


        final int[] counter2 = {10};
        Runnable Subone = () -> counter2[0]--;
        DoNTimes.doNTimes(Subone,5);
        assertEquals(5,counter2[0]);

    }

    @Test
    public void testDoNTimesZero(){
        final int[] counter3 = {0};
        Runnable plusone = () -> counter3[0]++;
        assertThrows(IllegalArgumentException.class, () ->DoNTimes.doNTimes(plusone,0));



    }







}
