package org.example.Trees;

public class MainBT {
    public static void main(String[] args) {
        AbstractBinaryTree<Integer> tree = new BinaryTree<>(
                13,
                new BinaryTree<>(9, new BinaryTree<>(4, new BinaryTree<>(2, null, new BinaryTree<>(3, null, null)), null), new BinaryTree<>(12, null, null)),
                new BinaryTree<>(25, new BinaryTree<>(14, new BinaryTree<>(6, null, null), new BinaryTree<>(11, null, null)), new BinaryTree<>(7, null, null)));



        System.out.println(tree.asIndentedPreOrder(0));
        tree.printTree();
        System.out.println("Pre order:");
        for (AbstractBinaryTree<Integer> node : tree.preOrder()) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("In order:");
        for (AbstractBinaryTree<Integer> node : tree.inOrder()) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("Post order:");
        for (AbstractBinaryTree<Integer> node : tree.postOrder()) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("forEachInOrder:");
        tree.forEachInOrder(node -> System.out.print(node + " "));
        System.out.println();


        System.out.println("DFT:");
        tree.depthFirstTraversal();


        System.out.println("BFT:");
        tree.breadthFirstTraversal();

        AbstractBinaryTree<Integer> tree2 = new BinaryTree<>(
                4,
                new BinaryTree<>(6, new BinaryTree<>(7, null, null), new BinaryTree<>(5, null, null)),
                new BinaryTree<>(2, new BinaryTree<>(3, null, null), new BinaryTree<>(1, null, null)));


        System.out.println("Сравнение зеркальных деревьев: " + tree.isMirrorSimilar(tree, tree2));
    }
}