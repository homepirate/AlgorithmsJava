package org.example.Trees2Lab4;

public class MainBSTQ {
    public static void main(String[] args) {
        BinarySearchTreeQueue<Integer> priorityQueue = new BinarySearchTreeQueue<>();

        priorityQueue.add(5);
        priorityQueue.add(9);
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(7);
        priorityQueue.add(-10);
        priorityQueue.add(-1);

        System.out.println(priorityQueue.getSortedElements());

        System.out.println("Размер очереди: " + priorityQueue.size());

        System.out.println("Наивысший приоритет: " + priorityQueue.peek());

    }
}
