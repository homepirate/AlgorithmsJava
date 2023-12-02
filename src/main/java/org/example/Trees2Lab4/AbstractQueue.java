package org.example.Trees2Lab4;
public interface AbstractQueue<E extends Comparable<E>> {
        int size();
        void add(E element);
        E peek();
        E poll();
        }
