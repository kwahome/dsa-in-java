package com.example.tree;

import java.util.Iterator;
import java.util.Map;

import com.example.tree.binarytree.BinaryTree;

import org.junit.Assert;

/**
 * Test helpers.
 */
public class BinaryTreeTestHelper {

    public static <T> void assertCorrectTraversal(BinaryTree<T> binaryTree, Map<TraversalOrder, T[]> testScenarios) {

        for (Map.Entry<TraversalOrder, T[]> testScenario : testScenarios.entrySet()) {
            TraversalOrder traversalOrder = testScenario.getKey();
            T[] expected = testScenario.getValue();

            System.out.println(traversalOrder);

            assertCorrectTraversal(binaryTree, traversalOrder, expected);
        }

    }

    public static <T> void assertCorrectTraversal(
            BinaryTree<T> binaryTree,
            TraversalOrder traversalOrder,
            T[] expected) {
        Iterator<TreeNode<T>> nodesIterator = getTreeNodesIterator(binaryTree, traversalOrder);

        int i = 0;

        while (nodesIterator.hasNext()) {
            Assert.assertEquals(expected[i], nodesIterator.next().getData());

            i++;
        }
    }

    public static <T> Iterator<TreeNode<T>> getTreeNodesIterator(
            BinaryTree<T> binaryTree,
            TraversalOrder traversalOrder) {
        switch (traversalOrder) {
            case LEVEL_ORDER:
                return binaryTree.getNodesLevelOrder().iterator();

            case IN_ORDER:
                return binaryTree.getNodesInOrder().iterator();

            case PRE_ORDER:
                return binaryTree.getNodesPreOrder().iterator();

            case POST_ORDER:
                return binaryTree.getNodesPostOrder().iterator();

            case REVERSE_LEVEL_ORDER:
                return binaryTree.getNodesReverseLevelOrder().iterator();

            case REVERSE_IN_ORDER:
                return binaryTree.getNodesReverseInOrder().iterator();

            case REVERSE_PRE_ORDER:
                return binaryTree.getNodesReversePreOrder().iterator();

            case REVERSE_POST_ORDER:
                return binaryTree.getNodesReversePostOrder().iterator();

            default:
                return null;
        }
    }

}
