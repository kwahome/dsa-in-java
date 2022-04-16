package com.example.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a node of a binary tree.
 */
public class BinaryTreeNode<T> extends TreeNode<T> {

    // The left child of the binary tree
    private BinaryTreeNode<T> leftChild;

    // The right child of the binary tree;
    private BinaryTreeNode<T> rightChild;

    /**
     * Constructor.
     */
    public BinaryTreeNode() {
        this(null, null);
    }

    /**
     * Constructor.
     */
    public BinaryTreeNode(T data, BinaryTreeNode<T> parentNode) {
        super(data, parentNode);
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Constructor.
     */

    public BinaryTreeNode(T data, T leftChild, T rightChild) {
        this(data, null);

        this.leftChild = (leftChild != null) ? new BinaryTreeNode<>(leftChild, this) : null;
        this.rightChild = (rightChild != null) ? new BinaryTreeNode<>(rightChild, this) : null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<BinaryTreeNode<T>> getChildren() {
        List<BinaryTreeNode<T>> children = new ArrayList<>();

        children.add(this.getLeftChild());
        children.add(this.getRightChild());

        return children;
    }

    /**
     * {@inheritDoc}
     */
    public int getChildrenCount() {
        return (this.hasLeftChild() ? 1 : 0) + (this.hasRightChild() ? 1 : 0);
    }

    /**
     * Returns the left child of the node.
     * 
     * @return BinaryTreeNode<T>
     */
    public BinaryTreeNode<T> getLeftChild() {
        return this.leftChild;
    }

    /**
     * Returns the right child of the node.
     * 
     * @return BinaryTreeNode<T>
     */
    public BinaryTreeNode<T> getRightChild() {
        return this.rightChild;
    }

    /**
     * Returns a boolean indicating whether
     * a left child is present
     * 
     * @return boolean
     */
    public boolean hasLeftChild() {
        return this.getLeftChild() != null;
    }

    /**
     * Returns a boolean indicating whether
     * a right child is present
     * 
     * @return boolean
     */
    public boolean hasRightChild() {
        return this.getRightChild() != null;
    }

    /**
     * Returns a boolean indicating whether
     * the node is a leaf node.
     * 
     * @return boolean
     */
    public boolean isLeafNode() {
        return !this.hasLeftChild() && !this.hasRightChild();
    }
}
