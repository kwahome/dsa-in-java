package com.example.tree.bst;

import java.util.HashMap;
import java.util.Map;

import com.example.tree.BinaryTreeTestHelper;
import com.example.tree.TraversalOrder;
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

    @Test
    public void shouldTraverseABinaryTree() {
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();

        binaryTree.insert(0);
        binaryTree.insert(1);
        binaryTree.insert(2);
        // binaryTree.insert(3);
        // binaryTree.insert(4);
        // binaryTree.insert(5);
        // binaryTree.insert(6);

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(7, binaryTree.size());
        Assert.assertEquals(2, binaryTree.height());
        Assert.assertEquals(2, binaryTree.degree());

        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertTrue(binaryTree.isFull());
        Assert.assertTrue(binaryTree.isPerfect());

        Map<TraversalOrder, Integer[]> testScenarios = new HashMap<>();

        testScenarios.put(TraversalOrder.LEVEL_ORDER, new Integer[] { 3, 1, 5, 0, 2, 4, 6 });
        testScenarios.put(TraversalOrder.REVERSE_LEVEL_ORDER, new Integer[] { 3, 5, 1, 6, 4, 3, 0 });
        testScenarios.put(TraversalOrder.IN_ORDER, new Integer[] { 0, 1, 2, 3, 4, 5, 6 });
        testScenarios.put(TraversalOrder.REVERSE_IN_ORDER, new Integer[] { 6, 5, 4, 3, 2, 1, 0 });
        // testScenarios.put(TraversalOrder.PRE_ORDER, new Integer[] { 0, 1, 2 });
        // testScenarios.put(TraversalOrder.REVERSE_PRE_ORDER, new Integer[] { 0, 2, 1
        // });
        // testScenarios.put(TraversalOrder.POST_ORDER, new Integer[] { 1, 2, 0 });
        // testScenarios.put(TraversalOrder.REVERSE_POST_ORDER, new Integer[] { 2, 1, 0
        // });

        BinaryTreeTestHelper.assertCorrectTraversal(binaryTree, testScenarios);
    }
}
