package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinStackTest {


    @Test
    public void MinStacktest(){
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        assertEquals(-3,stack.getMin());
        stack.pop();
        assertEquals(0,stack.top());
        assertEquals(-2,stack.getMin());
    }


    @Test
    public void MinStacktest2(){
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(-1);
        stack.push(0);
        stack.push(5);
        assertEquals(-1,stack.getMin());
        stack.pop();
        assertEquals(0,stack.top());
        stack.pop();
        stack.pop();
        assertEquals(1,stack.getMin());
    }

}
