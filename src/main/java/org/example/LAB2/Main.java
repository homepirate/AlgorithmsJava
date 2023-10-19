package org.example.LAB2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------Comparator-------");
        List<Minion> minions = new ArrayList<>();
        Minion mn2 = new Minion("Ivan", 20, 2);
        Minion mn1 = new Minion("Viper", 18, 2);
        Minion mn3 = new Minion("Jack", 20, 1);
        Minion mn4 = new Minion("Pavel", 10, 3);
        Minion mn5 = new Minion("Artem", 45, 1);

        minions.add(mn2);
        minions.add(mn1);
        minions.add(mn3);

        MinionComparator comparator = new MinionComparator();
        Collections.sort(minions, comparator);

        System.out.println(minions);
        for (Minion m : minions){
            System.out.println(m);
        }

        System.out.println("------DoublyLinkedList------");
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        dll.addToHead(mn1);
        dll.addToTail(mn2);
        dll.addToTail(mn3);
        dll.addToTail(mn4);
        dll.addToTail(mn5);
        System.out.println("Получение по индексу 2: " + dll.getByIndex(2));
        System.out.println("Вызов next: " + dll.iterator().next());

        for (Object mn : dll){
            System.out.println(mn);
        }

        System.out.println("----------STACK----------");
        Stack st = new Stack<>(5);
        try {
            st.push(mn1);
            st.push(mn2);
            st.push(mn3);
            st.push(mn4);
            st.push(mn5);
            System.out.println("Сравнение последнего добавленого с первым выкинутым: " + mn5.equals(st.pop()));
            System.out.println("Получение последнего из стека без удаления: " + mn4.equals(st.peek()));
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Iterator next: " + st.iterator().next());
        System.out.println("Вывод всех элементов стека");
        for (Object mn : st){
            System.out.println(mn);
        }
    }
}
