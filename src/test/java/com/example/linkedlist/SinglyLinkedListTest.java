package com.example.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for binary min heap.
 */
public class SinglyLinkedListTest {

    @Test
    public void shouldConstructSinglyLinkedList() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();

        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertEquals(0, linkedList.size());

        Integer itemsToAdd[] = { 5, 1, 7, 3, 2, 0, 5, 6, 8, 4 };

        linkedList = new SinglyLinkedList<>(itemsToAdd);

        Assert.assertEquals(itemsToAdd.length, linkedList.size());

        Assert.assertEquals(itemsToAdd[0], linkedList.getHead().getNodeData());
        Assert.assertEquals(itemsToAdd[0], linkedList.getFirst());

        Assert.assertEquals(itemsToAdd[itemsToAdd.length - 1], linkedList.getTail().getNodeData());
        Assert.assertEquals(itemsToAdd[itemsToAdd.length - 1], linkedList.getLast());

        // assert the pointers are correct
        LinkedListNode<Integer> current = linkedList.getHead();

        int index = 0;

        do {
            System.out.println(index);

            Assert.assertEquals(itemsToAdd[index], current.getNodeData());

            current = current.getNextNode();

            index++;

        } while (current.getNextNode() != null);

        linkedList = new SinglyLinkedList<>(Arrays.asList(itemsToAdd));

        Assert.assertEquals(itemsToAdd.length, linkedList.size());

        Assert.assertEquals(itemsToAdd[0], linkedList.getHead().getNodeData());
        Assert.assertEquals(itemsToAdd[0], linkedList.getFirst());

        Assert.assertEquals(itemsToAdd[itemsToAdd.length - 1], linkedList.getTail().getNodeData());
        Assert.assertEquals(itemsToAdd[itemsToAdd.length - 1], linkedList.getLast());

        Assert.assertEquals(itemsToAdd[0], linkedList.peek());
        Assert.assertEquals(itemsToAdd[0], linkedList.peekFirst());
        Assert.assertEquals(itemsToAdd[itemsToAdd.length - 1], linkedList.peekLast());

        // assert the pointers are correct
        current = linkedList.getHead();

        index = 0;

