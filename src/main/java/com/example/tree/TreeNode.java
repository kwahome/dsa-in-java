package com.example.tree;

/**
 * Represents a node of a tree data-structure.
 */
public class TreeNode<T> {
    // The data of this tree node.
    private T data;

    /**
     * Constructor.
     */
    public TreeNode() {
        this(null);
    }

    /**
     * Constructor.
     */
    public TreeNode(T data) {
        this.data = data;
    }

    /**
     * Return the data associated with the node.
     * 
     * @return T
     */
    public T getData() {
        return this.data;
    }
}
