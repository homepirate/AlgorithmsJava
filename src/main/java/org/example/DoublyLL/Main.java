package org.example.DoublyLL;

public class Main {
    public static void main(String[] args) {
        Minion mn1 = new Minion("Viper", 12, 1);
        Minion mn2 = new Minion("Ivan", 42, 2);
        Minion mn3 = new Minion("Jack", 99, 2);
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        System.out.println("First size: " + dll.getSize());
        dll.addToHead(mn1);
        System.out.println("Size after add 1 object: " + dll.getSize());
        dll.addToTail(mn2);
        dll.addToTail(mn3);
        dll.printList();
        System.out.println("Size after add 2 new object: " + dll.getSize());
        System.out.println("Minion3 last object: "+ dll.getTail().getData().equals(mn3));
        try {
            dll.removeFromHead();
            dll.printList();
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Size after remove from head: " + dll.getSize());
        System.out.println("Minion2 is first in list: " + dll.getHead().getData().equals(mn2));

        dll.changeByName("Jack", 1);
        System.out.println("Eye count after change: " + mn3.getEyeCount());

        dll.removeByName("Ivan");
        System.out.println("Size after remove by name: " + dll.getSize());
    }
}