package katas.exercises;

import java.util.Stack;

public class MaxStorageCapacity {

    /**
     *
     * Imagine a series of storage containers placed side by side, where the height of each container
     * is given by an integer in the array. Your task is to find the largest rectangular area that
     * can be formed using one or more of these containers.
     *
     * For example:
     * Input: containers = [2, 1, 5, 6, 2, 3]
     * Output: 10
     * Explanation: The largest rectangle is formed between containers at indices 2 and 3
     * with height 5 and width 2.
     *
     * @param containers an array of integers representing the heights of containers
     * @return the area of the largest rectangle formed between containers
     */
    public static int maxStorageArea(int[] containers) {

        if ( containers == null){
            throw new IllegalArgumentException("can't be null");
        }


        Stack<Integer> mystack = new Stack<>();
        int maxArea = 0;
        int index = 0;

        while (index < containers.length){
            if (mystack.isEmpty() || containers[index] >= containers[mystack.peek()]){
                mystack.push(index++);
            }

            else {
                int height = containers[mystack.pop()];
                int width = mystack.isEmpty() ? index : index - mystack.peek()-1 ;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
        }

        while (!mystack.isEmpty()) {
            int height = containers[mystack.pop()];
            int width = mystack.isEmpty() ? index : index - mystack.peek() - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
            return maxArea;
    }

    public static void main(String[] args) {
        int[] containers = {2, 1, 5, 6, 2, 3};

        int result = maxStorageArea(containers);
        System.out.println("Max storage area: " + result); // Expected output: 10
    }
}
