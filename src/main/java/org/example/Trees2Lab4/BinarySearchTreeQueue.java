package org.example.Trees2Lab4;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeQueue<E extends Comparable<E>> implements AbstractQueue<E> {
    private Node root;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        root = addNode(root, element);
        size++;
    }

    private Node addNode(Node current, E element) {
        if (current == null) {
            return new Node(element);
        }
        if (element.compareTo(current.value) > 0) {
            current.left = addNode(current.left, element);
        } else {
            current.right = addNode(current.right, element);
        }
        return current;
    }

    @Override
    public E peek() {
        if (root == null) {
            return null;
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    @Override
    public E poll() {
        if (root == null) {
            return null;
        }
        E minElement = peek();
        root = deleteMin(root);
        size--;
        return minElement;
    }

    private Node deleteMin(Node current) {
        if (current.left == null) {
            return current.right;
        }
        current.left = deleteMin(current.left);
        return current;
    }

    public List<E> getSortedElements() {
        List<E> sortedElements = new ArrayList<>();
        inorderTraversal(root, sortedElements);
        return sortedElements;
    }

    private void inorderTraversal(Node current, List<E> sortedElements) {
        if (current != null) {
            inorderTraversal(current.left, sortedElements);
            sortedElements.add(current.value);
            inorderTraversal(current.right, sortedElements);
        }
    }

    private class Node {
        private E value;
        private Node left;
        private Node right;

        public Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
