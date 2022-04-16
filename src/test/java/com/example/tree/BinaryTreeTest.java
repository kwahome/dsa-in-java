package com.example.tree;

import org.junit.Test;

import java.util.Iterator;

import org.junit.Assert;

/**
 * Tests for a binary tree implementation.
 */
public class BinaryTreeTest {

    @Test
    public void shouldCreateABinaryTree_EmptyTree() {
        BinaryTree<Integer> binaryTree = new BTree<>();

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(0, binaryTree.size());
        Assert.assertEquals(-1, binaryTree.height());

        Assert.assertTrue(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertTrue(binaryTree.isFull());
        Assert.assertTrue(binaryTree.isPerfect());
        Assert.assertEquals(null, binaryTree.getRoot());
        Assert.assertEquals(null, binaryTree.getLeftChild(binaryTree.getRoot()));
        Assert.assertEquals(null, binaryTree.getRightChild(binaryTree.getRoot()));
        Assert.assertEquals(0, binaryTree.getDepth(binaryTree.getRoot()));
        Assert.assertFalse(binaryTree.contains(0));
    }

    @Test
    public void shouldCreateABinaryTree_NonEmptyTree() {
        BinaryTree<Integer> binaryTree = new BTree<>(0);

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(1, binaryTree.size());
        Assert.assertEquals(0, binaryTree.height());

        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertTrue(binaryTree.isFull());
        Assert.assertFalse(binaryTree.isPerfect());
        Assert.assertEquals(0, binaryTree.getRoot().getData().intValue());
        Assert.assertEquals(0, binaryTree.getRoot().getChildrenCount());
        Assert.assertEquals(null, binaryTree.getLeftChild(binaryTree.getRoot()));
        Assert.assertEquals(null, binaryTree.getRightChild(binaryTree.getRoot()));
        Assert.assertEquals(0, binaryTree.getDepth(binaryTree.getRoot()));
        Assert.assertTrue(binaryTree.contains(0));
        Assert.assertFalse(binaryTree.contains(1));
        Assert.assertNull(binaryTree.getRoot().getParent());
        Assert.assertNull(binaryTree.getRoot().getParent());
    }

    @Test
    public void shouldCreateABinaryTree_GivenPerfectRootNode() {
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(0, 1, 2);
        BinaryTree<Integer> binaryTree = new BTree<>(rootNode);

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(3, binaryTree.size());
        Assert.assertEquals(1, binaryTree.height());

        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertTrue(binaryTree.isFull());
        Assert.assertTrue(binaryTree.isPerfect());
        Assert.assertEquals(0, binaryTree.getRoot().getData().intValue());
        Assert.assertEquals(2, binaryTree.getRoot().getChildrenCount());
        Assert.assertEquals(1, binaryTree.getLeftChild(binaryTree.getRoot()).getData().intValue());
        Assert.assertEquals(2, binaryTree.getRightChild(binaryTree.getRoot()).getData().intValue());
        Assert.assertEquals(0, binaryTree.getDepth(binaryTree.getRoot()));
        Assert.assertEquals(1, binaryTree.getDepth(binaryTree.getLeftChild(binaryTree.getRoot())));
        Assert.assertEquals(1, binaryTree.getDepth(binaryTree.getRightChild(binaryTree.getRoot())));
        Assert.assertTrue(binaryTree.contains(0));
        Assert.assertTrue(binaryTree.contains(1));
        Assert.assertTrue(binaryTree.contains(2));
        Assert.assertFalse(binaryTree.contains(3));

        Assert.assertNull(binaryTree.getRoot().getParent());

        Assert.assertEquals(binaryTree.getRoot(),
                ((BinaryTreeNode<Integer>) binaryTree.getRoot()).getLeftChild().getParent());

        Assert.assertEquals(binaryTree.getRoot(),
                ((BinaryTreeNode<Integer>) binaryTree.getRoot()).getRightChild().getParent());
    }

    @Test
    public void shouldTraverseABinaryTree() {
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(0, 1, 2);
        BinaryTree<Integer> binaryTree = new BTree<>(rootNode);

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(3, binaryTree.size());
        Assert.assertEquals(1, binaryTree.height());

        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertTrue(binaryTree.isFull());
        Assert.assertTrue(binaryTree.isPerfect());
        Assert.assertEquals(0, binaryTree.getRoot().getData().intValue());
        Assert.assertEquals(2, binaryTree.getRoot().getChildrenCount());
        Assert.assertEquals(1, binaryTree.getLeftChild(binaryTree.getRoot()).getData().intValue());
        Assert.assertEquals(2, binaryTree.getRightChild(binaryTree.getRoot()).getData().intValue());
        Assert.assertEquals(0, binaryTree.getDepth(binaryTree.getRoot()));
        Assert.assertEquals(1, binaryTree.getDepth(binaryTree.getLeftChild(binaryTree.getRoot())));
        Assert.assertEquals(1, binaryTree.getDepth(binaryTree.getRightChild(binaryTree.getRoot())));
        Assert.assertTrue(binaryTree.contains(0));
        Assert.assertTrue(binaryTree.contains(1));
        Assert.assertTrue(binaryTree.contains(2));
        Assert.assertFalse(binaryTree.contains(3));

        // Assert traversal
        // 1. In-Order
        Integer[] expectedInOrder = { 1, 0, 2 };
        Iterator<TreeNode<Integer>> inOrderIterator = binaryTree.getNodesInOrder().iterator();
        int i = 0;
        while (inOrderIterator.hasNext()) {
            Assert.assertEquals(expectedInOrder[i], inOrderIterator.next().getData());

            i++;
        }

        Integer[] expectedReverseInOrder = { 2, 0, 1 };
        Iterator<TreeNode<Integer>> reverseInOrderIterator = binaryTree.getNodesReverseInOrder().iterator();
        i = 0;
        while (reverseInOrderIterator.hasNext()) {
            Assert.assertEquals(expectedReverseInOrder[i], reverseInOrderIterator.next().getData());

            i++;
        }

        // 2. Pre-Order
        Integer[] expectedPreOrder = { 0, 1, 2 };
        Iterator<TreeNode<Integer>> preOrderIterator = binaryTree.getNodesPreOrder().iterator();
        i = 0;
        while (preOrderIterator.hasNext()) {
            Assert.assertEquals(expectedPreOrder[i], preOrderIterator.next().getData());

            i++;
        }

        Integer[] expectedReversePreOrder = { 0, 2, 1 };
        Iterator<TreeNode<Integer>> reversePreOrderIterator = binaryTree.getNodesReversePreOrder().iterator();
        i = 0;
        while (reversePreOrderIterator.hasNext()) {
            Assert.assertEquals(expectedReversePreOrder[i], reversePreOrderIterator.next().getData());

            i++;
        }

        // 3. Post-order
        Integer[] expectedPostOrder = { 1, 2, 0 };
        Iterator<TreeNode<Integer>> postOrderIterator = binaryTree.getNodesPostOrder().iterator();
        i = 0;
        while (postOrderIterator.hasNext()) {
            Assert.assertEquals(expectedPostOrder[i], postOrderIterator.next().getData());

            i++;
        }

        Integer[] expectedReversePostOrder = { 2, 1, 0 };
        Iterator<TreeNode<Integer>> reversePostOrderIterator = binaryTree.getNodesReversePostOrder().iterator();
        i = 0;
        while (reversePostOrderIterator.hasNext()) {
            Assert.assertEquals(expectedReversePostOrder[i], reversePostOrderIterator.next().getData());

            i++;
        }

        // 4. Level-order
        Integer[] expectedLevelOrder = { 0, 1, 2 };
        Iterator<TreeNode<Integer>> levelOrderIterator = binaryTree.getNodesLevelOrder().iterator();
        i = 0;
        while (levelOrderIterator.hasNext()) {
            Assert.assertEquals(expectedLevelOrder[i], levelOrderIterator.next().getData());

            i++;
        }

        Integer[] expectedReverseLevelOrder = { 0, 2, 1 };
        Iterator<TreeNode<Integer>> reverseLevelOrderIterator = binaryTree.getNodesReverseLevelOrder().iterator();
        i = 0;
        while (reverseLevelOrderIterator.hasNext()) {
            Assert.assertEquals(expectedReverseLevelOrder[i], reverseLevelOrderIterator.next().getData());

            i++;
        }
    }
}
