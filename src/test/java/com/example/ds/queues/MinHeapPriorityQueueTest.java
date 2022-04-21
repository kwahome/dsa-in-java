package com.example.ds.queues;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for binary min heap.
 */
public class MinHeapPriorityQueueTest {

    @Test
    public void shouldConstructPriorityQueue() {
        PriorityQueue<Integer> priorityQueue = new MinHeapPriorityQueue<>();

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());

        priorityQueue = new MinHeapPriorityQueue<Integer>(10);

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(10, priorityQueue.getCapacity());

        Integer itemsToInsert[] = { 5, 1, 7, 3, 2, 0, 5, 6, 8, 4 };
        priorityQueue = new MinHeapPriorityQueue<Integer>(itemsToInsert);

        Assert.assertEquals(itemsToInsert.length, priorityQueue.size());
        Assert.assertEquals(itemsToInsert.length, priorityQueue.getCapacity());

        int expected[] = { 0, 1, 2, 3, 4, 5, 5, 6, 7, 8 };

        int index = 0;

        while (!priorityQueue.isEmpty()) {
            int topItem = priorityQueue.dequeue().intValue();

            System.out.print(topItem + ", ");

            Assert.assertEquals(expected[index], topItem);
            Assert.assertEquals(expected.length - (index + 1), priorityQueue.size());

            index++;
        }

        priorityQueue = new MinHeapPriorityQueue<Integer>(Arrays.asList(itemsToInsert));
        Assert.assertEquals(itemsToInsert.length, priorityQueue.size());
        Assert.assertEquals(itemsToInsert.length, priorityQueue.getCapacity());

        index = 0;

