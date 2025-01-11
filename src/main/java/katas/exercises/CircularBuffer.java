package katas.exercises;

public class CircularBuffer {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public void add(int val) {
        if (isFull()) {
            buffer[tail] = val;  // Overwrite the oldest value
            head = (head + 1) % capacity;  // Move head to the next element
        } else {
            buffer[tail] = val;
            tail = (tail + 1) % capacity;
            size++;
        }
    }

    public int get() {
        if (isEmpty()) {
            return -1;
        }
        int value = buffer[head];
        head = (head + 1) % capacity;
        size--;

        if (size == 0) {
            head = tail = 0;
        }

        return value;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        System.out.println(buffer.get()); // Output: 1
        buffer.add(4);
        System.out.println(buffer.get()); // Output: 2
        buffer.add(5);
        System.out.println(buffer.isFull()); // Output: true
    }
}
