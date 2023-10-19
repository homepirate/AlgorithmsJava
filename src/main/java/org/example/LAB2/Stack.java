package org.example.LAB2;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T>{
    private T[] array;
    private int top;

    public Stack(int size) {
        array = (T[]) new Object[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(T data) throws Exception {
        if (isFull()) {
            throw new Exception("Стек полон");
        }
        array[++top] = data;
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Стек пустой");
        }
        return array[top--];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) array[top];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = top;
            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[index--];
            }
        };
    }

    public boolean isFull() {
        return top == array.length - 1;
    }
}