        while (!priorityQueue.isEmpty()) {
            int topItem = priorityQueue.dequeue().intValue();

            System.out.print(topItem + ", ");

            Assert.assertEquals(expected[index], topItem);
            Assert.assertEquals(expected.length - (index + 1), priorityQueue.size());

            index++;
        }

    }

    @Test
    public void shouldConstructPriorityQueue_StringTypes() {
        PriorityQueue<String> priorityQueue = new MinHeapPriorityQueue<>();

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());

        priorityQueue = new MinHeapPriorityQueue<String>(10);

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(10, priorityQueue.getCapacity());

        String itemsToInsert[] = { "z", "m", "a", "a1", "ba", "b", "k", "0", "c", "x", "1z" };
        priorityQueue = new MinHeapPriorityQueue<String>(itemsToInsert);

        Assert.assertEquals(itemsToInsert.length, priorityQueue.size());
        Assert.assertEquals(itemsToInsert.length, priorityQueue.getCapacity());

        String expected[] = { "0", "1z", "a", "a1", "b", "ba", "c", "k", "m", "x", "z" };

        int index = 0;

        while (!priorityQueue.isEmpty()) {
            String topItem = priorityQueue.dequeue();

            System.out.print(topItem + ", ");

            Assert.assertEquals(expected[index], topItem);
            Assert.assertEquals(expected.length - (index + 1), priorityQueue.size());

            index++;
        }

        priorityQueue = new MinHeapPriorityQueue<String>(Arrays.asList(itemsToInsert));
        Assert.assertEquals(itemsToInsert.length, priorityQueue.size());
        Assert.assertEquals(itemsToInsert.length, priorityQueue.getCapacity());

        index = 0;

        while (!priorityQueue.isEmpty()) {
            String topItem = priorityQueue.dequeue();

            System.out.print(topItem + ", ");

            Assert.assertEquals(expected[index], topItem);
            Assert.assertEquals(expected.length - (index + 1), priorityQueue.size());

            index++;
        }

    }

    @Test
    public void shouldExpandCapacity() {
        PriorityQueue<Integer> priorityQueue = new MinHeapPriorityQueue<Integer>(3);

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(3, priorityQueue.getCapacity());

        priorityQueue.enqueue(9);
        Assert.assertEquals(9, priorityQueue.peek().intValue());
        Assert.assertEquals(1, priorityQueue.size());
        Assert.assertEquals(3, priorityQueue.getCapacity());

        priorityQueue.enqueue(-1);
        Assert.assertEquals(-1, priorityQueue.peek().intValue());
        Assert.assertEquals(2, priorityQueue.size());
        Assert.assertEquals(3, priorityQueue.getCapacity());

        Integer itemsToInsert[] = { 5, 1, 7, 3, 2, 0, 5, 6, 8, 4 };

        // we have exceeded the capacity
        Assert.assertFalse(priorityQueue.enqueue(itemsToInsert));

        int initialQueueCapacity = priorityQueue.getCapacity();
        int initialQueueSize = priorityQueue.size();

        Assert.assertTrue(priorityQueue.expandCapacity(itemsToInsert.length));

        Assert.assertTrue(priorityQueue.enqueue(itemsToInsert));

        Assert.assertEquals(itemsToInsert.length + initialQueueSize, priorityQueue.size());
        Assert.assertEquals(itemsToInsert.length + initialQueueCapacity, priorityQueue.getCapacity());

        int expected[] = { -1, 0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9 };

        int index = 0;

        while (!priorityQueue.isEmpty()) {
            int topItem = priorityQueue.dequeue().intValue();

            System.out.print(topItem + ", ");

            Assert.assertEquals(expected[index], topItem);
            Assert.assertEquals(expected.length - (index + 1), priorityQueue.size());

            index++;
        }
    }

    @Test
    public void shouldEnqueueItemsIfNotFull() {
        PriorityQueue<Integer> priorityQueue = new MinHeapPriorityQueue<>();

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());

        Assert.assertTrue(priorityQueue.enqueue(1));

        Assert.assertEquals(1, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());

        Assert.assertEquals(1, priorityQueue.peek().intValue());

        Assert.assertTrue(priorityQueue.expandCapacity(9));

        Assert.assertTrue(priorityQueue.enqueue(0));

        Assert.assertEquals(0, priorityQueue.peek().intValue());

        Assert.assertTrue(priorityQueue.enqueue(3));

        Assert.assertTrue(priorityQueue.enqueue(5));

        Assert.assertTrue(priorityQueue.enqueue(8));

        Assert.assertTrue(priorityQueue.enqueue(6));

        Assert.assertTrue(priorityQueue.enqueue(4));

        Assert.assertTrue(priorityQueue.enqueue(5));

        Assert.assertTrue(priorityQueue.enqueue(2));

        Assert.assertTrue(priorityQueue.enqueue(7));

        int expected[] = { 0, 1, 2, 3, 4, 5, 5, 6, 7, 8 };

        int index = 0;

        while (!priorityQueue.isEmpty()) {
            int topItem = priorityQueue.dequeue().intValue();

            System.out.print(topItem + ", ");

            Assert.assertEquals(expected[index], topItem);
            Assert.assertEquals(expected.length - (index + 1), priorityQueue.size());

            index++;
        }
    }

    @Test
    public void shouldDequeueAnItemIfNotEmpty() {
        PriorityQueue<Integer> priorityQueue = new MinHeapPriorityQueue<>();

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());
        Assert.assertNull(priorityQueue.dequeue());

        priorityQueue.enqueue(1);

        Assert.assertEquals(1, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());

        Assert.assertEquals(1, priorityQueue.peek().intValue());
        Assert.assertEquals(1, priorityQueue.dequeue().intValue());

        Integer[] arrayOfQueueItems = { 0, 1, 2, 3, 4, 5, 6, 8 };

        Assert.assertFalse(priorityQueue.hasCapacity(arrayOfQueueItems.length));

        Assert.assertTrue(priorityQueue.expandCapacity(arrayOfQueueItems.length));

        priorityQueue.enqueue(arrayOfQueueItems);

        Assert.assertEquals(arrayOfQueueItems.length, priorityQueue.size());
        Assert.assertEquals(arrayOfQueueItems.length + 1, priorityQueue.getCapacity());

        Assert.assertEquals(arrayOfQueueItems[0], priorityQueue.peek());

        int index = 0;

        do {
            Assert.assertEquals(arrayOfQueueItems[index], priorityQueue.dequeue());

            Assert.assertEquals(arrayOfQueueItems.length - (index + 1), priorityQueue.size());

            index++;

        } while (!priorityQueue.isEmpty());
    }

    @Test
    public void shouldRemoveItems() {
        PriorityQueue<Integer> priorityQueue = new MinHeapPriorityQueue<>();

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());

        Assert.assertTrue(priorityQueue.enqueue(1));

        Assert.assertEquals(1, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());

        Assert.assertEquals(1, priorityQueue.peek().intValue());

        // element 0 does not exist

        Assert.assertFalse(priorityQueue.remove(0));

        Assert.assertEquals(1, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());

        Assert.assertEquals(1, priorityQueue.peek().intValue());

        // element at position 0 should be removed
        Assert.assertEquals(1, priorityQueue.removeAt(0).intValue());

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());
        Assert.assertTrue(priorityQueue.hasCapacity(1));

        Assert.assertEquals(null, priorityQueue.peek());

        Assert.assertTrue(priorityQueue.expandCapacity(9));

        // insert more elements

        Assert.assertTrue(priorityQueue.enqueue(3));

        Assert.assertTrue(priorityQueue.enqueue(5));

        Assert.assertTrue(priorityQueue.enqueue(8));

        Assert.assertTrue(priorityQueue.enqueue(6));

        Assert.assertTrue(priorityQueue.enqueue(4));

        Assert.assertTrue(priorityQueue.enqueue(1));

        Assert.assertTrue(priorityQueue.enqueue(5));

        Assert.assertTrue(priorityQueue.enqueue(2));

        Assert.assertTrue(priorityQueue.enqueue(7));

        Assert.assertTrue(priorityQueue.enqueue(0));

        Assert.assertFalse(priorityQueue.hasCapacity(1));

        // remove some of them
        Assert.assertTrue(priorityQueue.remove(5));
        Assert.assertTrue(priorityQueue.remove(7));

        Assert.assertFalse(priorityQueue.hasCapacity(2));

        int expected[] = { 0, 1, 2, 3, 4, 5, 6, 8 };

        int index = 0;

        while (!priorityQueue.isEmpty()) {
            int topItem = priorityQueue.dequeue().intValue();

            System.out.print(topItem + ", ");

            Assert.assertEquals(expected[index], topItem);
            Assert.assertEquals(expected.length - (index + 1), priorityQueue.size());

            index++;
        }
    }

    @Test
    public void shouldClearItems() {
        PriorityQueue<Integer> priorityQueue = new MinHeapPriorityQueue<>();

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());

        priorityQueue.enqueue(1);

        Assert.assertEquals(1, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());

        Assert.assertEquals(1, priorityQueue.peek().intValue());

        Integer[] arrayOfQueueItems = { 0, 1, 2, 3, 4, 5, 6, 8 };

        Assert.assertFalse(priorityQueue.hasCapacity(arrayOfQueueItems.length));

        Assert.assertTrue(priorityQueue.expandCapacity(arrayOfQueueItems.length));

        priorityQueue.enqueue(arrayOfQueueItems);

        Assert.assertEquals(arrayOfQueueItems.length + 1, priorityQueue.size());
        Assert.assertEquals(arrayOfQueueItems.length + 1, priorityQueue.getCapacity());

        Assert.assertEquals(arrayOfQueueItems[0], priorityQueue.peek());

        priorityQueue.clear();

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(arrayOfQueueItems.length + 1, priorityQueue.getCapacity());
        Assert.assertTrue(priorityQueue.hasCapacity(arrayOfQueueItems.length + 1));

        Assert.assertEquals(null, priorityQueue.peek());
    }

    @Test
    public void shouldGetAnItemGivenAPosition() {
        PriorityQueue<Integer> priorityQueue = new MinHeapPriorityQueue<>();

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());
        Assert.assertEquals(null, priorityQueue.getItemAt(0));

        Integer[] arrayOfQueueItems = { 0, 1, 2, 3, 4, 5, 6, 8 };

        Assert.assertFalse(priorityQueue.hasCapacity(arrayOfQueueItems.length));

        Assert.assertTrue(priorityQueue.expandCapacity(arrayOfQueueItems.length));

        priorityQueue.enqueue(arrayOfQueueItems);

        Assert.assertEquals(arrayOfQueueItems.length, priorityQueue.size());
        Assert.assertEquals(arrayOfQueueItems.length + 1, priorityQueue.getCapacity());

        Assert.assertEquals(arrayOfQueueItems[0], priorityQueue.peek());

        for (int i = 0; i < arrayOfQueueItems.length; i++) {
            Assert.assertEquals(arrayOfQueueItems[i], priorityQueue.getItemAt(i));
        }
    }
}
