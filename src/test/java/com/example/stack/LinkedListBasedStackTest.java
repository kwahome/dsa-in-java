package com.example.stack;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the linked list stack implementation.
 */
public class LinkedListBasedStackTest {

    @Test
    public void shouldCreateAStack() {
        Stack<Integer> stack = new LinkedListBasedStack<>();

        Assert.assertEquals(1, stack.getCapacity());
        Assert.assertEquals(0, stack.size());
        Assert.assertTrue(stack.hasCapacity(1));
        Assert.assertFalse(stack.isFull());
        Assert.assertTrue(stack.isEmpty());
        Assert.assertEquals(null, stack.peek());

        stack = new LinkedListBasedStack<>(10);

        Assert.assertEquals(10, stack.getCapacity());
        Assert.assertEquals(0, stack.size());
        Assert.assertTrue(stack.hasCapacity(1));
        Assert.assertFalse(stack.isFull());
        Assert.assertTrue(stack.isEmpty());
        Assert.assertEquals(null, stack.peek());

        Integer[] itemsToPush = { 0, 1, 2, 3, 4, 5 };

        stack = new LinkedListBasedStack<>(itemsToPush);

        Assert.assertEquals(itemsToPush.length, stack.getCapacity());
        Assert.assertEquals(itemsToPush.length, stack.size());
        Assert.assertFalse(stack.hasCapacity(1));
        Assert.assertTrue(stack.isFull());
        Assert.assertFalse(stack.isEmpty());

        Assert.assertEquals(itemsToPush[itemsToPush.length - 1], stack.peek());

        stack = new LinkedListBasedStack<>(Arrays.asList(itemsToPush));

        Assert.assertEquals(itemsToPush.length, stack.getCapacity());
        Assert.assertEquals(itemsToPush.length, stack.size());
        Assert.assertFalse(stack.hasCapacity(1));
        Assert.assertTrue(stack.isFull());
        Assert.assertFalse(stack.isEmpty());

        Assert.assertEquals(itemsToPush[itemsToPush.length - 1], stack.peek());
    }

    @Test
    public void shouldPushAnItemToTheStackIfNotFull() {
        Stack<Integer> stack = new LinkedListBasedStack<>();

        Assert.assertEquals(1, stack.getCapacity());
        Assert.assertEquals(0, stack.size());
        Assert.assertTrue(stack.hasCapacity(1));
        Assert.assertFalse(stack.isFull());
        Assert.assertTrue(stack.isEmpty());
        Assert.assertEquals(null, stack.peek());

        Assert.assertTrue(stack.push(0));

        Assert.assertEquals(1, stack.getCapacity());
        Assert.assertEquals(1, stack.size());
        Assert.assertFalse(stack.hasCapacity(1));
        Assert.assertTrue(stack.isFull());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(0, stack.peek().intValue());

        Integer[] itemsToPush = { 1, 2, 3, 4, 5 };

        Assert.assertTrue(stack.expandCapacity(itemsToPush.length));
        Assert.assertTrue(stack.hasCapacity(itemsToPush.length));

        stack.pushAll(itemsToPush);

        Assert.assertEquals(itemsToPush.length + 1, stack.getCapacity());
        Assert.assertEquals(itemsToPush.length + 1, stack.size());
        Assert.assertFalse(stack.hasCapacity(1));
        Assert.assertTrue(stack.isFull());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(itemsToPush[itemsToPush.length - 1], stack.peek());

        List<Integer> collectionToPush = Arrays.asList(new Integer[] { 6, 7, 8, 9 });

        Assert.assertTrue(stack.expandCapacity(collectionToPush.size()));
        Assert.assertTrue(stack.hasCapacity(collectionToPush.size()));

        stack.pushAll(collectionToPush);

        Assert.assertEquals(collectionToPush.size() + itemsToPush.length + 1, stack.getCapacity());
        Assert.assertEquals(collectionToPush.size() + itemsToPush.length + 1, stack.size());
        Assert.assertFalse(stack.hasCapacity(1));
        Assert.assertTrue(stack.isFull());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(collectionToPush.get(collectionToPush.size() - 1), stack.peek());
    }

    @Test
    public void shouldPopAnItemFromTheStackIfNotEmpty() {
        Stack<Integer> stack = new LinkedListBasedStack<>();

        Assert.assertEquals(1, stack.getCapacity());
        Assert.assertEquals(0, stack.size());
        Assert.assertTrue(stack.hasCapacity(1));
        Assert.assertFalse(stack.isFull());
        Assert.assertTrue(stack.isEmpty());
        Assert.assertEquals(null, stack.peek());

        Assert.assertEquals(null, stack.pop());

        Assert.assertEquals(1, stack.getCapacity());
        Assert.assertEquals(0, stack.size());
        Assert.assertTrue(stack.hasCapacity(1));
        Assert.assertFalse(stack.isFull());
        Assert.assertTrue(stack.isEmpty());
        Assert.assertEquals(null, stack.peek());

        stack = new LinkedListBasedStack<>(5);

        Assert.assertTrue(stack.push(0));
        Assert.assertTrue(stack.push(1));

        Assert.assertEquals(5, stack.getCapacity());
        Assert.assertEquals(2, stack.size());
        Assert.assertTrue(stack.hasCapacity(3));
        Assert.assertFalse(stack.isFull());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(1, stack.peek().intValue());

        Assert.assertEquals(1, stack.pop().intValue());

        Assert.assertEquals(5, stack.getCapacity());
        Assert.assertEquals(1, stack.size());
        Assert.assertTrue(stack.hasCapacity(4));
        Assert.assertFalse(stack.isFull());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(0, stack.peek().intValue());

        Assert.assertTrue(stack.push(1));
        Assert.assertTrue(stack.push(2));
        Assert.assertTrue(stack.push(3));

        Assert.assertEquals(3, stack.pop().intValue());
        Assert.assertEquals(2, stack.pop().intValue());
        Assert.assertEquals(1, stack.pop().intValue());
        Assert.assertEquals(0, stack.pop().intValue());

        Integer[] itemsToPush = { 1, 2, 3, 4, 5 };

        stack = new LinkedListBasedStack<>(itemsToPush);

        Assert.assertEquals(itemsToPush.length, stack.getCapacity());
        Assert.assertEquals(itemsToPush.length, stack.size());
        Assert.assertFalse(stack.hasCapacity(itemsToPush.length));
        Assert.assertTrue(stack.isFull());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(itemsToPush[itemsToPush.length - 1], stack.peek());

        for (int i = itemsToPush.length - 1; i > 0; i--) {
            // Assert that the last item pushed is the first item popped
            Assert.assertEquals(itemsToPush[i], stack.pop());
        }
    }

    @Test
    public void shouldClearItemsFromTheStack() {
        Integer[] itemsToPush = { 1, 2, 3, 4, 5 };

        Stack<Integer> stack = new LinkedListBasedStack<>(itemsToPush);

        Assert.assertEquals(itemsToPush.length, stack.getCapacity());
        Assert.assertEquals(itemsToPush.length, stack.size());
        Assert.assertFalse(stack.hasCapacity(itemsToPush.length));
        Assert.assertTrue(stack.isFull());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(itemsToPush[itemsToPush.length - 1], stack.peek());

        stack.clear();

        Assert.assertEquals(itemsToPush.length, stack.getCapacity());
        Assert.assertEquals(0, stack.size());
        Assert.assertTrue(stack.hasCapacity(itemsToPush.length));
        Assert.assertFalse(stack.isFull());
        Assert.assertTrue(stack.isEmpty());
        Assert.assertEquals(null, stack.peek());
    }

}
