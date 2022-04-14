package com.example.tree;

import java.util.Iterator;

/**
 * Binary tree implementation.
 */
public class BTree<T> implements BinaryTree<T> {

    // The root node of the tree.
    private BinaryTreeNode<T> root;

    /**
     * Class constructor.
     */
    public BTree() {
        this.root = null;
    }

    public BTree(T data) {
        this.root = new BinaryTreeNode<>(data, null, null);
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(T item) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getChildren(TreeNode<T> node) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int getChildrenCount(TreeNode<T> node) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public int getDegree(TreeNode<T> node) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public int getDepth(TreeNode<T> node) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public int getHeight(TreeNode<T> node) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public BinaryTreeNode<T> getLeftChild(TreeNode<T> node) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public BinaryTreeNode<T> getRightChild(TreeNode<T> node) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesInOrder() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesLevelOrder() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesPreOrder() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesPostOrder() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesReverseInOrder() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesReverseLevelOrder() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesReversePreOrder() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesReversePostOrder() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public TreeNode<T> getParent(TreeNode<T> node) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public TreeNode<T> getRoot() {
        return this.root;
    }

    /**
     * {@inheritDoc}
     */
    public int height() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(T item) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isBalanced() {
        boolean balanced = true;

        return balanced;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isComplete() {
        boolean complete = true;

        return complete;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return this.getRoot() == null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isExternal(TreeNode<T> node) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isFull() {
        boolean full = true;

        return full;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isInternal(TreeNode<T> node) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isPerfect() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isRoot(TreeNode<T> node) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public T remove(T item) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public TreeNode<T> searchBreadthFirst(T item) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public TreeNode<T> searchDepthFirst(T item) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

}
