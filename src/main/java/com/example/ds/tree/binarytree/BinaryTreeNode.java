package com.example.ds.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

import com.example.ds.tree.TreeNode;

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

    /**
     * Returns a boolean indicating whether
     * the node is a left child of its parent
     * if it has a parent.
     * 
     * @return boolean
     */
    public boolean isLeftChild() {
        BinaryTreeNode<T> parent = (BinaryTreeNode<T>) this.getParent();

        return parent != null ? this.equals(parent.getLeftChild()) : false;
    }

    /**
     * Returns a boolean indicating whether
     * the node is a right child of its parent
     * if it has a parent.
     * 
     * @return boolean
     */
    public boolean isRightChild() {
        BinaryTreeNode<T> parent = (BinaryTreeNode<T>) this.getParent();

        return parent != null ? this.equals(parent.getRightChild()) : false;
    }

    /**
     * Sets the left child of the node.
     */
    public void setLeftChild(BinaryTreeNode<T> child) {
        this.leftChild = child;
    }

    /**
     * Sets the right child of the node.
     */
    public void setRightChild(BinaryTreeNode<T> child) {
        this.rightChild = child;
    }
}
