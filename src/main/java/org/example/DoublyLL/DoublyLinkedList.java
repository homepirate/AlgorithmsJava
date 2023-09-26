package org.example.DoublyLL;

public class DoublyLinkedList <T>{
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToHead(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    public void addToTail(T data){
        Node<T> newNode = new Node<>(data);
        if (tail == null){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public void removeFromHead() throws Exception {
        if (head == null){
            throw new Exception("List is empty");
        }
        if (head == tail){
            tail = null;
            head = null;
        }
        else {
            head = head.getNext();
            head.setPrev(null);
        }
    }

    public void removeFromTail() throws Exception{
        if (tail == null){
            throw new Exception("List is empty");
        }
        if (head == tail){
            tail = null;
            head = null;
        }
        else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
    }

    public void removeByName(String name){
        Node<T> current_node = head;
        while (current_node != null){
            Minion minion = (Minion) current_node.getData();
            if (minion.getName().equals(name)){
                if (current_node == head && current_node == tail){
                    tail = null;
                    head = null;
                }
                else if (current_node == tail){
                    tail = current_node.getPrev();
                    tail.setNext(null);
                }
                else if (current_node == head){
                    head = current_node.getNext();
                    head.setPrev(null);
                }
                else{
                    Node<T> prev = current_node.getPrev();
                    Node<T> next = current_node.getNext();
                    prev.setNext(next);
                    next.setPrev(prev);
                }
                break;
            }
            current_node = current_node.getNext();
        }
    }

    public void changeByName(String name, int count){
        Node <T> current_node= head;
        while (current_node != null) {
            Minion minion = (Minion) current_node.getData();

            if (minion.getName().equals(name)){
                minion.setEyeCount(count);
            }
            current_node = current_node.getNext();

        }
    }

    public String clear(){
        String str = "List is empty";
        if (getSize() == 0){
            return str;
        }
        else {
            Node<T> current_node = head;
            while (current_node != null) {
                Node<T> next = current_node.getNext();
                current_node.setPrev(null);
                current_node.setNext(null);
                current_node.setData(null);
                current_node = next;
            }
        }
        head = null;
        tail = null;
        return str;
    }

    public int getSize(){
        int counter = 0;
        Node<T> node = head;
        while (node != null){
            node = node.getNext();
            counter++;
        }
        return counter;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
    public void printList(){
        Node<T> current = head;
        while (current != null){
            System.out.println(current);
            current = current.getNext();
        }
    }
}
