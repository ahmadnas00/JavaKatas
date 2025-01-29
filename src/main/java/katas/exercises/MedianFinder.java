package katas.exercises;

import java.util.PriorityQueue;

/**
 * find the median of a stream of integers.
 *
 * The numbers will be provided one at a time in a dynamic data stream, and after each new number is added,
 * your function should efficiently compute the median of all numbers seen so far.
 *
 * Adding a number: O(log n).
 * Finding the median: O(1) or O(log n).
 *
 * Hint: Consider using two heaps (min-heap and max-heap) to efficiently maintain the order of elements.
 */
public class MedianFinder {

    private PriorityQueue<Integer> minheap;
    private PriorityQueue<Integer> maxheap;
    /**
     * Initializes the MedianFinder object.
     */
    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>((a, b) -> b - a);
    }

    /**
     * Adds a number to the data stream.
     *
     * @param num the number to be added
     */
    public void addNum(int num) {
        if(maxheap.isEmpty() || num <= maxheap.peek()){
            maxheap.add(num);
        }else {
            minheap.add(num);
        }

        if(maxheap.size() > minheap.size() + 1){
            minheap.add(maxheap.poll());
        } else if (minheap.size() > maxheap.size()) {
            maxheap.add(minheap.poll());
        }
    }

    /**
     * Finds and returns the median of the data stream.
     *
     * @return the median as a double
     */

    public double findMedian() {
        if(minheap.isEmpty() && maxheap.isEmpty()){
            throw new IllegalArgumentException();
        }
        else if (minheap.size() == maxheap.size()) {
            return ((double) minheap.peek() + maxheap.peek()) / 2.0;
        } else if (maxheap.size() > minheap.size()) {
            return maxheap.peek();
        } else {
            return minheap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian());

        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian());

        medianFinder.addNum(5);
        System.out.println("Median: " + medianFinder.findMedian());
    }
}
