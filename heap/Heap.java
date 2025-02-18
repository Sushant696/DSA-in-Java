package heap;

import java.util.ArrayList;

public class Heap {

    private ArrayList<Integer> list;

    Heap() {
        list = new ArrayList<Integer>();
    }

    private void swap(int first, int second) {
        int temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, list.get(first));
    }

    int parent(int index) {
        return (index - 1) / 2;
    }

    int left(int index) {
        return (index * 2) + 1;
    }

    int right(int index) {
        return (index * 2) + 2;
    }

    void insert(int value) {
        list.add(value); // added value at the last
        // uphead is going from last to first
        upheap(list.size() - 1);
    }

    private void upheap(int index) {
        if (index == 0) {
            return;
        }
        int p = parent(index);
        if (list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upheap(p);
        }
    }

    int remove() {
        if (list.isEmpty()) {
            System.out.println("Removing from an empty heap");
            return -1;
        }
        int temp = list.get(0);
        int last = list.remove(list.size() - 1);

        if (!list.isEmpty()) {
            list.set(0, last);
        }
        dowpHeap(0);
        return temp;
    }

    private void dowpHeap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        // find if the right or left is small and assigning left or right to min
        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;

        }
        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }
        if (min != index) {
            swap(min, index);
            dowpHeap(min);
        }
    }

    public ArrayList heapSort() {
        // removing until list is empty and adding it to the list

        ArrayList<Integer> data = new ArrayList<>();
        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(23);
        heap.insert(32);
        heap.insert(90);
        heap.insert(12);
        System.out.println(heap.remove());
    }
}
