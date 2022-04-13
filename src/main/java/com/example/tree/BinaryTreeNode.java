package com.example.tree;

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
        this(null, null, null);
    }

    /**
     * Constructor.
     */
    public BinaryTreeNode(T data, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
        super(data);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
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
}
