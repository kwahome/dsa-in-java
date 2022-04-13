package com.example.tree;

/**
 * Binary tree interface.
 */
public interface BinaryTree<T> extends Tree<T> {

    /**
     * Return the left node of a specified node or null if not present.
     * 
     * @param node TreeNode<T>
     * @return TreeNode<T>
     * @throws IllegalArgumentException
     */
    TreeNode<T> getLeftChild(TreeNode<T> node) throws IllegalArgumentException;

    /**
     * Return the right node of a specified node or null if not present.
     * 
     * @param node TreeNode<T>
     * @return TreeNode<T>
     * @throws IllegalArgumentException
     */
    TreeNode<T> getRightChild(TreeNode<T> node) throws IllegalArgumentException;
}
