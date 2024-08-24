package dynamicarraystack;
import java.util.EmptyStackException;

public class DynamicArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    public DynamicArrayStack(int initialCapacity) {
        stack = new int[initialCapacity];
        top = -1;
        capacity = initialCapacity;
    }

    public void push(int element) {
        if (top == capacity - 1) {
            // If the stack is full, double the capacity and copy the elements to the new array
            capacity *= 2;
            int[] newStack = new int[capacity];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++top] = element;
                System.out.println(element);

    }

    public int pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        int element = stack[top--];
        if (top < capacity / 4 && capacity > 1) {
            // If the stack is less than a quarter full, halve the capacity and copy the elements to the new array
            capacity /= 2;
            int[] newStack = new int[capacity];
            System.arraycopy(stack, 0, newStack, 0, top + 1);
            stack = newStack;
        }
        return element;
    }

    public int peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        DynamicArrayStack stack = new DynamicArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop()); // 5
        System.out.println(stack.pop()); // 4
        System.out.println(stack.peek()); // 3
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.size());
    }
}    

