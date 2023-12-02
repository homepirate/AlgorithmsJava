package org.example.Trees2Lab4;

public class MainQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(5);
        priorityQueue.add(9);
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(7);
        priorityQueue.add(-10);
        priorityQueue.add(-1);


        System.out.println("Cписок элементов в отсортированном порядке: " + priorityQueue.getSortedElements());

        System.out.println("Размер очереди: " + priorityQueue.size());

        System.out.println("Наивысший приоритет: " + priorityQueue.peek());

        System.out.println("Удаление элементов с наивысшим приоритетом:");

        while (priorityQueue.size() > 0) {
            System.out.print(priorityQueue.poll() + " ");
        }

        System.out.println("\nРазмер очереди после удаления элементов: " + priorityQueue.size());
    }
}

