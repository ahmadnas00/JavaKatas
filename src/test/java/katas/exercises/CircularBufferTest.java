package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircularBufferTest {

    @Test
    public void CircularBufferempty(){
        CircularBuffer mybuff = new CircularBuffer(0);
        assertEquals(-1,mybuff.get());
    }

    @Test
    public void CircularBuffertest1(){
        CircularBuffer mybuff = new CircularBuffer(3);
        mybuff.add(1);
        mybuff.add(2);
        assertEquals(1,mybuff.get());
        assertEquals(2,mybuff.get());
        assertEquals(-1,mybuff.get());
    }
    @Test
    public void CircularBuffertest2(){
        CircularBuffer mybuff = new CircularBuffer(3);
        mybuff.add(1);
        mybuff.add(2);
        mybuff.add(3);
        mybuff.add(4);
        assertEquals(2,mybuff.get());
    }
}
