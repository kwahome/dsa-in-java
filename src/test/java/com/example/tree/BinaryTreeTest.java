package com.example.tree;

import org.junit.Test;

import org.junit.Assert;

/**
 * Tests for a binary tree implementation.
 */
public class BinaryTreeTest {

    @Test
    public void shouldCreateABinaryTree() {
        BinaryTree<Integer> binaryTree = new BTree<>();

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(0, binaryTree.size());
        Assert.assertEquals(0, binaryTree.height());

        Assert.assertTrue(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertTrue(binaryTree.isFull());
        Assert.assertFalse(binaryTree.isPerfect());
        Assert.assertEquals(null, binaryTree.getRoot());
        Assert.assertEquals(0, binaryTree.getChildrenCount(binaryTree.getRoot()));
        Assert.assertEquals(null, binaryTree.getLeftChild(binaryTree.getRoot()));
        Assert.assertEquals(null, binaryTree.getRightChild(binaryTree.getRoot()));
        Assert.assertFalse(binaryTree.contains(0));

    }
}
