package com.example.tree.binarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.queues.FIFOQueue;
import com.example.queues.Queue;
import com.example.stack.LinkedListBasedStack;
import com.example.stack.Stack;
import com.example.tree.TraversalOrder;
import com.example.tree.TreeNode;

/**
 * Binary tree implementation.
 */
public class LinkedBinaryTree<T> implements BinaryTree<T> {

    // The root node of the tree.
    protected BinaryTreeNode<T> root;

    // The number of nodes in the tree;
    protected int numberOfNodes;

    /**
     * Class constructor.
     */
    public LinkedBinaryTree() {
        this.initialize(null, 0);
    }

    /**
     * Class constructor.
     */
    public LinkedBinaryTree(T data) {
        this(new BinaryTreeNode<>(data, null, null));
    }

    /**
     * Class constructor.
     */
    public LinkedBinaryTree(BinaryTreeNode<T> root) {
        this.initialize(root, 1 + this.getChildrenCount(root));
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        this.initialize(null, 0);
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(T item) {
        // Iterator<TreeNode<T>> nodesIterator = this.getNodesInOrder().iterator();

        // while (nodesIterator.hasNext()) {
        // if (nodesIterator.next().getData() == item) {
        // return true;
        // }
        // }

        // return false;

        return this.search(item, TraversalOrder.LEVEL_ORDER) != null;
    }

    /**
     * {@inheritDoc}
     */
    public int degree() {
        Iterator<TreeNode<T>> nodesIterator = this.getNodesInOrder().iterator();

        int maxNodeDegree = -1;

        while (nodesIterator.hasNext()) {
            maxNodeDegree = Math.max(maxNodeDegree, nodesIterator.next().getDegree());
        }

        return maxNodeDegree;
    }

    /**
     * {@inheritDoc}
     */
    public int getChildrenCount(TreeNode<T> node) throws IllegalArgumentException {
        BinaryTreeNode<T> binaryTreeNode = (BinaryTreeNode<T>) node;

        if (binaryTreeNode != null) {
            return (binaryTreeNode.hasLeftChild() ? 1 : 0) + (binaryTreeNode.hasRightChild() ? 1 : 0);
        }

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
        // cast into binary tree node
        BinaryTreeNode<T> binaryTreeNode = (BinaryTreeNode<T>) node;

        if (node == null) {
            return -1;
        }

        // compute the max height/depth of each sub tree
        return 1 + Math.max(this.getHeight(binaryTreeNode.getLeftChild()),
                this.getHeight(binaryTreeNode.getRightChild()));
    }

    /**
     * {@inheritDoc}
     */
    public BinaryTreeNode<T> getLeftChild(TreeNode<T> node) throws IllegalArgumentException {
        BinaryTreeNode<T> binaryTreeNode = (BinaryTreeNode<T>) node;

        return (binaryTreeNode != null) ? binaryTreeNode.getLeftChild() : null;
    }

    /**
     * {@inheritDoc}
     */
    public BinaryTreeNode<T> getRightChild(TreeNode<T> node) throws IllegalArgumentException {
        BinaryTreeNode<T> binaryTreeNode = (BinaryTreeNode<T>) node;

        return (binaryTreeNode != null) ? binaryTreeNode.getRightChild() : null;
    }

    /**
     * {@inheritDoc}
     */
    public int getMaxDepth() {
        return this.getHeight(this.getRoot());
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

        if (!this.isEmpty()) {
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

        Queue<BinaryTreeNode<T>> queue = new FIFOQueue<>(this.size());

        if (!this.isEmpty()) {
            queue.enqueue((BinaryTreeNode<T>) this.getRoot());

            while (!queue.isEmpty()) {
                BinaryTreeNode<T> current = queue.dequeue();

                snapshot.add(current);

                // We are using a FIFO queue
                // We want to enqueue the left child before the right
                // To ensure left sub tree is traversed before the right
                if (current.hasLeftChild()) {
                    queue.enqueue(current.getLeftChild());
                }

                if (current.hasRightChild()) {
                    queue.enqueue(current.getRightChild());
                }
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

        if (!this.isEmpty()) {
            Stack<BinaryTreeNode<T>> nodes = new LinkedListBasedStack<>(this.size());

            nodes.push((BinaryTreeNode<T>) this.getRoot());

            while (!nodes.isEmpty()) {
                BinaryTreeNode<T> current = nodes.pop();

                snapshot.add(current);

                // Stack is a LIFO queue
                // So push right child first then left child
                // So that left sub tree is traversed first

                if (current.hasRightChild()) {
                    nodes.push(current.getRightChild());
                }

                if (current.hasLeftChild()) {
                    nodes.push(current.getLeftChild());
                }
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

        if (!this.isEmpty()) {
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

        if (!this.isEmpty()) {
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

        if (!this.isEmpty()) {
            Queue<BinaryTreeNode<T>> queue = new FIFOQueue<>(this.size());

            queue.enqueue((BinaryTreeNode<T>) this.getRoot());

            while (!queue.isEmpty()) {
                BinaryTreeNode<T> current = queue.dequeue();

                snapshot.add(current);

                // We are using a FIFO queue
                // We want to enqueue the right child before the left
                // To ensure right sub tree is traversed before the left
                if (current.hasRightChild()) {
                    queue.enqueue(current.getRightChild());
                }

                if (current.hasLeftChild()) {
                    queue.enqueue(current.getLeftChild());
                }
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

        if (!this.isEmpty()) {
            Stack<BinaryTreeNode<T>> nodes = new LinkedListBasedStack<>(this.size());

            nodes.push((BinaryTreeNode<T>) this.getRoot());

            while (!nodes.isEmpty()) {
                BinaryTreeNode<T> current = nodes.pop();

                snapshot.add(current);

                // Stack is a LIFO queue
                // So push left child first then right child
                // So that right sub tree is traversed first

                if (current.hasLeftChild()) {
                    nodes.push(current.getLeftChild());
                }

                if (current.hasRightChild()) {
                    nodes.push(current.getRightChild());
                }
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

        if (!this.isEmpty()) {
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
        // We want to into the left most slot.

        if (this.isEmpty()) {
            // Tree is empty
            // We create the root node.
            this.root = new BinaryTreeNode<>(item, null);

            this.numberOfNodes++;

            return true;
        }

        // We traverse the tree level by level from the leftmost
        // until we find an empty slot

        Queue<BinaryTreeNode<T>> queue = new FIFOQueue<>(this.size());

        queue.enqueue((BinaryTreeNode<T>) this.getRoot());

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.dequeue();

            if (!current.hasLeftChild()) {
                current.setLeftChild(new BinaryTreeNode<>(item, current));

                this.numberOfNodes++;

                return true;
            } else {
                queue.enqueue(current.getLeftChild());
            }

            if (!current.hasRightChild()) {
                current.setRightChild(new BinaryTreeNode<>(item, current));

                this.numberOfNodes++;

                return true;
            } else {
                queue.enqueue(current.getRightChild());
            }
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isBalanced() {
        BinaryTreeNode<T> root = (BinaryTreeNode<T>) this.getRoot();

        return !(root == null)
                && Math.abs(this.getHeight(root.getLeftChild()) - this.getHeight(root.getRightChild())) <= 1;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isComplete() {
        boolean complete = !this.isEmpty();

        if (complete) {
            // Tree is not empty thus we want to check subtrees
            Queue<BinaryTreeNode<T>> queue = new FIFOQueue<>(this.size());

            queue.enqueue((BinaryTreeNode<T>) this.getRoot());

            while (!queue.isEmpty()) {
                BinaryTreeNode<T> current = queue.dequeue();

                if (current.hasChildren() && !current.hasLeftChild()) {
                    // not filled from the left
                    complete = false;

                    break;
                }

                // check for children
                if (current.hasLeftChild()) {
                    queue.enqueue(current.getLeftChild());
                }

                if (current.hasRightChild()) {
                    queue.enqueue(current.getRightChild());
                }
            }

        }

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

        if (this.isEmpty()) {
            return false;
        }

        if (this.isPerfect()) {
            return true;
        }

        Queue<BinaryTreeNode<T>> queue = new FIFOQueue<>(this.size());

        queue.enqueue((BinaryTreeNode<T>) this.getRoot());

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.dequeue();

            if (current.isInternal() && current.hasChildren()
                    && (0 < current.getChildrenCount() && current.getChildrenCount() < 2)) {
                return false;
            }

            if (current.hasLeftChild()) {
                queue.enqueue(current.getLeftChild());
            }

            if (current.hasRightChild()) {
                queue.enqueue(current.getRightChild());
            }
        }

        return true;
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
        return !this.isEmpty()
                && this.isPerfectSubTree((BinaryTreeNode<T>) this.getRoot(), this.getMaxDepth(), 0);

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
        // without recursion
        // Level by level traversal
        // From the leftmost to the rightmost

        List<T> snapshot = new ArrayList<>(this.size());

        Queue<BinaryTreeNode<T>> queue = new FIFOQueue<>(this.size());

        if (!this.isEmpty()) {
            queue.enqueue((BinaryTreeNode<T>) this.getRoot());

            while (!queue.isEmpty()) {
                BinaryTreeNode<T> current = queue.dequeue();

                snapshot.add(current.getData());

                // We are using a FIFO queue
                // We want to enqueue the left child before the right
                // To ensure left sub tree is traversed before the right
                if (current.hasLeftChild()) {
                    queue.enqueue(current.getLeftChild());
                }

                if (current.hasRightChild()) {
                    queue.enqueue(current.getRightChild());
                }
            }
        }

        return snapshot.iterator();
    }

    /**
     * {@inheritDoc}
     */
    public T remove(T item) {
        // We want to remove items from while
        // making sure it shrinks from the bottom

        // We do a level order traversal until the
        // rightmost leaf node to look for
        // 1: the node containing the item
        // 2: the rightmost leaf node

        if (this.isEmpty()) {
            return null;
        }

        Queue<BinaryTreeNode<T>> queue = new FIFOQueue<>(this.size());

        queue.enqueue((BinaryTreeNode<T>) this.getRoot());

        BinaryTreeNode<T> itemNode = null;
        BinaryTreeNode<T> rightMostLeafNode = null;

        // level order traversal
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.dequeue();

            if (current.getData().equals(item)) {
                // we have found the node we need to delete
                itemNode = current;
            }

            if (current.isExternal()) {
                // the last external node to be dequeued
                // will be the right most leaf node as it
                // was the last right child enqueued
                rightMostLeafNode = current;
            }

            if (current.hasLeftChild()) {
                queue.enqueue(current.getLeftChild());
            }

            if (current.hasRightChild()) {
                queue.enqueue(current.getRightChild());
            }
        }

        if (itemNode != null && rightMostLeafNode != null) {
            // swich the data item
            itemNode.setData(rightMostLeafNode.getData());

            // reset the left child pointer if right most was a left child
            if (!rightMostLeafNode.equals(this.getRoot()) && rightMostLeafNode.isLeftChild()) {

                ((BinaryTreeNode<T>) rightMostLeafNode.getParent()).setLeftChild(null);
            }

            // reset the right child pointer if right most was a right child
            if (!rightMostLeafNode.equals(this.getRoot()) && rightMostLeafNode.isRightChild()) {

                ((BinaryTreeNode<T>) rightMostLeafNode.getParent()).setRightChild(null);
            }

            // reset the root if that's what we have deleted
            if (rightMostLeafNode.equals(this.getRoot())) {
                this.root = null;
            }

            rightMostLeafNode = null;

            this.numberOfNodes--;

            return item;
        }

        return null;

    }

    /**
     * {@inheritDoc}
     */
    public TreeNode<T> search(T item) {
        return this.search((BinaryTreeNode<T>) this.getRoot(), item);
    }

    /**
     * {@inheritDoc}
     */
    public TreeNode<T> search(T item, TraversalOrder traversalOrder) {
        return this.search((BinaryTreeNode<T>) this.getRoot(), item, traversalOrder);
    }

    /**
     * {@inheritDoc}
     */
    public TreeNode<T> search(TreeNode<T> searchStartNode, T item) {
        return this.search(searchStartNode, item, TraversalOrder.LEVEL_ORDER);
    }

    /**
     * {@inheritDoc}
     */
    public TreeNode<T> search(TreeNode<T> searchStartNode, T item, TraversalOrder traversalOrder) {

        if (item != null) {
            BinaryTreeNode<T> startNode = (BinaryTreeNode<T>) searchStartNode;

            switch (traversalOrder) {
                case LEVEL_ORDER:
                    return this.bfs(startNode, item, false);

                case IN_ORDER:
                    return this.dfsInOrder(startNode, item, false);

                case PRE_ORDER:
                    return this.dfsPreOrder(startNode, item, false);

                case POST_ORDER:
                    return this.dfsPostOrder(startNode, item, false);

                case REVERSE_LEVEL_ORDER:
                    return this.bfs(startNode, item, true);

                case REVERSE_IN_ORDER:
                    return this.dfsInOrder(startNode, item, true);

                case REVERSE_PRE_ORDER:
                    return this.dfsPreOrder(startNode, item, true);

                case REVERSE_POST_ORDER:
                    return this.dfsPostOrder(startNode, item, true);

                default:
                    return null;
            }
        }

        return null;
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
        if (!subTreeRoot.hasChildren()) {
            return depth == level;
        }

        // if either child is null, the tree is not perfect
        if (!subTreeRoot.hasLeftChild() || !subTreeRoot.hasRightChild()) {
            return false;
        }

        return this.isPerfectSubTree(subTreeRoot.getLeftChild(), depth, level + 1)
                && this.isPerfectSubTree(subTreeRoot.getRightChild(), depth, level + 1);
    }

    /**
     * Recursive implementation of the Breadth First search
     * 
     * @param T item<T>
     * @return TreeNode<T>
     */
    private BinaryTreeNode<T> bfs(BinaryTreeNode<T> startNode, T item, boolean reverse) {
        // Level by level traversal
        // From the leftmost to the rightmost

        Queue<BinaryTreeNode<T>> queue = new FIFOQueue<>(Math.max(1, this.size()));

        queue.enqueue(startNode);

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.dequeue();

            if (current != null) {

                if (current.getData().equals(item)) {
                    return current;
                }

                if (reverse) {
                    // We are using a FIFO queue
                    // We want to enqueue the right child before the left
                    // To ensure right sub tree is traversed before the left
                    if (current.hasRightChild()) {
                        queue.enqueue(current.getRightChild());
                    }

                    if (current.hasLeftChild()) {
                        queue.enqueue(current.getLeftChild());
                    }
                } else {
                    // We are using a FIFO queue
                    // We want to enqueue the left child before the right
                    // To ensure left sub tree is traversed before the right
                    if (current.hasLeftChild()) {
                        queue.enqueue(current.getLeftChild());
                    }

                    if (current.hasRightChild()) {
                        queue.enqueue(current.getRightChild());
                    }
                }
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
    private BinaryTreeNode<T> dfsInOrder(BinaryTreeNode<T> startNode, T item, boolean reverse) {

        Stack<BinaryTreeNode<T>> visit = new LinkedListBasedStack<>(this.size());

        BinaryTreeNode<T> current = (BinaryTreeNode<T>) this.getRoot();

        while (!visit.isEmpty() || current != null) {
            if (reverse) {
                // R -> N -> L
                if (current != null) {

                    if (current.getData().equals(item)) {
                        return current;
                    }

                    visit.push(current);

                    current = current.getRightChild();

                } else {

                    BinaryTreeNode<T> node = visit.pop();

                    if (node.getData().equals(item)) {
                        return node;
                    }

                    current = node.getLeftChild();
                }
            } else {
                // L -> N -> R
                if (current != null) {

                    if (current.getData().equals(item)) {
                        return current;
                    }

                    visit.push(current);

                    current = current.getLeftChild();

                } else {

                    BinaryTreeNode<T> node = visit.pop();

                    if (node.getData().equals(item)) {
                        return node;
                    }

                    current = node.getRightChild();
                }
            }
        }

        return null;
    }

    /**
     * Pre-order depth first search.
     * 
     * @param node    A BinaryTreeNode<T> node
     * @param item    A T item
     * @param reverse boolean indicating whether the search should be in reverse.
     * @return BinaryTreeNode<T>
     */
    private BinaryTreeNode<T> dfsPreOrder(BinaryTreeNode<T> node, T item, boolean reverse) {

        Stack<BinaryTreeNode<T>> visit = new LinkedListBasedStack<>(this.size());

        visit.push((BinaryTreeNode<T>) this.getRoot());

        while (!visit.isEmpty()) {
            if (reverse) {
                // N -> R -> L

                BinaryTreeNode<T> current = visit.pop();

                if (current != null && current.getData().equals(item)) {
                    return current;
                }

                // Stack is a LIFO queue
                // So push right child first then left child
                // So that left sub tree is traversed first

                if (current.hasLeftChild()) {
                    visit.push(current.getLeftChild());
                }

                if (current.hasRightChild()) {
                    visit.push(current.getRightChild());
                }

            } else {
                // N -> L -> R

                BinaryTreeNode<T> current = visit.pop();

                if (current != null && current.getData().equals(item)) {
                    return current;
                }

                // Stack is a LIFO queue
                // So push right child first then left child
                // So that left sub tree is traversed first

                if (current.hasRightChild()) {
                    visit.push(current.getRightChild());
                }

                if (current.hasLeftChild()) {
                    visit.push(current.getLeftChild());
                }
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
    private BinaryTreeNode<T> dfsPostOrder(BinaryTreeNode<T> node, T item, boolean reverse) {
        Stack<BinaryTreeNode<T>> visit = new LinkedListBasedStack<>(this.size());
        Stack<BinaryTreeNode<T>> reverseVisit = new LinkedListBasedStack<>(this.size());

        visit.push((BinaryTreeNode<T>) this.getRoot());

        while (!visit.isEmpty()) {

            if (reverse) {
                // R -> L -> N

                BinaryTreeNode<T> current = visit.pop();

                if (current != null && current.getData().equals(item)) {
                    return current;
                }

                reverseVisit.push(current);

                if (current.hasRightChild()) {
                    visit.push(current.getRightChild());
                }

                if (current.hasLeftChild()) {
                    visit.push(current.getLeftChild());
                }

            } else {

                BinaryTreeNode<T> current = visit.pop();

                if (current != null && current.getData().equals(item)) {
                    return current;
                }

                reverseVisit.push(current);

                if (current.hasLeftChild()) {
                    visit.push(current.getLeftChild());
                }

                if (current.hasRightChild()) {
                    visit.push(current.getRightChild());
                }
            }

        }
        return null;
    }

    /**
     * Initialize a binary tree.
     * 
     * @param rootNode      the BinaryTreeNode<T> root node.
     * @param numberOfNodes the number of nodes.
     */
    private void initialize(BinaryTreeNode<T> rootNode, int numberOfNodes) {
        this.root = rootNode;
        this.numberOfNodes = numberOfNodes;
    }
}