package com.example.tree.bst;

import java.util.Iterator;

import com.example.queues.FIFOQueue;
import com.example.queues.Queue;
import com.example.tree.TreeNode;
import com.example.tree.binarytree.BinaryTreeNode;
import com.example.tree.binarytree.LinkedBinaryTree;

/**
 * A binary search tree implementation
 */
public class BinarySearchTree<T extends Comparable<T>> extends LinkedBinaryTree<T> {

    /**
     * Class constructor.
     */
    public BinarySearchTree() {
        super();
    }

    /**
     * Class constructor.
     */
    public BinarySearchTree(T data) {
        super(data);
    }

    /**
     * Class constructor.
     */
    public BinarySearchTree(BinaryTreeNode<T> root) {
        super(root);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean insert(T item) {
        this.root = this.insert((BinaryTreeNode<T>) this.getRoot(), item, null);

        this.numberOfNodes++;

        return true;
    }

    private void balance() {

        BinaryTreeNode<T> root = (BinaryTreeNode<T>) this.getRoot();
        BinaryTreeNode<T> imbalancedSubTreeRoot = root;

        Queue<BinaryTreeNode<T>> queue = new FIFOQueue<>(this.size());

        queue.enqueue(root);

        int count = 0;
        int midPoint = Math.floorDiv(this.size(), 2);
        boolean found = false;

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.dequeue();

            int subTreesHeightDiff = Math
                    .abs(this.getHeight(current.getLeftChild()) - this.getHeight(current.getRightChild()));

            if (current != null && subTreesHeightDiff > 1) {
                // if the height of this subtree differs by more than one,
                // we have found the imbalance
                found = true;
                imbalancedSubTreeRoot = current;
                midPoint = Math.floorDiv(this.size() - count, 2);
            }

            // check for children
            if (current.hasLeftChild()) {
                queue.enqueue(current.getLeftChild());
            }

            if (current.hasRightChild()) {
                queue.enqueue(current.getRightChild());
            }

            count++;
        }

    }

    private BinaryTreeNode<T> insert(BinaryTreeNode<T> root, T item, BinaryTreeNode<T> parent) {
        if (root == null) {
            root = new BinaryTreeNode<T>(item, parent);

            return root;
        }

        BinaryTreeNode<T> parentOfRoot = (BinaryTreeNode<T>) root.getParent();

        if (this.lessThanOrEqual(item, root.getData())) {

            if (parentOfRoot != null && !parentOfRoot.hasRightChild()) {
                // we try and keep the tree balanced

                root.setRightChild(parentOfRoot);
                root.setParent(parentOfRoot.getParent());
                parentOfRoot.setParent(root);

                root.setLeftChild(this.insert(root, item, root));
            } else {
                root.setLeftChild(this.insert(root.getLeftChild(), item, root));
            }
        } else {
            if (parentOfRoot != null && !parentOfRoot.hasLeftChild()) {
                // we try and keep the tree balanced

                root.setLeftChild(parentOfRoot);
                root.setParent(parentOfRoot.getParent());
                parentOfRoot.setParent(root);

                root.setRightChild(this.insert(root, item, root));
            } else {
                root.setRightChild(this.insert(root.getRightChild(), item, root));
            }

        }

        return root;
    }

    // Tests if the value of a < b
    private boolean greaterThan(T a, T b) {
        return a.compareTo(b) > 0;
    }

    // Tests if the value of a <= b
    private boolean greaterThanOrEqual(T a, T b) {
        return a.compareTo(b) >= 0;
    }

    // Tests if the value of a < b
    private boolean lessThan(T a, T b) {
        return a.compareTo(b) < 0;
    }

    // Tests if the value of a <= b
    private boolean lessThanOrEqual(T a, T b) {
        return a.compareTo(b) <= 0;
    }

}
