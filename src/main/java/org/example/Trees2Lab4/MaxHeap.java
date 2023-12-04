package org.example.Trees2Lab4;

import java.util.LinkedList;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {

    private List<E> heap;

    public MaxHeap() {
        this.heap = new LinkedList<>();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public void add(E element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    @Override
    public E peek() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void swap(int index1, int index2) {
        E temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}
