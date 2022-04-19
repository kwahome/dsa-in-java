package com.example.tree.binarytree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import com.example.tree.BinaryTreeTestHelper;
import com.example.tree.TraversalOrder;
import com.example.tree.TreeNode;

import org.junit.Assert;

/**
 * Tests for a binary tree implementation.
 */
public class BinaryTreeTest {

    @Test
    public void shouldCreateABinaryTree_EmptyTree() {
        BinaryTree<Integer> binaryTree = new LinkedBinaryTree<>();

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(0, binaryTree.size());
        Assert.assertEquals(-1, binaryTree.height());
        Assert.assertEquals(-1, binaryTree.degree());

        Assert.assertTrue(binaryTree.isEmpty());
        Assert.assertFalse(binaryTree.isBalanced());
        Assert.assertFalse(binaryTree.isComplete());
        Assert.assertFalse(binaryTree.isFull());
        Assert.assertFalse(binaryTree.isPerfect());
        Assert.assertEquals(null, binaryTree.getRoot());
        Assert.assertEquals(null, binaryTree.getLeftChild(binaryTree.getRoot()));
        Assert.assertEquals(null, binaryTree.getRightChild(binaryTree.getRoot()));
        Assert.assertEquals(0, binaryTree.getDepth(binaryTree.getRoot()));
        Assert.assertFalse(binaryTree.contains(0));
    }

    @Test
    public void shouldCreateABinaryTree_NonEmptyTree() {
        BinaryTree<Integer> binaryTree = new LinkedBinaryTree<>(0);

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(1, binaryTree.size());
        Assert.assertEquals(0, binaryTree.height());
        Assert.assertEquals(0, binaryTree.degree());

        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertTrue(binaryTree.isFull());
        Assert.assertTrue(binaryTree.isPerfect());
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
        BinaryTree<Integer> binaryTree = new LinkedBinaryTree<>(rootNode);

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(3, binaryTree.size());
        Assert.assertEquals(1, binaryTree.height());
        Assert.assertEquals(2, binaryTree.degree());

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
        BinaryTree<Integer> binaryTree = new LinkedBinaryTree<>(rootNode);

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(3, binaryTree.size());
        Assert.assertEquals(1, binaryTree.height());
        Assert.assertEquals(2, binaryTree.degree());

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

        Map<TraversalOrder, Integer[]> testScenarios = new HashMap<>();

        testScenarios.put(TraversalOrder.LEVEL_ORDER, new Integer[] { 0, 1, 2 });
        testScenarios.put(TraversalOrder.REVERSE_LEVEL_ORDER, new Integer[] { 0, 2, 1 });
        testScenarios.put(TraversalOrder.IN_ORDER, new Integer[] { 1, 0, 2 });
        testScenarios.put(TraversalOrder.REVERSE_IN_ORDER, new Integer[] { 2, 0, 1 });
        testScenarios.put(TraversalOrder.PRE_ORDER, new Integer[] { 0, 1, 2 });
        testScenarios.put(TraversalOrder.REVERSE_PRE_ORDER, new Integer[] { 0, 2, 1 });
        testScenarios.put(TraversalOrder.POST_ORDER, new Integer[] { 1, 2, 0 });
        testScenarios.put(TraversalOrder.REVERSE_POST_ORDER, new Integer[] { 2, 1, 0 });

        BinaryTreeTestHelper.assertCorrectTraversal(binaryTree, testScenarios);
    }

