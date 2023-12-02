package org.example.Trees2Lab4;

public class MainHeap {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(20);
        maxHeap.add(15);
        maxHeap.add(7);

        System.out.println("Размер кучи: " + maxHeap.size());

        System.out.println("Максимальный элемент: " + maxHeap.peek());

        maxHeap.add(25);

        System.out.println("Максимальный элемент после добавления: " + maxHeap.peek());
    }
}
