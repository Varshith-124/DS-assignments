package arrayoperations;
import java.util.Arrays;

public class ArrayOperations {
    private final int[] array;
    private int size;

    public ArrayOperations(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public void insert(int element) {
        if (size == array.length) {
            throw new RuntimeException("Array is full");
        }
        array[size++] = element;
    }

    public void remove(int element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new RuntimeException("Element not found in the array");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void insertAt(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (size == array.length) {
            throw new RuntimeException("Array is full");
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void printArray() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(array, 0, size)));
    }

    public static void main(String[] args) {
        ArrayOperations array = new ArrayOperations(5);

        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.printArray(); // [10, 20, 30]

        array.insertAt(1, 25);
        array.printArray(); // [10, 25, 20, 30]

        array.remove(20);
        array.printArray(); // [10, 25, 30]

        array.removeAt(1);
        array.printArray(); // [10, 30]

        try {
            array.remove(40);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // Element not found in the array
        }

        try {
            array.insertAt(5, 35);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // Index out of range
        }

        try {
            array.removeAt(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
} 