    @Test
    public void shouldSearchABinaryTree() {
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(0, 1, 2);
        BinaryTree<Integer> binaryTree = new LinkedBinaryTree<>(rootNode);

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(3, binaryTree.size());
        Assert.assertEquals(1, binaryTree.height());
        Assert.assertEquals(2, binaryTree.degree());

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

        TraversalOrder[] traversalStrategies = {
                TraversalOrder.IN_ORDER,
                TraversalOrder.LEVEL_ORDER,
                TraversalOrder.PRE_ORDER,
                TraversalOrder.POST_ORDER,
                TraversalOrder.REVERSE_IN_ORDER,
                TraversalOrder.REVERSE_LEVEL_ORDER,
                TraversalOrder.REVERSE_PRE_ORDER,
                TraversalOrder.REVERSE_POST_ORDER,
        };

        Integer[] itemsToSearch = { 0, 1, 2, 3, 4, -1, 2, 0, 1 };

        Integer[] expectedResults = { 0, 1, 2, null, null, null, 2, 0, 1 };

        for (TraversalOrder strategy : traversalStrategies) {
            System.out.println(strategy);
            for (int index = 0; index < itemsToSearch.length; index++) {
                Integer searchKey = itemsToSearch[index];

                System.out.println(searchKey);

                TreeNode<Integer> result = binaryTree.search(searchKey, strategy);

                if (result == null) {
                    Assert.assertEquals(expectedResults[index], result);
                } else {
                    Assert.assertEquals(expectedResults[index], result.getData());
                }
            }
        }
    }

    @Test
    public void shouldInsertIntoABinaryTree() {
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(0, 1, 2);
        BinaryTree<Integer> binaryTree = new LinkedBinaryTree<>(rootNode);

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(3, binaryTree.size());
        Assert.assertEquals(1, binaryTree.height());
        Assert.assertEquals(2, binaryTree.degree());

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

        Assert.assertTrue(binaryTree.insert(3));

        Assert.assertEquals(4, binaryTree.size());
        Assert.assertEquals(2, binaryTree.height());
        Assert.assertEquals(2, binaryTree.degree());
        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertFalse(binaryTree.isFull());
        Assert.assertFalse(binaryTree.isPerfect());
        Assert.assertTrue(binaryTree.contains(3));

        Assert.assertTrue(binaryTree.insert(4));

        Assert.assertEquals(5, binaryTree.size());
        Assert.assertEquals(2, binaryTree.height());
        Assert.assertEquals(2, binaryTree.degree());
        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertTrue(binaryTree.isFull());
        Assert.assertFalse(binaryTree.isPerfect());
        Assert.assertTrue(binaryTree.contains(4));

        Assert.assertTrue(binaryTree.insert(5));

        Assert.assertEquals(6, binaryTree.size());
        Assert.assertEquals(2, binaryTree.height());
        Assert.assertEquals(2, binaryTree.degree());
        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertFalse(binaryTree.isFull());
        Assert.assertFalse(binaryTree.isPerfect());
        Assert.assertTrue(binaryTree.contains(5));

        Assert.assertTrue(binaryTree.insert(6));

        Assert.assertEquals(7, binaryTree.size());
        Assert.assertEquals(2, binaryTree.height());
        Assert.assertEquals(2, binaryTree.degree());
        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertTrue(binaryTree.isFull());
        Assert.assertTrue(binaryTree.isPerfect());
        Assert.assertTrue(binaryTree.contains(6));

        Map<TraversalOrder, Integer[]> testScenarios = new HashMap<>();

        testScenarios.put(TraversalOrder.LEVEL_ORDER, new Integer[] { 0, 1, 2, 3, 4, 5, 6 });
        testScenarios.put(TraversalOrder.REVERSE_LEVEL_ORDER, new Integer[] { 0, 2, 1, 6, 5, 4, 3 });
        testScenarios.put(TraversalOrder.IN_ORDER, new Integer[] { 3, 1, 4, 0, 5, 2, 6 });
        testScenarios.put(TraversalOrder.REVERSE_IN_ORDER, new Integer[] { 6, 2, 5, 0, 4, 1, 3 });
        testScenarios.put(TraversalOrder.PRE_ORDER, new Integer[] { 0, 1, 3, 4, 2, 5, 6 });
        testScenarios.put(TraversalOrder.REVERSE_PRE_ORDER, new Integer[] { 0, 2, 6, 5, 1, 4, 3 });
        testScenarios.put(TraversalOrder.POST_ORDER, new Integer[] { 3, 4, 1, 5, 6, 2, 0 });
        testScenarios.put(TraversalOrder.REVERSE_POST_ORDER, new Integer[] { 6, 5, 2, 4, 3, 1, 0 });

        BinaryTreeTestHelper.assertCorrectTraversal(binaryTree, testScenarios);
    }

