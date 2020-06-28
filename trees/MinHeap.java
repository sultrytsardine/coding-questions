import java.util.*;

/*
 * Implementation of a min heap using an array to store the values. Note the relationship between the indexese of each node to its children and parent.
 * https://www.youtube.com/watch?v=t0Cq6tVNRBA
 */
public class MinHeap {
    private int capacity = 10;
    private int size = 0;

    private int[] data = new int[capacity];

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return data[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();

        int value = data[0];
        data[0] = data[size - 1];
        size--;
        heapifyDown();

        return value;
    }

    public void add(int value) {
        checkCapacity();
        data[size] = value;
        size++;
        heapifyUp();
    }

    private void heapifyDown() {
        int index = 0;

        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (data[index] < data[smallerChildIndex]) {
                break;
            } 
            
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    private void heapifyUp() {
        int index = size - 1;

        while(hasParent(index) && getParent(index) > data[index]) {
            int parentIndex = getParentIndex(index);
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 2) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }
    
    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int getLeftChild(int index) {
        return data[getLeftChildIndex(index)];
    } 

    private int getRightChild(int index) {
        return data[getRightChildIndex(index)];
    }

    private int getParent(int index) {
        return data[getParentIndex(index)];
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void checkCapacity() {
        if (size == capacity) {
            capacity *= 2;
            data = Arrays.copyOf(data, capacity);
        }
    }

}