        do {
            System.out.println(index);

            Assert.assertEquals(itemsToAdd[index], current.getNodeData());

            current = current.getNextNode();

            index++;

        } while (current.getNextNode() != null);
    }

    @Test
    public void shouldAddItem() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();

        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertEquals(0, linkedList.size());

        // add one item
        linkedList.add(1);

        Assert.assertEquals(1, linkedList.size());

        Assert.assertEquals(1, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(1, linkedList.getFirst().intValue());

        Assert.assertEquals(1, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(1, linkedList.getLast().intValue());

        Assert.assertEquals(1, linkedList.peek().intValue());
        Assert.assertEquals(1, linkedList.peekFirst().intValue());
        Assert.assertEquals(1, linkedList.peekLast().intValue());

        linkedList.add(9);

        Assert.assertEquals(2, linkedList.size());

        Assert.assertEquals(1, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(1, linkedList.getFirst().intValue());

        Assert.assertEquals(9, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(9, linkedList.getLast().intValue());

        Assert.assertEquals(1, linkedList.peek().intValue());
        Assert.assertEquals(1, linkedList.peekFirst().intValue());
        Assert.assertEquals(9, linkedList.peekLast().intValue());
    }

    @Test
    public void shouldAddAllItems() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();

        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertEquals(0, linkedList.size());

        Integer itemsToAdd[] = { 5, 1, 7, 3, 2, 0, 5, 6, 8, 4 };

        linkedList.addAll(itemsToAdd);

        Assert.assertEquals(itemsToAdd.length, linkedList.size());

        Assert.assertEquals(itemsToAdd[0], linkedList.getHead().getNodeData());
        Assert.assertEquals(itemsToAdd[0], linkedList.getFirst());

        Assert.assertEquals(itemsToAdd[itemsToAdd.length - 1], linkedList.getTail().getNodeData());
        Assert.assertEquals(itemsToAdd[itemsToAdd.length - 1], linkedList.getLast());

        Assert.assertEquals(itemsToAdd[0], linkedList.peek());
        Assert.assertEquals(itemsToAdd[0], linkedList.peekFirst());
        Assert.assertEquals(itemsToAdd[itemsToAdd.length - 1], linkedList.peekLast());

        // assert the pointers are correct
        LinkedListNode<Integer> current = linkedList.getHead();

        int index = 0;

        do {
            System.out.println(index);

            Assert.assertEquals(itemsToAdd[index], current.getNodeData());

            current = current.getNextNode();

            index++;

        } while (current.getNextNode() != null);

        Integer[] moreItems = { 10, 11, 12, 13, 14, 15 };

        linkedList.addAll(Arrays.asList(moreItems));

        Assert.assertEquals(itemsToAdd.length + moreItems.length, linkedList.size());

        Assert.assertEquals(itemsToAdd[0], linkedList.getHead().getNodeData());
        Assert.assertEquals(itemsToAdd[0], linkedList.getFirst());

        Assert.assertEquals(moreItems[moreItems.length - 1], linkedList.getTail().getNodeData());
        Assert.assertEquals(moreItems[moreItems.length - 1], linkedList.getLast());

        // assert the pointers are correct
        List<Integer> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(itemsToAdd));
        expected.addAll(Arrays.asList(moreItems));

        current = linkedList.getHead();

        index = 0;

        do {
            System.out.println(index);

            Assert.assertEquals(expected.get(index), current.getNodeData());

            current = current.getNextNode();

            index++;

        } while (current.getNextNode() != null);
    }

    @Test
    public void shouldAddItemAtGivenPostion() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();

        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertEquals(0, linkedList.size());

        linkedList.add(2);

        Assert.assertEquals(1, linkedList.size());

        Assert.assertEquals(2, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(2, linkedList.getFirst().intValue());

        Assert.assertEquals(2, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(2, linkedList.getLast().intValue());

        Assert.assertEquals(2, linkedList.peek().intValue());
        Assert.assertEquals(2, linkedList.peekFirst().intValue());
        Assert.assertEquals(2, linkedList.peekLast().intValue());

        // add to the first position
        linkedList.add(0, 0);

        Assert.assertEquals(2, linkedList.size());

        Assert.assertEquals(0, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(0, linkedList.getFirst().intValue());

        Assert.assertEquals(2, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(2, linkedList.getLast().intValue());

        Assert.assertEquals(0, linkedList.peek().intValue());
        Assert.assertEquals(0, linkedList.peekFirst().intValue());
        Assert.assertEquals(2, linkedList.peekLast().intValue());

        // add a middle position
        linkedList.add(1, 1);

        Assert.assertEquals(3, linkedList.size());

        Assert.assertEquals(0, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(0, linkedList.getFirst().intValue());

        Assert.assertEquals(2, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(2, linkedList.getLast().intValue());

        Assert.assertEquals(0, linkedList.peek().intValue());
        Assert.assertEquals(0, linkedList.peekFirst().intValue());
        Assert.assertEquals(2, linkedList.peekLast().intValue());

        // add to the last position
        linkedList.add(linkedList.size(), 3);

        Assert.assertEquals(4, linkedList.size());

        Assert.assertEquals(0, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(0, linkedList.getFirst().intValue());

        Assert.assertEquals(3, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(3, linkedList.getLast().intValue());

        Assert.assertEquals(0, linkedList.peek().intValue());
        Assert.assertEquals(0, linkedList.peekFirst().intValue());
        Assert.assertEquals(3, linkedList.peekLast().intValue());

        // assert the pointers are correct
        Integer[] expected = { 0, 1, 2, 3 };

        LinkedListNode<Integer> current = linkedList.getHead();

        int index = 0;

        do {
            System.out.println(index);

            Assert.assertEquals(expected[index], current.getNodeData());

            current = current.getNextNode();

            index++;

        } while (current.getNextNode() != null);
    }

    @Test
    public void shouldAddItemsStartingFromGivenPostion() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();

        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertEquals(0, linkedList.size());

        linkedList.add(2);

        Assert.assertEquals(1, linkedList.size());

        Assert.assertEquals(2, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(2, linkedList.getFirst().intValue());

        Assert.assertEquals(2, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(2, linkedList.getLast().intValue());

        Assert.assertEquals(2, linkedList.peek().intValue());
        Assert.assertEquals(2, linkedList.peekFirst().intValue());
        Assert.assertEquals(2, linkedList.peekLast().intValue());

        // add to the first position
        linkedList.addAll(0, new Integer[] { -1, 0, 1 });

        Assert.assertEquals(4, linkedList.size());

        Assert.assertEquals(-1, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(-1, linkedList.getFirst().intValue());

        Assert.assertEquals(2, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(2, linkedList.getLast().intValue());

        Assert.assertEquals(-1, linkedList.peek().intValue());
        Assert.assertEquals(-1, linkedList.peekFirst().intValue());
        Assert.assertEquals(2, linkedList.peekLast().intValue());

        // add a middle position
        linkedList.addAll(1, Arrays.asList(new Integer[] { 1 }));
        linkedList.addAll(4, Arrays.asList(new Integer[] { 2, 3 }));

        Assert.assertEquals(7, linkedList.size());

        Assert.assertEquals(-1, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(-1, linkedList.getFirst().intValue());

        Assert.assertEquals(2, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(2, linkedList.getLast().intValue());

        Assert.assertEquals(-1, linkedList.peek().intValue());
        Assert.assertEquals(-1, linkedList.peekFirst().intValue());
        Assert.assertEquals(2, linkedList.peekLast().intValue());

        // add to the last position
        linkedList.addAll(linkedList.size(), Arrays.asList(new Integer[] { 4, 5, 6 }));

        Assert.assertEquals(10, linkedList.size());

        Assert.assertEquals(-1, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(-1, linkedList.getFirst().intValue());

        Assert.assertEquals(6, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(6, linkedList.getLast().intValue());

        Assert.assertEquals(-1, linkedList.peek().intValue());
        Assert.assertEquals(-1, linkedList.peekFirst().intValue());
        Assert.assertEquals(6, linkedList.peekLast().intValue());

        // assert the pointers are correct
        Integer[] expected = { -1, 1, 0, 1, 2, 3, 2, 4, 5, 6 };

        LinkedListNode<Integer> current = linkedList.getHead();

        int index = 0;

        do {
            System.out.println(current.getNodeData());

            Assert.assertEquals(expected[index], current.getNodeData());

            current = current.getNextNode();

            index++;

        } while (current.getNextNode() != null);
    }

    @Test
    public void shouldAppendItemsToTheList() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();

        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertEquals(0, linkedList.size());

        linkedList.addLast(0);

        Assert.assertEquals(1, linkedList.size());

        Assert.assertEquals(0, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(0, linkedList.getFirst().intValue());

        Assert.assertEquals(0, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(0, linkedList.getLast().intValue());

        Assert.assertEquals(0, linkedList.peek().intValue());
        Assert.assertEquals(0, linkedList.peekFirst().intValue());
        Assert.assertEquals(0, linkedList.peekLast().intValue());

        linkedList.addLast(new Integer[] { 1, 2, 3 });

        Assert.assertEquals(4, linkedList.size());

        Assert.assertEquals(0, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(0, linkedList.getFirst().intValue());

        Assert.assertEquals(3, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(3, linkedList.getLast().intValue());

        Assert.assertEquals(0, linkedList.peek().intValue());
        Assert.assertEquals(0, linkedList.peekFirst().intValue());
        Assert.assertEquals(3, linkedList.peekLast().intValue());

        linkedList.addAll(linkedList.size(), Arrays.asList(new Integer[] { 4, 5, 6 }));

        Assert.assertEquals(7, linkedList.size());

        Assert.assertEquals(0, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(0, linkedList.getFirst().intValue());

        Assert.assertEquals(6, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(6, linkedList.getLast().intValue());

        Assert.assertEquals(0, linkedList.peek().intValue());
        Assert.assertEquals(0, linkedList.peekFirst().intValue());
        Assert.assertEquals(6, linkedList.peekLast().intValue());

        // assert the pointers are correct
        Integer[] expected = { 0, 1, 2, 3, 4, 5, 6 };

        LinkedListNode<Integer> current = linkedList.getHead();

        int index = 0;

        do {
            System.out.println(current.getNodeData());

            Assert.assertEquals(expected[index], current.getNodeData());

            current = current.getNextNode();

            index++;

        } while (current.getNextNode() != null);
    }

    @Test
    public void shouldInsertAfterAGivenItem() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();

        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertEquals(0, linkedList.size());

        linkedList.add(0);

        Assert.assertEquals(1, linkedList.size());

        Assert.assertEquals(0, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(0, linkedList.getFirst().intValue());

        Assert.assertEquals(0, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(0, linkedList.getLast().intValue());

        Assert.assertEquals(0, linkedList.peek().intValue());
        Assert.assertEquals(0, linkedList.peekFirst().intValue());
        Assert.assertEquals(0, linkedList.peekLast().intValue());

        linkedList.insertAfter(0, 1);

        Assert.assertEquals(2, linkedList.size());

        Assert.assertEquals(0, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(0, linkedList.getFirst().intValue());

        Assert.assertEquals(1, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(1, linkedList.getLast().intValue());

        Assert.assertEquals(0, linkedList.peek().intValue());
        Assert.assertEquals(0, linkedList.peekFirst().intValue());
        Assert.assertEquals(1, linkedList.peekLast().intValue());

        linkedList.insertAfter(1, 3);

        Assert.assertEquals(3, linkedList.size());

        Assert.assertEquals(0, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(0, linkedList.getFirst().intValue());

        Assert.assertEquals(3, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(3, linkedList.getLast().intValue());

        Assert.assertEquals(0, linkedList.peek().intValue());
        Assert.assertEquals(0, linkedList.peekFirst().intValue());
        Assert.assertEquals(3, linkedList.peekLast().intValue());

        linkedList.insertAfter(1, 2);

        // assert the pointers are correct
        Integer[] expected = { 0, 1, 2, 3 };

        LinkedListNode<Integer> current = linkedList.getHead();

        int index = 0;

        do {
            System.out.println(current.getNodeData());

            Assert.assertEquals(expected[index], current.getNodeData());

            current = current.getNextNode();

            index++;

        } while (current.getNextNode() != null);
    }

    @Test
    public void shouldInsertBeforeAGivenItem() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();

        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertEquals(0, linkedList.size());

        linkedList.add(3);

        Assert.assertEquals(1, linkedList.size());

        Assert.assertEquals(3, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(3, linkedList.getFirst().intValue());

        Assert.assertEquals(3, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(3, linkedList.getLast().intValue());

        Assert.assertEquals(3, linkedList.peek().intValue());
        Assert.assertEquals(3, linkedList.peekFirst().intValue());
        Assert.assertEquals(3, linkedList.peekLast().intValue());

        linkedList.insertBefore(3, 1);

        Assert.assertEquals(2, linkedList.size());

        Assert.assertEquals(1, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(1, linkedList.getFirst().intValue());

        Assert.assertEquals(3, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(3, linkedList.getLast().intValue());

        Assert.assertEquals(1, linkedList.peek().intValue());
        Assert.assertEquals(1, linkedList.peekFirst().intValue());
        Assert.assertEquals(3, linkedList.peekLast().intValue());

        linkedList.insertBefore(3, 2);

        Assert.assertEquals(3, linkedList.size());

        Assert.assertEquals(1, linkedList.getHead().getNodeData().intValue());
        Assert.assertEquals(1, linkedList.getFirst().intValue());

        Assert.assertEquals(3, linkedList.getTail().getNodeData().intValue());
        Assert.assertEquals(3, linkedList.getLast().intValue());

        Assert.assertEquals(1, linkedList.peek().intValue());
        Assert.assertEquals(1, linkedList.peekFirst().intValue());
        Assert.assertEquals(3, linkedList.peekLast().intValue());

        linkedList.insertBefore(1, 0);

        // assert the pointers are correct
        Integer[] expected = { 0, 1, 2, 3 };

        LinkedListNode<Integer> current = linkedList.getHead();

        int index = 0;

        do {
            System.out.println(current.getNodeData());

            Assert.assertEquals(expected[index], current.getNodeData());

            current = current.getNextNode();

            index++;

        } while (current.getNextNode() != null);
    }

    @Test
    public void shouldCheckIfTheListContainsAnItem() {
        LinkedList<String> linkedList = new SinglyLinkedList<>();

        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertEquals(0, linkedList.size());

        String testString = "this is a test string";

        Assert.assertFalse(linkedList.contains(testString));

        linkedList.add(testString);

        Assert.assertEquals(1, linkedList.size());

        Assert.assertEquals(testString, linkedList.getHead().getNodeData());
        Assert.assertEquals(testString, linkedList.getFirst());

        Assert.assertEquals(testString, linkedList.getTail().getNodeData());
        Assert.assertEquals(testString, linkedList.getLast());

        Assert.assertEquals(testString, linkedList.peek());
        Assert.assertEquals(testString, linkedList.peekFirst());
        Assert.assertEquals(testString, linkedList.peekLast());

        Assert.assertTrue(linkedList.contains(testString));

        linkedList.addAll(new String[] { "Hello World!", "Uhali gani?", "", "a", "to be or not to be" });

        String[] expected = new String[] { testString, "Hello World!", "Uhali gani?", "", "a", "to be or not to be" };

        for (String item : expected) {
            Assert.assertTrue(linkedList.contains(item));
        }
    }

    @Test
    public void shouldGetAnItemFromTheList() {
        LinkedList<String> linkedList = new SinglyLinkedList<>();

        Assert.assertEquals(0, linkedList.size());
        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertNull(linkedList.getFirst());
        Assert.assertNull(linkedList.getLast());

        String testString = "this is a test string";

        linkedList.add(testString);

        Assert.assertEquals(1, linkedList.size());

        Assert.assertEquals(testString, linkedList.getHead().getNodeData());
        Assert.assertEquals(testString, linkedList.getFirst());

        Assert.assertEquals(testString, linkedList.getTail().getNodeData());
        Assert.assertEquals(testString, linkedList.getLast());

        Assert.assertEquals(testString, linkedList.peek());
        Assert.assertEquals(testString, linkedList.peekFirst());
        Assert.assertEquals(testString, linkedList.peekLast());

        Assert.assertEquals(testString, linkedList.get(0));

        linkedList.addAll(new String[] { "Hello World!", "Uhali gani?", "", "a", "to be or not to be" });

        String[] expected = new String[] { testString, "Hello World!", "Uhali gani?", "", "a", "to be or not to be" };

        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], linkedList.get(i));
        }
    }

    @Test
    public void shouldGetTheIndexOfAnItemInTheList() {
        LinkedList<String> linkedList = new SinglyLinkedList<>();

        Assert.assertEquals(0, linkedList.size());
        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertNull(linkedList.getFirst());
        Assert.assertNull(linkedList.getLast());

        String testString = "this is a test string";

        Assert.assertEquals(-1, linkedList.indexOf(testString));

        linkedList.add(testString);

        Assert.assertEquals(0, linkedList.indexOf(testString));

        Assert.assertEquals(1, linkedList.size());

        Assert.assertEquals(testString, linkedList.getHead().getNodeData());
        Assert.assertEquals(testString, linkedList.getFirst());

        Assert.assertEquals(testString, linkedList.getTail().getNodeData());
        Assert.assertEquals(testString, linkedList.getLast());

        Assert.assertEquals(testString, linkedList.peek());
        Assert.assertEquals(testString, linkedList.peekFirst());
        Assert.assertEquals(testString, linkedList.peekLast());

        Assert.assertEquals(testString, linkedList.get(0));

        linkedList.addAll(new String[] { "Hello World!", "Uhali gani?", "", "a", "to be or not to be" });

        String[] expected = new String[] { testString, "Hello World!", "Uhali gani?", "", "a", "to be or not to be" };

        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(i, linkedList.indexOf(expected[i]));
            Assert.assertEquals(expected[i], linkedList.get(i));
        }
    }

    @Test
    public void shouldGetTheLastIndexOfAnItemInTheList() {
        LinkedList<String> linkedList = new SinglyLinkedList<>();

        Assert.assertEquals(0, linkedList.size());
        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertNull(linkedList.getFirst());
        Assert.assertNull(linkedList.getLast());

        String testString = "this is a test string";

        Assert.assertEquals(-1, linkedList.indexOf(testString));

        String[] items = new String[] {
                testString,
                "Hello World!",
                "Uhali gani?",
                testString,
                "to be or not to be",
                testString };

        linkedList.addAll(items);

        Assert.assertEquals(0, linkedList.indexOf(testString));

        Assert.assertEquals(items.length, linkedList.size());

        Assert.assertEquals(testString, linkedList.getHead().getNodeData());
        Assert.assertEquals(testString, linkedList.getFirst());

        Assert.assertEquals(testString, linkedList.getTail().getNodeData());
        Assert.assertEquals(testString, linkedList.getLast());

        Assert.assertEquals(testString, linkedList.peek());
        Assert.assertEquals(testString, linkedList.peekFirst());
        Assert.assertEquals(testString, linkedList.peekLast());

        Assert.assertEquals(testString, linkedList.get(0));

        Assert.assertEquals(items.length - 1, linkedList.lastIndexOf(testString));
    }

    @Test
    public void shouldPollTheFirstItemInTheList() {
        LinkedList<String> linkedList = new SinglyLinkedList<>();

        Assert.assertEquals(0, linkedList.size());
        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertNull(linkedList.getFirst());
        Assert.assertNull(linkedList.getLast());

        Assert.assertEquals(null, linkedList.poll());

        String testString = "this is a test string";

        String[] items = new String[] {
                testString,
                "Hello World!",
                "Uhali gani?",
                testString,
                "to be or not to be",
                testString };

        linkedList.addAll(items);

        Assert.assertEquals(items.length, linkedList.size());

        Assert.assertEquals(testString, linkedList.getHead().getNodeData());
        Assert.assertEquals(testString, linkedList.getFirst());

        Assert.assertEquals(testString, linkedList.getTail().getNodeData());
        Assert.assertEquals(testString, linkedList.getLast());

        Assert.assertEquals(testString, linkedList.peek());
        Assert.assertEquals(testString, linkedList.peekFirst());
        Assert.assertEquals(testString, linkedList.peekLast());

        int index = 0;

        do {
            String polledItem = linkedList.poll();

            System.out.println(polledItem);

            Assert.assertEquals(items[index], polledItem);

            Assert.assertEquals(items.length - (index + 1), linkedList.size());

            if (!linkedList.isEmpty()) {
                // assert the head and tail are correct
                Assert.assertEquals(items[index + 1], linkedList.getHead().getNodeData());
                Assert.assertEquals(items[index + 1], linkedList.getFirst());

                Assert.assertEquals(items[items.length - 1], linkedList.getTail().getNodeData());
                Assert.assertEquals(items[items.length - 1], linkedList.getLast());

                Assert.assertEquals(items[index + 1], linkedList.peek());
                Assert.assertEquals(items[index + 1], linkedList.peekFirst());
                Assert.assertEquals(items[items.length - 1], linkedList.peekLast());
            }

            index++;

        } while (!linkedList.isEmpty());
    }

    @Test
    public void shouldPollTheLastItemInTheList() {
        LinkedList<String> linkedList = new SinglyLinkedList<>();

        Assert.assertEquals(0, linkedList.size());
        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertNull(linkedList.getFirst());
        Assert.assertNull(linkedList.getLast());

        Assert.assertEquals(null, linkedList.poll());

        String testString = "this is a test string";

        String[] items = new String[] {
                testString,
                "Hello World!",
                "Uhali gani?",
                testString,
                "to be or not to be",
                "furaha" };

        linkedList.addAll(items);

        Assert.assertEquals(items.length, linkedList.size());

        Assert.assertEquals(testString, linkedList.getHead().getNodeData());
        Assert.assertEquals(testString, linkedList.getFirst());

        Assert.assertEquals("furaha", linkedList.getTail().getNodeData());
        Assert.assertEquals("furaha", linkedList.getLast());

        Assert.assertEquals(testString, linkedList.peek());
        Assert.assertEquals(testString, linkedList.peekFirst());
        Assert.assertEquals("furaha", linkedList.peekLast());

        int index = items.length - 1;

        do {
            String polledItem = linkedList.pollLast();

            System.out.println(polledItem);

            Assert.assertEquals(items[index], polledItem);

            Assert.assertEquals(index, linkedList.size());

            if (!linkedList.isEmpty()) {
                // assert the head and tail are correct
                Assert.assertEquals(items[0], linkedList.getHead().getNodeData());
                Assert.assertEquals(items[0], linkedList.getFirst());

                Assert.assertEquals(items[index - 1], linkedList.getTail().getNodeData());
                Assert.assertEquals(items[index - 1], linkedList.getLast());

                Assert.assertEquals(items[0], linkedList.peek());
                Assert.assertEquals(items[0], linkedList.peekFirst());
                Assert.assertEquals(items[index - 1], linkedList.peekLast());
            }

            index--;

        } while (!linkedList.isEmpty());
    }

    @Test
    public void shouldRemoveAnItemFromTheList() {
        LinkedList<String> linkedList = new SinglyLinkedList<>();

        Assert.assertEquals(0, linkedList.size());
        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertNull(linkedList.getFirst());
        Assert.assertNull(linkedList.getLast());

        Assert.assertEquals(null, linkedList.remove());

        String testString = "this is a test string";

        String[] items = new String[] {
                testString,
                "Hello World!",
                "Uhali gani?",
                testString,
                "to be or not to be",
                "furaha" };

        linkedList.addAll(items);

        Assert.assertEquals(items.length, linkedList.size());

        Assert.assertEquals(testString, linkedList.getHead().getNodeData());
        Assert.assertEquals(testString, linkedList.getFirst());

        Assert.assertEquals(items[items.length - 1], linkedList.getTail().getNodeData());
        Assert.assertEquals(items[items.length - 1], linkedList.getLast());

        Assert.assertEquals(testString, linkedList.peek());
        Assert.assertEquals(testString, linkedList.peekFirst());
        Assert.assertEquals(items[items.length - 1], linkedList.peekLast());

        linkedList.remove();

        Assert.assertEquals(items.length - 1, linkedList.size());

        Assert.assertEquals(items[1], linkedList.getHead().getNodeData());
        Assert.assertEquals(items[1], linkedList.getFirst());

        Assert.assertEquals(items[items.length - 1], linkedList.getTail().getNodeData());
        Assert.assertEquals(items[items.length - 1], linkedList.getLast());

        Assert.assertEquals(items[1], linkedList.peek());
        Assert.assertEquals(items[1], linkedList.peekFirst());
        Assert.assertEquals(items[items.length - 1], linkedList.peekLast());

        Assert.assertEquals(true, linkedList.remove(testString));

        Assert.assertEquals(items.length - 2, linkedList.size());

        Assert.assertEquals(items[1], linkedList.getHead().getNodeData());
        Assert.assertEquals(items[1], linkedList.getFirst());

        Assert.assertEquals(items[items.length - 1], linkedList.getTail().getNodeData());
        Assert.assertEquals(items[items.length - 1], linkedList.getLast());

        Assert.assertEquals(items[1], linkedList.peek());
        Assert.assertEquals(items[1], linkedList.peekFirst());
        Assert.assertEquals(items[items.length - 1], linkedList.peekLast());

        Assert.assertEquals(true, linkedList.remove("furaha"));

        Assert.assertEquals(items.length - 3, linkedList.size());

        Assert.assertEquals(items[1], linkedList.getHead().getNodeData());
        Assert.assertEquals(items[1], linkedList.getFirst());

        Assert.assertEquals(items[items.length - 2], linkedList.getTail().getNodeData());
        Assert.assertEquals(items[items.length - 2], linkedList.getLast());

        Assert.assertEquals(items[1], linkedList.peek());
        Assert.assertEquals(items[1], linkedList.peekFirst());
        Assert.assertEquals(items[items.length - 2], linkedList.peekLast());
    }

    @Test
    public void shouldReturnIterators() {
        LinkedList<String> linkedList = new SinglyLinkedList<>();

        Assert.assertEquals(0, linkedList.size());
        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertNull(linkedList.getFirst());
        Assert.assertNull(linkedList.getLast());

        Assert.assertEquals(null, linkedList.remove());

        String testString = "this is a test string";

        String[] items = new String[] {
                testString,
                "Hello World!",
                "Uhali gani?",
                testString,
                "to be or not to be",
                "furaha" };

        linkedList.addAll(items);

        Assert.assertEquals(items.length, linkedList.size());

        Assert.assertEquals(testString, linkedList.getHead().getNodeData());
        Assert.assertEquals(testString, linkedList.getFirst());

        Assert.assertEquals(items[items.length - 1], linkedList.getTail().getNodeData());
        Assert.assertEquals(items[items.length - 1], linkedList.getLast());

        Assert.assertEquals(testString, linkedList.peek());
        Assert.assertEquals(testString, linkedList.peekFirst());
        Assert.assertEquals(items[items.length - 1], linkedList.peekLast());

        Iterator<String> iterator = linkedList.iterator();

        int index = 0;

        while (iterator.hasNext()) {
            Assert.assertEquals(items[index], iterator.next());

            index++;
        }

        iterator = linkedList.descendingIterator();

        index = items.length - 1;

        while (iterator.hasNext()) {
            Assert.assertEquals(items[index], iterator.next());

            index--;
        }

        index = 0;

        ListIterator<String> listIterator = linkedList.listIterator(index);

        while (listIterator.hasNext()) {
            Assert.assertEquals(items[index], listIterator.next());

            index++;
        }

        index = 2;

        listIterator = linkedList.listIterator(index);

        while (listIterator.hasNext()) {
            Assert.assertEquals(items[index], listIterator.next());

            index++;
        }

    }
}
