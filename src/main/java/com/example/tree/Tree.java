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
     * Returns the degree of a specified node.
     * 
     * The degree of a node is the number of
     * branches of that node.
     * 
     * @param node a TreeNode<T>
     * @return int
     */
    int getDegree(TreeNode<T> node);

    /**
     * Returns the depth of a specified node.
     * 
     * The depth of a node is the number of
     * edges from the root to the node.
     * 
     * @param node a TreeNode<T>
     * @return int
     */
    int getDepth(TreeNode<T> node);

    /**
     * Returns the height of a specified node.
     * 
     * The height of a node is the number of edges
     * from the node to the deepest leaf. In other
     * words, it's the longest path from a node to
     * a leaf node.
     * 
     * @param node a TreeNode<T>
     * @return int
     */
    int getHeight(TreeNode<T> node);

    /**
     * Return the nodes in a tree in order.
     * 
     * In order traversal is a DFS traversal
     * that starts from the left most towards
     * the right through the current node.
     * 
     * @return Iterable<TreeNode<T>>
     */
    Iterable<TreeNode<T>> getNodesInOrder();

    /**
     * Return the nodes in a tree in level order.
     * 
     * In order traversal is a BFS traversal
     * that traverses the tree level by level
     * starting from the left.
     * 
     * @return Iterable<TreeNode<T>>
     */
    Iterable<TreeNode<T>> getNodesLevelOrder();

    /**
     * Return the nodes in a tree pre order.
     * 
     * Pre order traversal is a DFS traversal
     * that starts from the current node then
     * to its left and finally its right.
     * 
     * @return Iterable<TreeNode<T>>
     */
    Iterable<TreeNode<T>> getNodesPreOrder();

    /**
     * Return the nodes in a tree post order.
     * 
     * Post order traversal is a DFS traversal
     * that starts from the left then to the
     * right and finally to the current node.
     * 
     * @return Iterable<TreeNode<T>>
     */
    Iterable<TreeNode<T>> getNodesPostOrder();

    /**
     * Return the nodes in a tree in reverse order.
     * 
     * Reverse in order traversal is a DFS traversal
     * that starts from the right most towards
     * the left through the current node.
     * 
     * @return Iterable<TreeNode<T>>
     */
    Iterable<TreeNode<T>> getNodesReverseInOrder();

    /**
     * Return the nodes in a tree in reverse level order.
     * 
     * In order traversal is a BFS traversal
     * that traverses the tree level by level
     * starting from the right.
     * 
     * @return Iterable<TreeNode<T>>
     */
    Iterable<TreeNode<T>> getNodesReverseLevelOrder();

    /**
     * Return the nodes in a tree reverse pre order.
     * 
     * Reverse pre-order traversal is a DFS traversal
     * that starts from the current node then to its
     * right and finally its left.
     * 
     * @return Iterable<TreeNode<T>>
     */
    Iterable<TreeNode<T>> getNodesReversePreOrder();

    /**
     * Return the nodes in a tree reverse post order.
     * 
     * Reverse post-order traversal is a DFS traversal
     * that starts from the right then to the left and
     * finally to the current node.
     * 
     * @return Iterable<TreeNode<T>>
     */
    Iterable<TreeNode<T>> getNodesReversePostOrder();

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
     * Returns the height of a tree.
     * 
     * The height of a tree is the number of edges
     * from the root node or the depth of the
     * deepest node.
     * 
     * @param node a TreeNode<T>
     * @return int
     */
    int height();

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
     * Returns a boolean indicating whether a node does not have children.
     * 
     * @param node (TreeNode<T> node
     * @return boolean
     * @throws IllegalArgumentException
     */
    boolean isExternal(TreeNode<T> node) throws IllegalArgumentException;

    /**
     * Returns a boolean indicating whether a node has at least one child.
     * 
     * @param node (TreeNode<T> node
     * @return boolean
     * @throws IllegalArgumentException
     */
    boolean isInternal(TreeNode<T> node) throws IllegalArgumentException;

    /**
     * Returns a boolean indicating whether a node is a root node of the tree.
     * 
     * @param node TreeNode<T>
     * @return boolean
     * @throws IllegalArgumentException
     */
    boolean isRoot(TreeNode<T> node) throws IllegalArgumentException;

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
     * Return the tree node containing a specified element or null
     * if not found.
     * 
     * The search proceeds level by level.
     * 
     * @param item to remove from the tree.
     * @return TreeNode<T>
     */
    public TreeNode<T> searchBreadthFirst(T item);

    /**
     * Return the tree node containing a specified element or null
     * if not found.
     * 
     * The search proceeds to the deepest level first.
     * 
     * @param item to remove from the tree.
     * @return TreeNode<T>
     */
    public TreeNode<T> searchDepthFirst(T item);

    /**
     * Returns the size of the tree. The size of a tree is the number of
     * items in the tree.
     * 
     * @return int.
     */
    int size();
}
