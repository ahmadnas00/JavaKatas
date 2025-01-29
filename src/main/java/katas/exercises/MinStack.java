package katas.exercises;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Design a stack that supports standard stack operations (push, pop, top) and also retrieves
 * the minimum element in constant time.
 */
public class MinStack {

    private Deque<Integer> mystack ;
    private Deque<Integer> minstack;



    /** Initialize your data structure here. */
    public MinStack() {
        mystack = new LinkedList<>();
        minstack = new LinkedList<>();
    }

    public void push(int val) {
        mystack.push(val);
        if(minstack.isEmpty() || val <= minstack.peek()){
            minstack.push(val);
        }
    }

    public void pop() {
        if(!mystack.isEmpty()){
            int topop = mystack.pop();
            if(topop == minstack.peek()){
                 minstack.pop();
            }
        } else {
            throw new NoSuchElementException("Stack is empty!");
        }
    }

    public int top() {
        if (!mystack.isEmpty()) {
            return mystack.peek();
        } else {
            throw new NoSuchElementException("Stack is empty!");
        }
    }

    public int getMin() {
        if (!minstack.isEmpty()) {
            return minstack.peek();
        } else {
            throw new NoSuchElementException("Stack is empty!");
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
