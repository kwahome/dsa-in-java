package com.example.tree;

import java.util.Iterator;

/**
 * Tree interface.
 */
public interface Tree<T> extends Iterable<T> {

    /**
     * Clear the entire tree.
     */
    public void clear();

    /**
     * Returns a boolean representing whether
     * the tree contains a specified item.
     * 
     * @param item to locate in the tree.
     * @return True if tree contains value.
     */
    public boolean contains(T item);

    /**
     * Returns an iterable containing the children of a node.
     * 
     * @param node TreeNode<T>
     * @return Iterable<TreeNode<T>>
     * @throws IllegalArgumentException
     */
    Iterable<TreeNode<T>> getChildren(TreeNode<T> node) throws IllegalArgumentException;

    /**
     * Returns the count of children nodes of a specified node.
     * 
     * @param node Iterator<T>
     * @return int
     * @throws IllegalArgumentException
     */
    int getChildrenCount(TreeNode<T> node) throws IllegalArgumentException;

    /**
     * Return the nodes in a tree in order.
     * 
     * In order traversal starts from the
     * left most towards the right through
     * the current node.
     * 
     * @return Iterable<TreeNode<T>>
     */
    Iterable<TreeNode<T>> getNodesInorder();

    /**
     * Return the nodes in a tree pre order.
     * 
     * Pre order traversal starts from the
     * current node then to its left and
     * finally its right.
     * 
     * @return Iterable<TreeNode<T>>
     */
    Iterable<TreeNode<T>> getNodesPreorder();

    /**
     * Return the nodes in a tree post order.
     * 
     * Post order traversal starts from the
     * left then to the right and finally
     * the current node.
     * 
     * @return Iterable<TreeNode<T>>
     */
    Iterable<TreeNode<T>> getNodesPostorder();

    /**
     * Return the parent of a specified node or null if none.
     * 
     * @param node TreeNode<T>
     * @return TreeNode<T>
     * @throws IllegalArgumentException
     */
    TreeNode<T> getParent(TreeNode<T> node) throws IllegalArgumentException;

    /**
     * Returns the root node of the tree.
     * 
     * @return Iterator<T>
     */
    TreeNode<T> getRoot();

    /**
     * Returns a boolean indicating whether a node is a root node of the tree.
     * 
     * @param node TreeNode<T>
     * @return boolean
     * @throws IllegalArgumentException
     */
    boolean isRoot(TreeNode<T> node) throws IllegalArgumentException;

    /**
     * Insert an item into the tree.
     * 
     * @param item an item T
     * @return boolean
     */
    boolean insert(T item);

    /**
     * Return a boolean indicating whether the tree has at least one node.
     * 
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Returns a boolean indicating whether a node has at least one child.
     * 
     * @param node (TreeNode<T> node
     * @return boolean
     * @throws IllegalArgumentException
     */
    boolean isInternal(TreeNode<T> node) throws IllegalArgumentException;

    /**
     * Returns a boolean indicating whether a node does not have children.
     * 
     * @param node (TreeNode<T> node
     * @return boolean
     * @throws IllegalArgumentException
     */
    boolean isExternal(TreeNode<T> node) throws IllegalArgumentException;

    /**
     * Returns an iterator.
     * 
     * @return Iterator<T>
     */
    Iterator<T> iterator();

    /**
     * Remove and return the first occurrence of an item in the tree.
     * 
     * @param item to remove from the tree.
     * @return T item removed from tree.
     */
    public T remove(T item);

    /**
     * Return a boolean indicating whether an item is present in the tree.
     * 
     * @param item to remove from the tree.
     * @return boolean.
     */
    public boolean search(T item);

    /**
     * Returns the size of the tree. The size of a tree is the number of
     * items in the tree.
     * 
     * @return int.
     */
    int size();
}
