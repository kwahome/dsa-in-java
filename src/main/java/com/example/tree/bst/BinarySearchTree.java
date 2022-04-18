package com.example.tree.bst;

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

}
