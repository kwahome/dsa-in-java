package com.example.tree.bst;

import com.example.tree.binarytree.BinaryTreeNode;

import org.junit.Assert;
import org.junit.Test;

/**
 * A binary search tree implementation
 */
public class BinarySearchTreeTest {

    @Test
    public void shouldCreateABinaryTree_EmptyTree() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        Assert.assertNotNull(binarySearchTree);

        Assert.assertEquals(0, binarySearchTree.size());
        Assert.assertEquals(-1, binarySearchTree.height());
        Assert.assertEquals(-1, binarySearchTree.degree());

        Assert.assertTrue(binarySearchTree.isEmpty());
        Assert.assertFalse(binarySearchTree.isBalanced());
        Assert.assertFalse(binarySearchTree.isComplete());
        Assert.assertFalse(binarySearchTree.isFull());
        Assert.assertFalse(binarySearchTree.isPerfect());
        Assert.assertEquals(null, binarySearchTree.getRoot());
        Assert.assertEquals(null, binarySearchTree.getLeftChild(binarySearchTree.getRoot()));
        Assert.assertEquals(null, binarySearchTree.getRightChild(binarySearchTree.getRoot()));
        Assert.assertEquals(0, binarySearchTree.getDepth(binarySearchTree.getRoot()));
        Assert.assertFalse(binarySearchTree.contains(0));
    }

    @Test
    public void shouldCreateABinaryTree_NonEmptyTree() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(0);

        Assert.assertNotNull(binarySearchTree);

        Assert.assertEquals(1, binarySearchTree.size());
        Assert.assertEquals(0, binarySearchTree.height());
        Assert.assertEquals(0, binarySearchTree.degree());

        Assert.assertFalse(binarySearchTree.isEmpty());
        Assert.assertTrue(binarySearchTree.isBalanced());
        Assert.assertTrue(binarySearchTree.isComplete());
        Assert.assertTrue(binarySearchTree.isFull());
        Assert.assertTrue(binarySearchTree.isPerfect());
        Assert.assertEquals(0, binarySearchTree.getRoot().getData().intValue());
        Assert.assertEquals(0, binarySearchTree.getRoot().getChildrenCount());
        Assert.assertEquals(null, binarySearchTree.getLeftChild(binarySearchTree.getRoot()));
        Assert.assertEquals(null, binarySearchTree.getRightChild(binarySearchTree.getRoot()));
        Assert.assertEquals(0, binarySearchTree.getDepth(binarySearchTree.getRoot()));
        Assert.assertTrue(binarySearchTree.contains(0));
        Assert.assertFalse(binarySearchTree.contains(1));
        Assert.assertNull(binarySearchTree.getRoot().getParent());
        Assert.assertNull(binarySearchTree.getRoot().getParent());
    }

    @Test
    public void shouldCreateABinaryTree_GivenPerfectRootNode() {
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(0, 1, 2);
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(rootNode);

        Assert.assertNotNull(binarySearchTree);

        Assert.assertEquals(3, binarySearchTree.size());
        Assert.assertEquals(1, binarySearchTree.height());
        Assert.assertEquals(2, binarySearchTree.degree());

        Assert.assertFalse(binarySearchTree.isEmpty());
        Assert.assertTrue(binarySearchTree.isBalanced());
        Assert.assertTrue(binarySearchTree.isComplete());
        Assert.assertTrue(binarySearchTree.isFull());
        Assert.assertTrue(binarySearchTree.isPerfect());
        Assert.assertEquals(0, binarySearchTree.getRoot().getData().intValue());
        Assert.assertEquals(2, binarySearchTree.getRoot().getChildrenCount());
        Assert.assertEquals(1, binarySearchTree.getLeftChild(binarySearchTree.getRoot()).getData().intValue());
        Assert.assertEquals(2, binarySearchTree.getRightChild(binarySearchTree.getRoot()).getData().intValue());
        Assert.assertEquals(0, binarySearchTree.getDepth(binarySearchTree.getRoot()));
        Assert.assertEquals(1, binarySearchTree.getDepth(binarySearchTree.getLeftChild(binarySearchTree.getRoot())));
        Assert.assertEquals(1, binarySearchTree.getDepth(binarySearchTree.getRightChild(binarySearchTree.getRoot())));
        Assert.assertTrue(binarySearchTree.contains(0));
        Assert.assertTrue(binarySearchTree.contains(1));
        Assert.assertTrue(binarySearchTree.contains(2));
        Assert.assertFalse(binarySearchTree.contains(3));

        Assert.assertNull(binarySearchTree.getRoot().getParent());

        Assert.assertEquals(binarySearchTree.getRoot(),
                ((BinaryTreeNode<Integer>) binarySearchTree.getRoot()).getLeftChild().getParent());

        Assert.assertEquals(binarySearchTree.getRoot(),
                ((BinaryTreeNode<Integer>) binarySearchTree.getRoot()).getRightChild().getParent());
    }
}
