package com.example.tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
        Assert.assertEquals(-1, binaryTree.degree());

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
        BinaryTree<Integer> binaryTree = new BTree<>(rootNode);

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
        BinaryTree<Integer> binaryTree = new BTree<>(rootNode);

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

        for (Map.Entry<TraversalOrder, Integer[]> testScenario : testScenarios.entrySet()) {
            assertCorrectTraversal(binaryTree, testScenario.getKey(), testScenario.getValue());
        }
    }

    @Test
    public void shouldSearchABinaryTree() {
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(0, 1, 2);
        BinaryTree<Integer> binaryTree = new BTree<>(rootNode);

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
        BinaryTree<Integer> binaryTree = new BTree<>(rootNode);

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

        for (Map.Entry<TraversalOrder, Integer[]> testScenario : testScenarios.entrySet()) {
            assertCorrectTraversal(binaryTree, testScenario.getKey(), testScenario.getValue());
        }
    }

    @Test
    public void shouldRemoveFromABinaryTree() {
        BinaryTree<Integer> binaryTree = new BTree<>();
        Assert.assertNotNull(binaryTree);

        Assert.assertEquals(0, binaryTree.size());
        Assert.assertEquals(-1, binaryTree.height());
        Assert.assertEquals(-1, binaryTree.degree());

        Assert.assertTrue(binaryTree.isEmpty());

        Assert.assertNull(binaryTree.remove(0));

        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(0, 1, 2);
        binaryTree = new BTree<>(rootNode);

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

        Assert.assertNull(binaryTree.remove(0));

        Assert.assertEquals(2, binaryTree.size());
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
        Assert.assertFalse(binaryTree.contains(0));
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

        for (Map.Entry<TraversalOrder, Integer[]> testScenario : testScenarios.entrySet()) {
            assertCorrectTraversal(binaryTree, testScenario.getKey(), testScenario.getValue());
        }
    }

    private <T> void assertCorrectTraversal(BinaryTree<T> binaryTree, TraversalOrder traversalOrder, T[] expected) {
        Iterator<TreeNode<T>> nodesIterator = getTreeNodesIterator(binaryTree, traversalOrder);

        int i = 0;

        while (nodesIterator.hasNext()) {
            Assert.assertEquals(expected[i], nodesIterator.next().getData());

            i++;
        }
    }

    private <T> Iterator<TreeNode<T>> getTreeNodesIterator(BinaryTree<T> bTree, TraversalOrder traversalOrder) {
        switch (traversalOrder) {
            case LEVEL_ORDER:
                return bTree.getNodesLevelOrder().iterator();

            case IN_ORDER:
                return bTree.getNodesInOrder().iterator();

            case PRE_ORDER:
                return bTree.getNodesPreOrder().iterator();

            case POST_ORDER:
                return bTree.getNodesPostOrder().iterator();

            case REVERSE_LEVEL_ORDER:
                return bTree.getNodesReverseLevelOrder().iterator();

            case REVERSE_IN_ORDER:
                return bTree.getNodesReverseInOrder().iterator();

            case REVERSE_PRE_ORDER:
                return bTree.getNodesReversePreOrder().iterator();

            case REVERSE_POST_ORDER:
                return bTree.getNodesReversePostOrder().iterator();

            default:
                return null;
        }
    }
}
