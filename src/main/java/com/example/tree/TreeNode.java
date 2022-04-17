package com.example.tree;

/**
 * Represents a node of a tree data-structure.
 */
public abstract class TreeNode<T> {

    // The data of this tree node.
    private T data;

    // The parent of this node
    private TreeNode<T> parent;

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
        this(data, null);
    }

    /**
     * Constructor.
     */
    public TreeNode(T data, TreeNode<T> parentNode) {
        this.data = data;
        this.parent = parentNode;
    }

    /**
     * Return the children associated with the node.
     * 
     * @return Iterable<TreeNode<T>>
     */
    public abstract Iterable<BinaryTreeNode<T>> getChildren();

    /**
     * Returns the number of children associated with the node
     * 
     * @return int
     */
    public abstract int getChildrenCount();

    /**
     * Return the data associated with the node.
     * 
     * @return T
     */
    public T getData() {
        return this.data;
    }

    /**
     * Returns the number of children of the node.
     * 
     * @return int
     */
    public int getDegree() {
        return this.getChildrenCount();
    }

    /**
     * Return the parent of a specified node or null if none.
     * 
     * @return TreeNode<T>
     */
    public TreeNode<T> getParent() {
        return this.parent;
    }

    /**
     * Returns a boolean indicating whether the node has children.
     * 
     * @return boolean
     */
    public boolean hasChildren() {
        return this.getChildrenCount() > 0;
    }

    /**
     * Returns a boolean indicating whether a node does not have children.
     * 
     * @return boolean
     */
    public boolean isExternal() {
        return !this.hasChildren();
    }

    /**
     * Returns a boolean indicating whether a node has at least one child.
     * 
     * @return boolean
     */
    public boolean isInternal() {
        return !this.isExternal();
    }

    /**
     * Sets the data associated with the node.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Sets the parent of the node.
     */
    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }
}
