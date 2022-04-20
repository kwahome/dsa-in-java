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

    private BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T item, BinaryTreeNode<T> parent) {
        if (node == null) {
            node = new BinaryTreeNode<T>(item, parent);

            return node;
        }

        if (this.lessThanOrEqual(item, node.getData())) {
            node.setLeftChild(this.insert(node.getLeftChild(), item, node));
        } else {
            node.setRightChild(this.insert(node.getRightChild(), item, node));
        }

        return this.rebalance(node);
    }

    private BinaryTreeNode<T> rebalance(BinaryTreeNode<T> node) {
        if (node != null) {
            if (this.getHeightDifference(node) < -1) {

                // Left subtree is too high
                if (this.getHeightDifference(node.getLeftChild()) == -1) {
                    // and left child has a left child.
                    // rotate to the right to balance
                    return this.rotateRight(node);
                }

                if (this.getHeightDifference(node.getLeftChild()) == 1) {
                    // and left child has a right child.
                    // a double rotation is needed to balance
                    // rotate to the left then to the right
                    return this.rotateLeftRight(node);
                }
            }

            if (this.getHeightDifference(node) > 1) {

                // Right subtree is too high
                if (this.getHeightDifference(node.getRightChild()) == 1) {
                    // and right child has a right child.
                    // rotate to the left to balance
                    return this.rotateLeft(node);
                }

                if (this.getHeightDifference(node.getRightChild()) == -1) {
                    // and right child has a left child.
                    // a double rotation is needed to balance
                    // rotate to the right then to the left
                    return this.rotateRightLeft(node);
                }
            }
        }

        return node;
    }

    /**
     * A helper function to perform a left rotation of a rooted tree.
     * 
     * https://appliedgo.net/balancedtree/
     */
    private BinaryTreeNode<T> rotateLeft(BinaryTreeNode<T> node) {

        if (node != null) {
            BinaryTreeNode<T> right = node.getRightChild();

            node.setRightChild(right.getLeftChild());

            right.setLeftChild(node);

            return right;
        }

        return node;
    }

    /**
     * A helper function to perform a right rotation of a rooted tree.
     * 
     * https://appliedgo.net/balancedtree/
     */
    private BinaryTreeNode<T> rotateRight(BinaryTreeNode<T> node) {
        if (node != null) {
            BinaryTreeNode<T> left = node.getLeftChild();

            node.setLeftChild(left.getRightChild());

            left.setRightChild(node);

            return left;
        }

        return node;
    }

    /**
     * A helper function to perform a double right-left rotation of a rooted tree.
     * 
     * https://appliedgo.net/balancedtree/
     */
    private BinaryTreeNode<T> rotateRightLeft(BinaryTreeNode<T> node) {
        if (node != null) {
            node.setRightChild(this.rotateRight(node.getRightChild()));

            node = this.rotateLeft(node);

            return node;
        }

        return node;
    }

    /**
     * A helper function to perform a double left-right rotation of a rooted tree.
     * 
     * https://appliedgo.net/balancedtree/
     */
    private BinaryTreeNode<T> rotateLeftRight(BinaryTreeNode<T> node) {
        if (node != null) {
            node.setLeftChild(this.rotateLeft(node.getLeftChild()));

            node = this.rotateRight(node);

            return node;
        }

        return node;
    }

    private int getHeightDifference(BinaryTreeNode<T> node) {
        if (node != null) {
            return this.getHeight(node.getRightChild()) - this.getHeight(node.getLeftChild());
        }

        return 0;
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