    @Test
    public void shouldRemoveFromABinaryTree() {
        BinaryTree<Integer> binaryTree = new LinkedBinaryTree<>();
        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(0, binaryTree.size());
        Assert.assertEquals(-1, binaryTree.height());
        Assert.assertEquals(-1, binaryTree.degree());
        Assert.assertEquals(-1, binaryTree.getMaxDepth());

        Assert.assertTrue(binaryTree.isEmpty());

        Assert.assertNull(binaryTree.remove(0));

        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(0, 1, 2);

        binaryTree = new LinkedBinaryTree<>(rootNode);

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(3, binaryTree.size());
        Assert.assertEquals(1, binaryTree.height());
        Assert.assertEquals(2, binaryTree.degree());
        Assert.assertEquals(1, binaryTree.getMaxDepth());

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

        Assert.assertEquals(0, binaryTree.remove(0).intValue());

        Assert.assertEquals(2, binaryTree.size());
        Assert.assertEquals(1, binaryTree.height());
        Assert.assertEquals(1, binaryTree.degree());
        Assert.assertEquals(1, binaryTree.getMaxDepth());

        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertFalse(binaryTree.isFull());
        Assert.assertFalse(binaryTree.isPerfect());
        Assert.assertEquals(2, binaryTree.getRoot().getData().intValue());
        Assert.assertEquals(1, binaryTree.getRoot().getChildrenCount());
        Assert.assertEquals(1, binaryTree.getLeftChild(binaryTree.getRoot()).getData().intValue());
        Assert.assertEquals(null, binaryTree.getRightChild(binaryTree.getRoot()));
        Assert.assertEquals(0, binaryTree.getDepth(binaryTree.getRoot()));
        Assert.assertEquals(1, binaryTree.getDepth(binaryTree.getLeftChild(binaryTree.getRoot())));
        Assert.assertEquals(0, binaryTree.getDepth(binaryTree.getRightChild(binaryTree.getRoot())));
        Assert.assertFalse(binaryTree.contains(0));
        Assert.assertTrue(binaryTree.contains(1));
        Assert.assertTrue(binaryTree.contains(2));
        Assert.assertFalse(binaryTree.contains(3));

        Map<TraversalOrder, Integer[]> testScenarios = new HashMap<>();

        testScenarios.put(TraversalOrder.LEVEL_ORDER, new Integer[] { 2, 1 });
        testScenarios.put(TraversalOrder.REVERSE_LEVEL_ORDER, new Integer[] { 2, 1 });
        testScenarios.put(TraversalOrder.IN_ORDER, new Integer[] { 1, 2 });
        testScenarios.put(TraversalOrder.REVERSE_IN_ORDER, new Integer[] { 2, 1 });
        testScenarios.put(TraversalOrder.PRE_ORDER, new Integer[] { 2, 1 });
        testScenarios.put(TraversalOrder.REVERSE_PRE_ORDER, new Integer[] { 2, 1 });
        testScenarios.put(TraversalOrder.POST_ORDER, new Integer[] { 1, 2 });
        testScenarios.put(TraversalOrder.REVERSE_POST_ORDER, new Integer[] { 1, 2 });

        BinaryTreeTestHelper.assertCorrectTraversal(binaryTree, testScenarios);

        Assert.assertTrue(binaryTree.insert(3));

        Assert.assertEquals(3, binaryTree.size());
        Assert.assertEquals(1, binaryTree.height());
        Assert.assertEquals(2, binaryTree.degree());
        Assert.assertEquals(1, binaryTree.getMaxDepth());
        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertTrue(binaryTree.isFull());
        Assert.assertTrue(binaryTree.isPerfect());
        Assert.assertTrue(binaryTree.contains(3));

        testScenarios = new HashMap<>();

        testScenarios.put(TraversalOrder.LEVEL_ORDER, new Integer[] { 2, 1, 3 });
        testScenarios.put(TraversalOrder.REVERSE_LEVEL_ORDER, new Integer[] { 2, 3, 1 });
        testScenarios.put(TraversalOrder.IN_ORDER, new Integer[] { 1, 2, 3 });
        testScenarios.put(TraversalOrder.REVERSE_IN_ORDER, new Integer[] { 3, 2, 1 });
        testScenarios.put(TraversalOrder.PRE_ORDER, new Integer[] { 2, 1, 3 });
        testScenarios.put(TraversalOrder.REVERSE_PRE_ORDER, new Integer[] { 2, 3, 1 });
        testScenarios.put(TraversalOrder.POST_ORDER, new Integer[] { 1, 3, 2 });
        testScenarios.put(TraversalOrder.REVERSE_POST_ORDER, new Integer[] { 3, 1, 2 });

        BinaryTreeTestHelper.assertCorrectTraversal(binaryTree, testScenarios);

        Assert.assertTrue(binaryTree.insert(4));

        Assert.assertEquals(4, binaryTree.size());
        Assert.assertEquals(2, binaryTree.height());
        Assert.assertEquals(2, binaryTree.degree());
        Assert.assertEquals(2, binaryTree.getMaxDepth());
        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertFalse(binaryTree.isFull());
        Assert.assertFalse(binaryTree.isPerfect());
        Assert.assertTrue(binaryTree.contains(4));

        testScenarios = new HashMap<>();

        testScenarios.put(TraversalOrder.LEVEL_ORDER, new Integer[] { 2, 1, 3, 4 });
        testScenarios.put(TraversalOrder.REVERSE_LEVEL_ORDER, new Integer[] { 2, 3, 1, 4 });
        testScenarios.put(TraversalOrder.IN_ORDER, new Integer[] { 4, 1, 2, 3 });
        testScenarios.put(TraversalOrder.REVERSE_IN_ORDER, new Integer[] { 3, 2, 1, 4 });
        testScenarios.put(TraversalOrder.PRE_ORDER, new Integer[] { 2, 1, 4, 3 });
        testScenarios.put(TraversalOrder.REVERSE_PRE_ORDER, new Integer[] { 2, 3, 1, 4 });
        testScenarios.put(TraversalOrder.POST_ORDER, new Integer[] { 4, 1, 3, 2 });
        testScenarios.put(TraversalOrder.REVERSE_POST_ORDER, new Integer[] { 3, 4, 1, 2 });

        BinaryTreeTestHelper.assertCorrectTraversal(binaryTree, testScenarios);

        Assert.assertEquals(1, binaryTree.remove(1).intValue());

        Assert.assertEquals(3, binaryTree.size());
        Assert.assertEquals(1, binaryTree.height());
        Assert.assertEquals(2, binaryTree.degree());
        Assert.assertEquals(1, binaryTree.getMaxDepth());
        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertTrue(binaryTree.isFull());
        Assert.assertTrue(binaryTree.isPerfect());
        Assert.assertFalse(binaryTree.contains(1));
        Assert.assertTrue(binaryTree.contains(4));

        testScenarios = new HashMap<>();

        testScenarios.put(TraversalOrder.LEVEL_ORDER, new Integer[] { 2, 4, 3 });
        testScenarios.put(TraversalOrder.REVERSE_LEVEL_ORDER, new Integer[] { 2, 3, 4 });
        testScenarios.put(TraversalOrder.IN_ORDER, new Integer[] { 4, 2, 3 });
        testScenarios.put(TraversalOrder.REVERSE_IN_ORDER, new Integer[] { 3, 2, 4 });
        testScenarios.put(TraversalOrder.PRE_ORDER, new Integer[] { 2, 4, 3 });
        testScenarios.put(TraversalOrder.REVERSE_PRE_ORDER, new Integer[] { 2, 3, 4 });
        testScenarios.put(TraversalOrder.POST_ORDER, new Integer[] { 4, 3, 2 });
        testScenarios.put(TraversalOrder.REVERSE_POST_ORDER, new Integer[] { 3, 4, 2 });

        BinaryTreeTestHelper.assertCorrectTraversal(binaryTree, testScenarios);

        Assert.assertEquals(3, binaryTree.remove(3).intValue());

        Assert.assertEquals(2, binaryTree.size());
        Assert.assertEquals(1, binaryTree.height());
        Assert.assertEquals(1, binaryTree.degree());
        Assert.assertEquals(1, binaryTree.getMaxDepth());
        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertFalse(binaryTree.isFull());
        Assert.assertFalse(binaryTree.isPerfect());
        Assert.assertFalse(binaryTree.contains(3));
        Assert.assertTrue(binaryTree.contains(4));

        testScenarios = new HashMap<>();

        testScenarios.put(TraversalOrder.LEVEL_ORDER, new Integer[] { 2, 4 });
        testScenarios.put(TraversalOrder.REVERSE_LEVEL_ORDER, new Integer[] { 2, 4 });
        testScenarios.put(TraversalOrder.IN_ORDER, new Integer[] { 4, 2 });
        testScenarios.put(TraversalOrder.REVERSE_IN_ORDER, new Integer[] { 2, 4 });
        testScenarios.put(TraversalOrder.PRE_ORDER, new Integer[] { 2, 4 });
        testScenarios.put(TraversalOrder.REVERSE_PRE_ORDER, new Integer[] { 2, 4 });
        testScenarios.put(TraversalOrder.POST_ORDER, new Integer[] { 4, 2 });
        testScenarios.put(TraversalOrder.REVERSE_POST_ORDER, new Integer[] { 4, 2 });

        BinaryTreeTestHelper.assertCorrectTraversal(binaryTree, testScenarios);

        Assert.assertEquals(4, binaryTree.remove(4).intValue());

        Assert.assertEquals(1, binaryTree.size());
        Assert.assertEquals(0, binaryTree.height());
        Assert.assertEquals(0, binaryTree.degree());
        Assert.assertEquals(0, binaryTree.getMaxDepth());
        Assert.assertFalse(binaryTree.isEmpty());
        Assert.assertTrue(binaryTree.isBalanced());
        Assert.assertTrue(binaryTree.isComplete());
        Assert.assertTrue(binaryTree.isFull());
        Assert.assertTrue(binaryTree.isPerfect());
        Assert.assertFalse(binaryTree.contains(3));
        Assert.assertFalse(binaryTree.contains(4));

        testScenarios = new HashMap<>();

        testScenarios.put(TraversalOrder.LEVEL_ORDER, new Integer[] { 2 });
        testScenarios.put(TraversalOrder.REVERSE_LEVEL_ORDER, new Integer[] { 2 });
        testScenarios.put(TraversalOrder.IN_ORDER, new Integer[] { 2 });
        testScenarios.put(TraversalOrder.REVERSE_IN_ORDER, new Integer[] { 2 });
        testScenarios.put(TraversalOrder.PRE_ORDER, new Integer[] { 2 });
        testScenarios.put(TraversalOrder.REVERSE_PRE_ORDER, new Integer[] { 2 });
        testScenarios.put(TraversalOrder.POST_ORDER, new Integer[] { 2 });
        testScenarios.put(TraversalOrder.REVERSE_POST_ORDER, new Integer[] { 2 });

        BinaryTreeTestHelper.assertCorrectTraversal(binaryTree, testScenarios);

        Assert.assertEquals(2, binaryTree.remove(2).intValue());

        Assert.assertEquals(0, binaryTree.size());
        Assert.assertEquals(-1, binaryTree.height());
        Assert.assertEquals(-1, binaryTree.degree());
        Assert.assertEquals(-1, binaryTree.getMaxDepth());
        Assert.assertTrue(binaryTree.isEmpty());
        Assert.assertFalse(binaryTree.isBalanced());
        Assert.assertFalse(binaryTree.isComplete());
        Assert.assertFalse(binaryTree.isFull());
        Assert.assertFalse(binaryTree.isPerfect());
        Assert.assertFalse(binaryTree.contains(2));

        testScenarios = new HashMap<>();

        testScenarios.put(TraversalOrder.LEVEL_ORDER, new Integer[] {});
        testScenarios.put(TraversalOrder.REVERSE_LEVEL_ORDER, new Integer[] {});
        testScenarios.put(TraversalOrder.IN_ORDER, new Integer[] {});
        testScenarios.put(TraversalOrder.REVERSE_IN_ORDER, new Integer[] {});
        testScenarios.put(TraversalOrder.PRE_ORDER, new Integer[] {});
        testScenarios.put(TraversalOrder.REVERSE_PRE_ORDER, new Integer[] {});
        testScenarios.put(TraversalOrder.POST_ORDER, new Integer[] {});
        testScenarios.put(TraversalOrder.REVERSE_POST_ORDER, new Integer[] {});

        BinaryTreeTestHelper.assertCorrectTraversal(binaryTree, testScenarios);
    }

