package org.example.Trees;

public class MainBST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(90);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        bst.printTree();

        System.out.println("Дерево: " + bst);

        System.out.println("Проверка наличия элементов");
        System.out.println(bst.contains(30));
        System.out.println(bst.contains(1));

        AbstractBinarySearchTree<Integer> result = bst.search(70);
        System.out.println("Новое дерево с заданным корневым значением: " + result);

        BinarySearchTree.Node<Integer> root = bst.getRoot();
        System.out.println("Получение корневого узла: " + root.value);

        BinarySearchTree.Node<Integer> leftChild = bst.getLeft();
        BinarySearchTree.Node<Integer> rightChild = bst.getRight();
        System.out.println(leftChild.value);
        System.out.println(rightChild.value);
    }
}
