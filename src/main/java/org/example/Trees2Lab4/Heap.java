package org.example.Trees2Lab4;

public interface Heap<E extends Comparable<E>> {
        int size();
        void add(E element);
        E peek();
}