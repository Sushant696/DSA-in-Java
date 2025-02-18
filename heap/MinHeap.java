package heap;

import java.util.Arrays;

public class MinHeap {

    private int[] array;
    private int size;

    public MinHeap(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    private void swap(int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return (index * 2) + 1;
    }

    private int right(int index) {
        return (index * 2) + 2;
    }

    public void insert(int value) {
        if (size == array.length) {
            System.out.println("Heap is full");
            return;
        }
        array[size] = value;
        upheap(size);
        size++;
    }

    private void upheap(int index) {
        while (index > 0 && array[index] < array[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int remove() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        int min = array[0];
        array[0] = array[size - 1];
        size--;
        downheap(0);
        return min;
    }

    private void downheap(int index) {
        while (true) {
            int left = left(index);
            int right = right(index);
            int smallest = index;

            if (left < size && array[left] < array[smallest]) {
                smallest = left;
            }
            if (right < size && array[right] < array[smallest]) {
                smallest = right;
            }
            if (smallest == index) {
                break;
            }
            swap(index, smallest);
            index = smallest;
        }
    }

    public int[] heapSort() {
        int[] sorted = new int[size];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = remove();
        }
        return sorted;
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);
        heap.insert(23);
        heap.insert(32);
        heap.insert(90);
        heap.insert(12);
        System.out.println(heap.remove());
        System.out.println(Arrays.toString(heap.heapSort()));
    }
}
