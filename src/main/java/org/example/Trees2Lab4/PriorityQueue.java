package org.example.Trees2Lab4;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {
    private List<E> elements;

    public PriorityQueue() {
        elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void add(E element) {
        elements.add(element);
        heapifyUp(elements.size() - 1);
    }

    @Override
    public E peek() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements.get(0);
    }

    @Override
    public E poll() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E maxElement = elements.get(0);
        elements.set(0, elements.get(elements.size() - 1));
        elements.remove(elements.size() - 1);
        heapifyDown(0);
        return maxElement;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (elements.get(index).compareTo(elements.get(parentIndex)) <= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftChildIndex < elements.size() && elements.get(leftChildIndex).compareTo(elements.get(largestIndex)) > 0) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < elements.size() && elements.get(rightChildIndex).compareTo(elements.get(largestIndex)) > 0) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            swap(index, largestIndex);
            heapifyDown(largestIndex);
        }
    }

    private void swap(int index1, int index2) {
        E temp = elements.get(index1);
        elements.set(index1, elements.get(index2));
        elements.set(index2, temp);
    }

    public List<E> getElements() {
        return elements;
    }
}