    @Test
    public void shouldClearABinaryTree() {
        BinaryTree<Integer> binaryTree = new LinkedBinaryTree<>();

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(0, binaryTree.size());
        Assert.assertEquals(-1, binaryTree.height());
        Assert.assertEquals(-1, binaryTree.degree());

        Assert.assertTrue(binaryTree.isEmpty());
        Assert.assertFalse(binaryTree.isBalanced());
        Assert.assertFalse(binaryTree.isComplete());
        Assert.assertFalse(binaryTree.isFull());
        Assert.assertFalse(binaryTree.isPerfect());
        Assert.assertEquals(null, binaryTree.getRoot());
        Assert.assertEquals(null, binaryTree.getLeftChild(binaryTree.getRoot()));
        Assert.assertEquals(null, binaryTree.getRightChild(binaryTree.getRoot()));
        Assert.assertEquals(0, binaryTree.getDepth(binaryTree.getRoot()));
        Assert.assertFalse(binaryTree.contains(0));

        binaryTree.clear();

        Assert.assertEquals(0, binaryTree.size());
        Assert.assertEquals(-1, binaryTree.height());
        Assert.assertEquals(-1, binaryTree.degree());

        Assert.assertTrue(binaryTree.isEmpty());
        Assert.assertFalse(binaryTree.isBalanced());
        Assert.assertFalse(binaryTree.isComplete());
        Assert.assertFalse(binaryTree.isFull());
        Assert.assertFalse(binaryTree.isPerfect());
        Assert.assertEquals(null, binaryTree.getRoot());
        Assert.assertEquals(null, binaryTree.getLeftChild(binaryTree.getRoot()));
        Assert.assertEquals(null, binaryTree.getRightChild(binaryTree.getRoot()));
        Assert.assertEquals(0, binaryTree.getDepth(binaryTree.getRoot()));
        Assert.assertFalse(binaryTree.contains(0));

        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(0, 1, 2);
        binaryTree = new LinkedBinaryTree<>(rootNode);

        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(3, binaryTree.size());
        Assert.assertEquals(1, binaryTree.height());
        Assert.assertEquals(2, binaryTree.degree());

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

        binaryTree.clear();

        Assert.assertEquals(0, binaryTree.size());
        Assert.assertEquals(-1, binaryTree.height());
        Assert.assertEquals(-1, binaryTree.degree());

        Assert.assertTrue(binaryTree.isEmpty());
        Assert.assertFalse(binaryTree.isBalanced());
        Assert.assertFalse(binaryTree.isComplete());
        Assert.assertFalse(binaryTree.isFull());
        Assert.assertFalse(binaryTree.isPerfect());
        Assert.assertEquals(null, binaryTree.getRoot());
        Assert.assertEquals(null, binaryTree.getLeftChild(binaryTree.getRoot()));
        Assert.assertEquals(null, binaryTree.getRightChild(binaryTree.getRoot()));
        Assert.assertEquals(0, binaryTree.getDepth(binaryTree.getRoot()));
        Assert.assertFalse(binaryTree.contains(0));
    }
}
