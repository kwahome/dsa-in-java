package com.example.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.queues.FIFOQueue;
import com.example.queues.Queue;
import com.example.stack.LinkedListBasedStack;
import com.example.stack.Stack;

/**
 * Binary tree implementation.
 */
public class BTree<T> implements BinaryTree<T> {

    // The root node of the tree.
    private BinaryTreeNode<T> root;

    // The number of nodes in the tree;
    private int numberOfNodes;

    /**
     * Class constructor.
     */
    public BTree() {
        this.root = null;
        this.numberOfNodes = 0;
    }

    /**
     * Class constructor.
     */
    public BTree(T data) {
        this(new BinaryTreeNode<>(data, null, null));
    }

    /**
     * Class constructor.
     */
    public BTree(BinaryTreeNode<T> root) {
        this.root = root;
        this.numberOfNodes = 1 + this.getChildrenCount(root);
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
        Iterator<TreeNode<T>> nodesIterator = this.getNodesInOrder().iterator();

        while (nodesIterator.hasNext()) {
            if (nodesIterator.next().getData() == item) {
                return true;
            }
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    public int getChildrenCount(TreeNode<T> node) throws IllegalArgumentException {
        BinaryTreeNode<T> bTreeNode = (BinaryTreeNode<T>) node;

        if (bTreeNode != null) {
            return (bTreeNode.hasLeftChild() ? 1 : 0) + (bTreeNode.hasRightChild() ? 1 : 0);
        }

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
        // int depth = 0;
        // while (node != null) {
        // if (node.equals(this.getRoot())) {
        // break;
        // }
        // depth++;
        // node = this.getParent(node);
        // }

        if (node != null && !node.equals(this.getRoot())) {
            return 1 + this.getDepth(node.getParent());
        }

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public int getHeight(TreeNode<T> node) {

        if (this.isEmpty() || node == null) {
            return -1;
        }

        // cast into binary tree node
        BinaryTreeNode<T> bTreeNode = (BinaryTreeNode<T>) node;

        // compute the max height/depth of each subtree
        return Math.max(this.getHeight(bTreeNode.getLeftChild()), this.getHeight(bTreeNode.getRightChild())) + 1;
    }

    /**
     * {@inheritDoc}
     */
    public BinaryTreeNode<T> getLeftChild(TreeNode<T> node) throws IllegalArgumentException {
        BinaryTreeNode<T> bTreeNode = (BinaryTreeNode<T>) node;

        return (bTreeNode != null) ? bTreeNode.getLeftChild() : null;
    }

    /**
     * {@inheritDoc}
     */
    public BinaryTreeNode<T> getRightChild(TreeNode<T> node) throws IllegalArgumentException {
        BinaryTreeNode<T> bTreeNode = (BinaryTreeNode<T>) node;

        return (bTreeNode != null) ? bTreeNode.getRightChild() : null;
    }

    /**
     * https://www.java67.com/2016/09/inorder-traversal-of-binary-tree-java-example.html
     * 
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesInOrder() {
        // without recursion
        // L -> N -> R

        List<TreeNode<T>> snapshot = new ArrayList<>(this.size());

        Stack<BinaryTreeNode<T>> nodes = new LinkedListBasedStack<>(this.size());

        BinaryTreeNode<T> current = (BinaryTreeNode<T>) this.getRoot();

        while (!nodes.isEmpty() || current != null) {

            if (current != null) {

                nodes.push(current);

                current = current.getLeftChild();

            } else {

                BinaryTreeNode<T> node = nodes.pop();

                snapshot.add(node);

                current = node.getRightChild();
            }
        }

        return snapshot;
    }

    /**
     * https://www.geeksforgeeks.org/level-order-tree-traversal/
     * 
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesLevelOrder() {
        // without recursion
        // Level by level traversal
        // From the leftmost to the rightmost

        List<TreeNode<T>> snapshot = new ArrayList<>(this.size());

        Queue<BinaryTreeNode<T>> queue = new FIFOQueue<>();

        queue.enqueue((BinaryTreeNode<T>) this.getRoot());

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.dequeue();

            snapshot.add(current);

            // We are using a FIFO queue
            // We want to enqueue the left child before the right
            // To ensure left subtree is traversed before the right
            if (current.hasLeftChild()) {
                queue.enqueue(current.getLeftChild());
            }

            if (current.hasRightChild()) {
                queue.enqueue(current.getRightChild());
            }
        }

        return snapshot;
    }

    /**
     * https://www.java67.com/2016/07/binary-tree-preorder-traversal-in-java-without-recursion.html
     * 
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesPreOrder() {
        // without recursion
        // N -> L -> R

        List<TreeNode<T>> snapshot = new ArrayList<>(this.size());

        Stack<BinaryTreeNode<T>> nodes = new LinkedListBasedStack<>(this.size());

        nodes.push((BinaryTreeNode<T>) this.getRoot());

        while (!nodes.isEmpty()) {
            BinaryTreeNode<T> current = nodes.pop();

            // Stack is a LIFO queue
            // So push right child first then left child
            // So that left subtree is traversed first

            if (current.hasRightChild()) {
                nodes.push(current.getRightChild());
            }

            if (current.hasLeftChild()) {
                nodes.push(current.getLeftChild());
            }
        }

        return snapshot;
    }

    /**
     * https://www.geeksforgeeks.org/iterative-postorder-traversal/
     * 
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesPostOrder() {
        // without recursion
        // L->R->N

        List<TreeNode<T>> snapshot = new ArrayList<>(this.size());

        Stack<BinaryTreeNode<T>> nodes = new LinkedListBasedStack<>(this.size());
        Stack<BinaryTreeNode<T>> reverseNodes = new LinkedListBasedStack<>(this.size());

        nodes.push((BinaryTreeNode<T>) this.getRoot());

        while (!nodes.isEmpty()) {

            BinaryTreeNode<T> current = nodes.pop();

            reverseNodes.push(current);

            if (current.hasLeftChild()) {
                nodes.push(current.getLeftChild());
            }

            if (current.hasRightChild()) {
                nodes.push(current.getRightChild());
            }
        }

        while (!reverseNodes.isEmpty()) {
            snapshot.add(reverseNodes.pop());
        }

        return snapshot;
    }

    /**
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesReverseInOrder() {
        // without recursion
        // R -> N -> L

        List<TreeNode<T>> snapshot = new ArrayList<>(this.size());

        Stack<BinaryTreeNode<T>> nodes = new LinkedListBasedStack<>(this.size());

        BinaryTreeNode<T> current = (BinaryTreeNode<T>) this.getRoot();

        while (!nodes.isEmpty() || current != null) {

            if (current != null) {

                nodes.push(current);

                current = current.getRightChild();

            } else {

                BinaryTreeNode<T> node = nodes.pop();

                snapshot.add(node);

                current = node.getLeftChild();
            }
        }

        return snapshot;
    }

    /**
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesReverseLevelOrder() {
        // without recursion
        // Level by level traversal
        // From the rightmost to the leftmost

        List<TreeNode<T>> snapshot = new ArrayList<>(this.size());

        Queue<BinaryTreeNode<T>> queue = new FIFOQueue<>();

        queue.enqueue((BinaryTreeNode<T>) this.getRoot());

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.dequeue();

            snapshot.add(current);

            // We are using a FIFO queue
            // We want to enqueue the right child before the left
            // To ensure right subtree is traversed before the left
            if (current.hasRightChild()) {
                queue.enqueue(current.getRightChild());
            }

            if (current.hasLeftChild()) {
                queue.enqueue(current.getLeftChild());
            }
        }

        return snapshot;
    }

    /**
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesReversePreOrder() {
        // without recursion
        // N -> R -> L

        List<TreeNode<T>> snapshot = new ArrayList<>(this.size());

        Stack<BinaryTreeNode<T>> nodes = new LinkedListBasedStack<>(this.size());

        nodes.push((BinaryTreeNode<T>) this.getRoot());

        while (!nodes.isEmpty()) {
            BinaryTreeNode<T> current = nodes.pop();

            // Stack is a LIFO queue
            // So push left child first then right child
            // So that right subtree is traversed first

            if (current.hasLeftChild()) {
                nodes.push(current.getLeftChild());
            }

            if (current.hasRightChild()) {
                nodes.push(current.getRightChild());
            }
        }

        return snapshot;
    }

    /**
     * {@inheritDoc}
     */
    public Iterable<TreeNode<T>> getNodesReversePostOrder() {
        // without recursion
        // R->L->N

        List<TreeNode<T>> snapshot = new ArrayList<>(this.size());

        Stack<BinaryTreeNode<T>> nodes = new LinkedListBasedStack<>(this.size());
        Stack<BinaryTreeNode<T>> reverseNodes = new LinkedListBasedStack<>(this.size());

        nodes.push((BinaryTreeNode<T>) this.getRoot());

        while (!nodes.isEmpty()) {

            BinaryTreeNode<T> current = nodes.pop();

            reverseNodes.push(current);

            if (current.hasRightChild()) {
                nodes.push(current.getRightChild());
            }

            if (current.hasLeftChild()) {
                nodes.push(current.getLeftChild());
            }
        }

        while (!reverseNodes.isEmpty()) {
            snapshot.add(reverseNodes.pop());
        }

        return snapshot;
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
        return this.getHeight(this.getRoot());
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
        return node.isExternal();
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
        return node.isInternal();
    }

    /**
     * {@inheritDoc}
     */
    public boolean isPerfect() {
        return this.isPerfectSubTree((BinaryTreeNode<T>) this.getRoot(), this.getDepth(this.getRoot()), 0);

    }

    /**
     * {@inheritDoc}
     */
    public boolean isRoot(TreeNode<T> node) throws IllegalArgumentException {
        return this.getRoot().equals(node);
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
        return this.recursiveDFS((BinaryTreeNode<T>) this.getRoot(), item, DFSOrder.IN_ORDER, false);
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return this.numberOfNodes;
    }

    /**
     * Returns a boolean indicating whether a node is perfect or not.
     * 
     * @param subTreeRoot
     * @param depth
     * @param level
     * @return
     */
    private boolean isPerfectSubTree(BinaryTreeNode<T> subTreeRoot, int depth, int level) {
        if (subTreeRoot == null) {
            return true;
        }

        // if both children are null; check the levels
        if (subTreeRoot.getLeftChild() == null && subTreeRoot.getRightChild() == null) {
            return depth + 1 == level;
        }

        // if either child is null, the tree is not perfect
        if (subTreeRoot.getLeftChild() == null || subTreeRoot.getRightChild() == null) {
            return false;
        }

        return this.isPerfectSubTree(subTreeRoot.getLeftChild(), depth, level + 1)
                && this.isPerfectSubTree(subTreeRoot.getRightChild(), depth, level + 1);
    }

    /**
     * Recursive implementation of the Breadth First search
     * 
     * @param node BinaryTreeNode<T>
     * @return TreeNode<T>
     */
    private BinaryTreeNode<T> recursiveBFS(BinaryTreeNode<T> node) {
        return null;
    }

    /**
     * Recursive implementation of the Depth First Search.
     * 
     * @param node           BinaryTreeNode<T>
     * @param item           T
     * @param traversalOrder DFSOrder
     * @param reverse        boolean
     * @return BinaryTreeNode<T>
     */
    private BinaryTreeNode<T> recursiveDFS(BinaryTreeNode<T> node, T item, DFSOrder traversalOrder, boolean reverse) {
        if (node != null) {
            switch (traversalOrder) {
                case IN_ORDER:
                    return this.searchInOrder(node, item, reverse);

                case PRE_ORDER:
                    return this.searchPreOrder(node, item, reverse);

                case POST_ORDER:
                    return this.searchPostOrder(node, item, reverse);

                default:
                    break;
            }
        }

        return null;
    }

    /**
     * In-order depth first search.
     * 
     * @param startNode A BinaryTreeNode<T> node
     * @param item      A T item
     * @param reverse   boolean indicating whether the search should be in reverse.
     * @return BinaryTreeNode<T>
     */
    private BinaryTreeNode<T> searchInOrder(BinaryTreeNode<T> startNode, T item, boolean reverse) {
        BinaryTreeNode<T> itemNode = null;

        if (startNode == null) {
            return itemNode;
        }

        if (reverse) {
            // R -> N -> L

            // go deep to the right first until we hit a leaf node
            this.searchInOrder(startNode.getRightChild(), item, reverse);

            if (startNode.getData().equals(item)) {
                // we have found our node
                itemNode = startNode;
            }

            // go deep to the left first until we hit a leaf node
            this.searchInOrder(startNode.getLeftChild(), item, reverse);
        } else {
            // L -> N -> R

            // go deep to the left first until we hit a leaf node
            this.searchInOrder(startNode.getLeftChild(), item, reverse);

            // System.out.println(startNode.getData());
            // System.out.println(startNode.getData().equals(item));
            // System.out.println();

            if (startNode.getData().equals(item)) {
                itemNode = startNode;
            }

            // go deep to the right first until we hit a leaf node
            this.searchInOrder(startNode.getRightChild(), item, reverse);
        }

        System.out.println(itemNode);

        return itemNode;
    }

    /**
     * Pre-order depth first search.
     * 
     * @param node    A BinaryTreeNode<T> node
     * @param item    A T item
     * @param reverse boolean indicating whether the search should be in reverse.
     * @return BinaryTreeNode<T>
     */
    private BinaryTreeNode<T> searchPreOrder(BinaryTreeNode<T> node, T item, boolean reverse) {
        if (node != null) {
            if (node.getData().equals(item)) {
                // we have found our node
                return node;
            }

            if (reverse) {
                // N -> R -> L

                // go deep to the right first until we hit a leaf node
                this.searchPreOrder(node.getRightChild(), item, reverse);

                // go deep to the left first until we hit a leaf node
                this.searchPreOrder(node.getLeftChild(), item, reverse);

            } else {
                // N -> L -> R

                // go deep to the left first until we hit a leaf node
                this.searchPreOrder(node.getLeftChild(), item, reverse);

                // go deep to the right first until we hit a leaf node
                this.searchPreOrder(node.getRightChild(), item, reverse);
            }
        }

        return null;
    }

    /**
     * Post-order depth first search.
     * 
     * @param node    A BinaryTreeNode<T> node
     * @param item    A T item
     * @param reverse boolean indicating whether the search should be in reverse.
     * @return BinaryTreeNode<T>
     */
    private BinaryTreeNode<T> searchPostOrder(BinaryTreeNode<T> node, T item, boolean reverse) {
        if (node != null) {
            if (reverse) {
                // R -> L -> N

                // go deep to the right first until we hit a leaf node
                this.searchPostOrder(node.getRightChild(), item, reverse);

                // go deep to the left first until we hit a leaf node
                this.searchPostOrder(node.getLeftChild(), item, reverse);

            } else {
                // N -> R -> L

                // go deep to the left first until we hit a leaf node
                this.searchPostOrder(node.getLeftChild(), item, reverse);

                // go deep to the right first until we hit a leaf node
                this.searchPostOrder(node.getRightChild(), item, reverse);

            }

            if (node.getData().equals(item)) {
                // we have found our node
                return node;
            }
        }

        return null;
    }
}
