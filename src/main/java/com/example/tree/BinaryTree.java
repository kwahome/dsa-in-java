package com.example.tree;

/**
 * Binary tree interface.
 */
public interface BinaryTree<T> extends Tree<T> {

    /**
     * Return the left node of a specified node
     * or null if not present.
     * 
     * @param node TreeNode<T>
     * @return TreeNode<T>
     * @throws IllegalArgumentException
     */
    BinaryTreeNode<T> getLeftChild(TreeNode<T> node) throws IllegalArgumentException;

    /**
     * Return the right node of a specified node
     * or null if not present.
     * 
     * @param node TreeNode<T>
     * @return TreeNode<T>
     * @throws IllegalArgumentException
     */
    BinaryTreeNode<T> getRightChild(TreeNode<T> node) throws IllegalArgumentException;

    /**
     * Returns a boolean indicating whether the
     * height of the left and right subtree of
     * any node differ by not more than 1.
     * 
     * @return boolean
     */
    boolean isBalanced();

    /**
     * Returns a boolean indicating whether all
     * the levels are completely filled except
     * possibly the lowest one which is filled
     * from the left.
     * 
     * @return boolean
     */
    boolean isComplete();

    /**
     * Returns a boolean indicating whether the
     * binary tree parent/internal nodes has
     * either two or no children.
     * 
     * @return boolean
     */
    boolean isFull();

    /**
     * Returns a boolean indicating whether the
     * binary tree parent/internal nodes has
     * exactly two child nodes and all the
     * leaf nodes are at the same level.
     * 
     * @return boolean
     */
    boolean isPerfect();
}
