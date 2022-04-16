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

        // Assert traversal
        // 1. In-Order
        Integer[] expectedInOrder = { 3, 1, 4, 0, 5, 2, 6 };
        Iterator<TreeNode<Integer>> inOrderIterator = binaryTree.getNodesInOrder().iterator();
        int i = 0;
        while (inOrderIterator.hasNext()) {
            Assert.assertEquals(expectedInOrder[i], inOrderIterator.next().getData());

            i++;
        }

        Integer[] expectedReverseInOrder = { 6, 2, 5, 0, 4, 1, 3 };
        Iterator<TreeNode<Integer>> reverseInOrderIterator = binaryTree.getNodesReverseInOrder().iterator();
        i = 0;
        while (reverseInOrderIterator.hasNext()) {
            Assert.assertEquals(expectedReverseInOrder[i], reverseInOrderIterator.next().getData());

            i++;
        }

        // 2. Pre-Order
        Integer[] expectedPreOrder = { 0, 1, 3, 4, 2, 5, 6 };
        Iterator<TreeNode<Integer>> preOrderIterator = binaryTree.getNodesPreOrder().iterator();
        i = 0;
        while (preOrderIterator.hasNext()) {
            Assert.assertEquals(expectedPreOrder[i], preOrderIterator.next().getData());

            i++;
        }

        Integer[] expectedReversePreOrder = { 0, 2, 6, 5, 1, 4, 3 };
        Iterator<TreeNode<Integer>> reversePreOrderIterator = binaryTree.getNodesReversePreOrder().iterator();
        i = 0;
        while (reversePreOrderIterator.hasNext()) {
            Assert.assertEquals(expectedReversePreOrder[i], reversePreOrderIterator.next().getData());

            i++;
        }

        // 3. Post-order
        Integer[] expectedPostOrder = { 3, 4, 1, 5, 6, 2, 0 };
        Iterator<TreeNode<Integer>> postOrderIterator = binaryTree.getNodesPostOrder().iterator();
        i = 0;
        while (postOrderIterator.hasNext()) {
            Assert.assertEquals(expectedPostOrder[i], postOrderIterator.next().getData());

            i++;
        }

        Integer[] expectedReversePostOrder = { 6, 5, 2, 4, 3, 1, 0 };
        Iterator<TreeNode<Integer>> reversePostOrderIterator = binaryTree.getNodesReversePostOrder().iterator();
        i = 0;
        while (reversePostOrderIterator.hasNext()) {
            Assert.assertEquals(expectedReversePostOrder[i], reversePostOrderIterator.next().getData());

            i++;
        }

        // 4. Level-order
        Integer[] expectedLevelOrder = { 0, 1, 2, 3, 4, 5, 6 };
        Iterator<TreeNode<Integer>> levelOrderIterator = binaryTree.getNodesLevelOrder().iterator();
        i = 0;
        while (levelOrderIterator.hasNext()) {
            Assert.assertEquals(expectedLevelOrder[i], levelOrderIterator.next().getData());

            i++;
        }

        Integer[] expectedReverseLevelOrder = { 0, 2, 1, 6, 5, 4, 3 };
        Iterator<TreeNode<Integer>> reverseLevelOrderIterator = binaryTree.getNodesReverseLevelOrder().iterator();
        i = 0;
        while (reverseLevelOrderIterator.hasNext()) {
            Assert.assertEquals(expectedReverseLevelOrder[i], reverseLevelOrderIterator.next().getData());

            i++;
        }
    }
}
