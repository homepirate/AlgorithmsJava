package org.example.Trees2Lab4;


import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E>{
    private List<E> queue;

    public PriorityQueue() {
        this.queue = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public void add(E element) {
        queue.add(element);
        int currentIndex = queue.size() - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (queue.get(currentIndex).compareTo(queue.get(parentIndex)) > 0) {
                E temp = queue.get(parentIndex);
                queue.set(parentIndex, queue.get(currentIndex));
                queue.set(currentIndex, temp);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    @Override
    public E peek() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.get(0);
    }

    @Override
    public E poll() {
        if (queue.isEmpty()) {
            return null;
        }
        E result = queue.get(0);
        E lastElement = queue.remove(queue.size() - 1);
        if (!queue.isEmpty()) {
            queue.set(0, lastElement);
            int currentIndex = 0;
            int maxChildIndex;
            while (true) {
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;

                if (leftChildIndex >= size()) {
                    break;
                }

                if (rightChildIndex >= size()) {
                    maxChildIndex = leftChildIndex;
                } else {
                    maxChildIndex = queue.get(leftChildIndex).compareTo(queue.get(rightChildIndex)) > 0 ? leftChildIndex : rightChildIndex;
                }

                if (lastElement.compareTo(queue.get(maxChildIndex)) >= 0) {
                    break;
                }

                queue.set(currentIndex, queue.get(maxChildIndex));
                currentIndex = maxChildIndex;
            }
            queue.set(currentIndex, lastElement);
        }
        return result;
    }
    public List<E> getSortedElements() {
        List<E> sortedList = new ArrayList<>(queue);
        int n = sortedList.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(sortedList, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            E temp = sortedList.get(0);
            sortedList.set(0, sortedList.get(i));
            sortedList.set(i, temp);

            heapifyDown(sortedList, i, 0);
        }

        return sortedList;
    }

    private void heapifyDown(List<E> list, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && list.get(left).compareTo(list.get(largest)) > 0) {
            largest = left;
        }

        if (right < n && list.get(right).compareTo(list.get(largest)) > 0) {
            largest = right;
        }

        if (largest != i) {
            E temp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, temp);

            heapifyDown(list, n, largest);
        }
    }

}

