package com.example.ds.tree.bst;

import com.example.ds.tree.TreeNode;
import com.example.ds.tree.binarytree.BinaryTreeNode;
import com.example.ds.tree.binarytree.LinkedBinaryTree;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(T item) {
        return this.search(item) != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean insert(T item) {
        this.root = this.insert((BinaryTreeNode<T>) this.getRoot(), item, null);

        this.numberOfNodes++;

        return true;
    }

    /**
     * Removes an item from a binary seach tree using a logarithmic
     * algorithm to look for the item that is to be removed. The
     * deletion maintains the tree's height balance
     * 
     * @param item the item to be removed
     * @return T the removed item
     */
    @Override
    public T remove(T item) {
        BinaryTreeNode<T> removed = this.remove((BinaryTreeNode<T>) this.getRoot(), item);

        if (removed == null) {
            return null;
        }

        if (!this.isBalanced()) {
            this.rebalance((BinaryTreeNode<T>) this.getRoot());
        }

        return item;
    }

    /**
     * Search for an item in a BST with an algorithm that discards
     * half the tree at each stage and is thus O(log n) in space
     * complexity
     * 
     * @param item the item to search
     * @return TreeNode<T>
     */
    @Override
    public TreeNode<T> search(T item) {
        return this.search((BinaryTreeNode<T>) this.getRoot(), item);
    }

    /**
     * Search for an item in a BST given a starting point of the
     * search with an algorithm that discards half the tree at
     * each stage and is thus O(log n) in space complexity
     * 
     * @param searchStartNode TreeNode<T>
     * @param item            the item to search
     * @return TreeNode<T>
     */
    @Override
    public TreeNode<T> search(TreeNode<T> searchStartNode, T item) {

        if (searchStartNode != null && item != null) {
            BinaryTreeNode<T> bstSearchStartNode = (BinaryTreeNode<T>) searchStartNode;

            if (item.equals(bstSearchStartNode.getData())) {
                // we have found it
                return bstSearchStartNode;
            }

            if (this.lessThan(item, bstSearchStartNode.getData())) {
                // the search key will be in the left sub tree
                return this.search(bstSearchStartNode.getLeftChild(), item);
            }

            if (this.greaterThan(item, bstSearchStartNode.getData())) {
                // the search key will be in the right sub tree
                return this.search(bstSearchStartNode.getRightChild(), item);
            }
        }

        return null;
    }

    private BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T item, BinaryTreeNode<T> parent) {
        if (node == null) {
            node = new BinaryTreeNode<T>(item, parent);

            return node;
        }

        if (this.lessThanOrEqual(item, node.getData())) {
            node.setLeftChild(this.insert(node.getLeftChild(), item, node));
        } else {
            node.setRightChild(this.insert(node.getRightChild(), item, node));
        }

        return this.rebalance(node);
    }

    /**
     * Return node's successor value
     * 
     * @param node
     * @return T
     */
    private BinaryTreeNode<T> getSuccessor(BinaryTreeNode<T> node) {

        if (node != null) {
            node = node.getRightChild();

            while (node.hasLeftChild()) {
                node = node.getLeftChild();
            }

            return node;
        }

        return null;
    }

    /**
     * Return node's predecessor value
     * 
     * @param node
     * @return T
     */
    private BinaryTreeNode<T> getPredecessor(BinaryTreeNode<T> node) {
        if (node != null) {
            node = node.getLeftChild();

            while (node.hasRightChild()) {
                node = node.getRightChild();
            }

            return node;
        }

        return null;
    }

    private BinaryTreeNode<T> remove(BinaryTreeNode<T> subTreeRoot, T deleteKey) {
        if (subTreeRoot == null) {
            return null;
        }

        if (subTreeRoot.getData().equals(deleteKey)) {
            // we have found it

            if (!subTreeRoot.hasLeftChild() && !subTreeRoot.hasRightChild()) {

                if (this.getRoot().equals(subTreeRoot)) {
                    // we are deleting the last node in the tree
                    this.clear();

                } else {
                    // it's a leaf node
                    subTreeRoot = null;

                    this.numberOfNodes--;
                }

            } else if (subTreeRoot.hasRightChild()) {
                // it's a right child
                // we get the left most child (lowest item in the right subtree)
                // to succeed it
                subTreeRoot.setData(this.getSuccessor(subTreeRoot).getData());
                subTreeRoot.setRightChild(this.remove(subTreeRoot.getRightChild(), subTreeRoot.getData()));
            } else {
                // we try and get a node that can fill in for the delete node
                // by looking for the largest node in the left subtree
                subTreeRoot.setData(this.getPredecessor(subTreeRoot).getData());
                subTreeRoot.setLeftChild(this.remove(subTreeRoot.getLeftChild(), subTreeRoot.getData()));
            }

        } else if (this.lessThan(deleteKey, subTreeRoot.getData())) {
            // the delete key will be in the left sub tree
            subTreeRoot.setLeftChild(this.remove(subTreeRoot.getLeftChild(), deleteKey));

        } else if (this.greaterThan(deleteKey, subTreeRoot.getData())) {
            // the delete key will be in the right sub tree
            subTreeRoot.setRightChild(this.remove(subTreeRoot.getRightChild(), deleteKey));
        }

        return subTreeRoot;
    }

    private BinaryTreeNode<T> rebalance(BinaryTreeNode<T> node) {
        if (node != null) {
            if (this.getHeightDifference(node) < -1) {

                // Left subtree is too high
                if (this.getHeightDifference(node.getLeftChild()) == -1) {
                    // and left child has a left child.
                    // rotate to the right to balance
                    return this.rotateRight(node);
                }

                if (this.getHeightDifference(node.getLeftChild()) == 1) {
                    // and left child has a right child.
                    // a double rotation is needed to balance
                    // rotate to the left then to the right
                    return this.rotateLeftRight(node);
                }
            }

            if (this.getHeightDifference(node) > 1) {

                // Right subtree is too high
                if (this.getHeightDifference(node.getRightChild()) == 1) {
                    // and right child has a right child.
                    // rotate to the left to balance
                    return this.rotateLeft(node);
                }

                if (this.getHeightDifference(node.getRightChild()) == -1) {
                    // and right child has a left child.
                    // a double rotation is needed to balance
                    // rotate to the right then to the left
                    return this.rotateRightLeft(node);
                }
            }
        }

        return node;
    }

    /**
     * A helper function to perform a left rotation of a rooted tree.
     * 
     * https://appliedgo.net/balancedtree/
     */
    private BinaryTreeNode<T> rotateLeft(BinaryTreeNode<T> node) {

        if (node != null) {
            BinaryTreeNode<T> right = node.getRightChild();

            node.setRightChild(right.getLeftChild());

            right.setLeftChild(node);

            return right;
        }

        return node;
    }

    /**
     * A helper function to perform a right rotation of a rooted tree.
     * 
     * https://appliedgo.net/balancedtree/
     */
    private BinaryTreeNode<T> rotateRight(BinaryTreeNode<T> node) {
        if (node != null) {
            BinaryTreeNode<T> left = node.getLeftChild();

            node.setLeftChild(left.getRightChild());

            left.setRightChild(node);

            return left;
        }

        return node;
    }

    /**
     * A helper function to perform a double right-left rotation of a rooted tree.
     * 
     * https://appliedgo.net/balancedtree/
     */
    private BinaryTreeNode<T> rotateRightLeft(BinaryTreeNode<T> node) {
        if (node != null) {
            node.setRightChild(this.rotateRight(node.getRightChild()));

            node = this.rotateLeft(node);

            return node;
        }

        return node;
    }

    /**
     * A helper function to perform a double left-right rotation of a rooted tree.
     * 
     * https://appliedgo.net/balancedtree/
     */
    private BinaryTreeNode<T> rotateLeftRight(BinaryTreeNode<T> node) {
        if (node != null) {
            node.setLeftChild(this.rotateLeft(node.getLeftChild()));

            node = this.rotateRight(node);

            return node;
        }

        return node;
    }

    private int getHeightDifference(BinaryTreeNode<T> node) {
        if (node != null) {
            return this.getHeight(node.getRightChild()) - this.getHeight(node.getLeftChild());
        }

        return 0;
    }

    // Tests if the value of a < b
    private boolean greaterThan(T a, T b) {
        return a.compareTo(b) > 0;
    }

    // Tests if the value of a <= b
    private boolean greaterThanOrEqual(T a, T b) {
        return a.compareTo(b) >= 0;
    }

    // Tests if the value of a < b
    private boolean lessThan(T a, T b) {
        return a.compareTo(b) < 0;
    }

    // Tests if the value of a <= b
    private boolean lessThanOrEqual(T a, T b) {
        return a.compareTo(b) <= 0;
    }

}
