package org.example.Trees;


import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;

    @Override
    public void insert(E element) {
        root = insertRecursive(root, element);
    }

    private Node<E> insertRecursive(Node<E> currentNode, E element) {
        if (currentNode == null) {
            return new Node<>(element);
        }

        if (element.compareTo(currentNode.value) < 0) {
            currentNode.leftChild = insertRecursive(currentNode.leftChild, element);
        } else if (element.compareTo(currentNode.value) > 0) {
            currentNode.rightChild = insertRecursive(currentNode.rightChild, element);
        }

        return currentNode;
    }

    @Override
    public boolean contains(E element) {
        return containsRecursive(root, element);
    }

    private boolean containsRecursive(Node<E> currentNode, E element) {
        if (currentNode == null) {
            return false;
        }

        if (element.equals(currentNode.value)) {
            return true;
        } else if (element.compareTo(currentNode.value) < 0) {
            return containsRecursive(currentNode.leftChild, element);
        } else {
            return containsRecursive(currentNode.rightChild, element);
        }
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> node = searchRecursive(root, element);
        return new BinarySearchTree<>(node);
    }

    private Node<E> searchRecursive(Node<E> currentNode, E element) {
        if (currentNode == null || element.equals(currentNode.value)) {
            return currentNode;
        } else if (element.compareTo(currentNode.value) < 0) {
            return searchRecursive(currentNode.leftChild, element);
        } else {
            return searchRecursive(currentNode.rightChild, element);
        }
    }

    public BinarySearchTree(Node<E> root) {
        this.root = root;
    }

    public BinarySearchTree() {
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public Node<E> getLeft() {
        if (root != null) {
            return root.leftChild;
        }
        return null;
    }

    @Override
    public Node<E> getRight() {
        if (root != null) {
            return root.rightChild;
        }
        return null;
    }

    @Override
    public E getValue() {
        if (root != null) {
            return root.value;
        }
        return null;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }


    @Override
    public void printTree() {
        int maxHeight = height(this.root);
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(this.root);

        int level = 1;
        int nodesInLevel = 1;

        while (!queue.isEmpty()) {
            int nodesInNextLevel = 0;
            int spacesBefore = (int) (Math.pow(2, maxHeight - level) - 1);
            int spacesBetween = (int) (Math.pow(2, maxHeight - level + 1) - 1);

            for (int i = 0; i < spacesBefore; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < nodesInLevel; i++) {
                Node<E> node = queue.poll();
                if (node != null) {
                    System.out.print(node.value);
                    queue.add(node.leftChild);
                    queue.add(node.rightChild);
                    nodesInNextLevel += 2;
                } else {
                    System.out.print(" ");
                    queue.add(null);
                    queue.add(null);
                }

                for (int j = 0; j < spacesBetween; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            level++;
            nodesInLevel = nodesInNextLevel;

            if (level > maxHeight) {
                break;
            }
        }
    }

    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.leftChild);
            int rightHeight = height(node.rightChild);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}