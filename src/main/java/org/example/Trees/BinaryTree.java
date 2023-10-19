package org.example.Trees;
import java.util.*;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private AbstractBinaryTree<E> left;
    private AbstractBinaryTree<E> right;

    public BinaryTree(E key, AbstractBinaryTree<E> left, AbstractBinaryTree<E> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    @Override
    public E getKey() {
        return key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return right;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(indent * 2)).append(getKey()).append("\n");
        if (getLeft() != null) {
            sb.append(getLeft().asIndentedPreOrder(indent + 1));
        }
        if (getRight() != null) {
            sb.append(getRight().asIndentedPreOrder(indent + 1));
        }
        return sb.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        result.add(this);
        if (getLeft() != null) {
            result.addAll(getLeft().preOrder());
        }
        if (getRight() != null) {
            result.addAll(getRight().preOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (getLeft() != null) {
            result.addAll(getLeft().inOrder());
        }
        result.add(this);
        if (getRight() != null) {
            result.addAll(getRight().inOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (getLeft() != null) {
            result.addAll(getLeft().postOrder());
        }
        if (getRight() != null) {
            result.addAll(getRight().postOrder());
        }
        result.add(this);
        return result;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (getLeft() != null) {
            getLeft().forEachInOrder(consumer);
        }
        if (getRight() != null) {
            getRight().forEachInOrder(consumer);
        }
        consumer.accept(getKey());
    }

    public void depthFirstTraversal() {
        Stack<AbstractBinaryTree<E>> stack = new Stack<>();
        stack.push(this);

        while (!stack.isEmpty()) {
            AbstractBinaryTree<E> current = stack.pop();
            System.out.print(current.getKey() + " ");

            if (current.getRight() != null) {
                stack.push(current.getRight());
            }

            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }

        System.out.println();
    }

    public void breadthFirstTraversal() {
        Queue<AbstractBinaryTree<E>> queue = new LinkedList<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            AbstractBinaryTree<E> current = queue.poll();
            System.out.print(current.getKey() + " ");

            if (current.getLeft() != null) {
                queue.offer(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.offer(current.getRight());
            }
        }

        System.out.println();
    }


    public boolean isMirrorSimilar(AbstractBinaryTree<E> tree1, AbstractBinaryTree<E> tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null) {
            return false;
        }

        if (!tree1.getKey().equals(tree2.getKey())) {
            return false;
        }

        return isMirrorSimilar(tree1.getLeft(), tree2.getRight()) &&
                isMirrorSimilar(tree1.getRight(), tree2.getLeft());
    }

}

