package doubleendedqueueusingarray;

import java.util.Arrays;

class ArrayQueue {
    private final int[] items;
    private int rear;
    private int front;
    private int count;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
        rear = 0;
        front = 0;
        count = 0;
    }

    // Enqueue element at the rear
    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full.");
        }
        items[rear] = item;
        rear = (rear + 1) % items.length; // Circular increment
        count++;
    }

    // Dequeue element from the front
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        int item = items[front];
        items[front] = 0;  // Optional: Reset the dequeued spot
        front = (front + 1) % items.length; // Circular increment
        count--;
        return item;
    }

    // Add element at the front of the queue (Dequeue from the front)
    public void addFromFront(int item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full.");
        }
        // Move front backward in a circular fashion
        front = (front - 1 + items.length) % items.length;
        items[front] = item;
        count++;
    }

    // Remove element from the rear of the queue (Dequeue from the rear)
    public int removeFromRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        // Move rear backward in a circular fashion
        rear = (rear - 1 + items.length) % items.length;
        int item = items[rear];
        items[rear] = 0;  // Optional: Reset the removed spot
        count--;
        return item;
    }

    // Peek at the front element
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return items[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    public int getRear() {
        return rear;
    }

    public int getFront() {
        return front;
    }
}

public class DoubleEndedQueueUsingArray {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue);
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());

        System.out.println("Deleted item = " + queue.dequeue());
        System.out.println(queue);
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());

        queue.enqueue(40);
        System.out.println(queue);
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());

        queue.enqueue(50);
        System.out.println(queue);
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());

        // Add item to the front
        queue.addFromFront(60);
        System.out.println(queue);
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());

        // Remove item from the rear
        System.out.println("Deleted item from rear = " + queue.removeFromRear());
        System.out.println(queue);
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());
   }
}