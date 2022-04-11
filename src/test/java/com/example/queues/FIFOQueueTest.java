package com.example.queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the FIFOQueue implementation.
 */
public class FIFOQueueTest {

    @Test
    public void shouldCreateAFIFOQueue() {
        Queue<Integer> queue = new FIFOQueue<>();

        Assert.assertEquals(0, queue.size());
        Assert.assertEquals(1, queue.getCapacity());
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
        Assert.assertEquals(null, queue.peek());
        Assert.assertFalse(queue.contains(0));

        queue = new FIFOQueue<>(10);

        Assert.assertEquals(0, queue.size());
        Assert.assertEquals(10, queue.getCapacity());
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
        Assert.assertEquals(null, queue.peek());
        Assert.assertFalse(queue.contains(0));

        Integer[] arrayOfQueueItems = { 0, 1, 2, 3, 4, 5 };
        queue = new FIFOQueue<>(arrayOfQueueItems);

        Assert.assertEquals(arrayOfQueueItems.length, queue.getCapacity());
        Assert.assertEquals(arrayOfQueueItems.length, queue.size());
        Assert.assertFalse(queue.isEmpty());
        Assert.assertTrue(queue.isFull());
        Assert.assertEquals(arrayOfQueueItems[0], queue.peek());

        for (Integer item : arrayOfQueueItems) {
            Assert.assertTrue(queue.contains(item));
        }

        List<Integer> listOfQueueItems = Arrays.asList(arrayOfQueueItems);
        queue = new FIFOQueue<>(listOfQueueItems);

        Assert.assertEquals(listOfQueueItems.size(), queue.getCapacity());
        Assert.assertEquals(listOfQueueItems.size(), queue.size());
        Assert.assertFalse(queue.isEmpty());
        Assert.assertTrue(queue.isFull());
        Assert.assertEquals(listOfQueueItems.get(0), queue.peek());

        for (Integer item : listOfQueueItems) {
            Assert.assertTrue(queue.contains(item));
        }
    }

    @Test
    public void shouldEnqueueItemsIfNotFull() {
        Queue<Integer> queue = new FIFOQueue<>();

        Assert.assertEquals(1, queue.getCapacity());
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
        Assert.assertEquals(null, queue.peek());
        Assert.assertFalse(queue.contains(0));

        Assert.assertTrue(queue.hasCapacity(1));
        Assert.assertTrue(queue.enqueue(1));

        Assert.assertEquals(1, queue.getCapacity());
        Assert.assertFalse(queue.hasCapacity(1));
        Assert.assertEquals(1, queue.size());
        Assert.assertFalse(queue.isEmpty());
        Assert.assertTrue(queue.isFull());
        Assert.assertEquals(1, queue.peek().intValue());
        Assert.assertTrue(queue.contains(1));

        // try to enqueue when queue is full
        Assert.assertFalse(queue.enqueue(2));

        Assert.assertEquals(1, queue.getCapacity());
        Assert.assertFalse(queue.hasCapacity(1));
        Assert.assertEquals(1, queue.size());
        Assert.assertFalse(queue.isEmpty());
        Assert.assertTrue(queue.isFull());
        Assert.assertEquals(1, queue.peek().intValue());
        Assert.assertTrue(queue.contains(1));
        Assert.assertFalse(queue.contains(2));

        Integer[] itemsToEnqueue = { 2, 3, 4, 5 };

        Assert.assertFalse(queue.hasCapacity(itemsToEnqueue.length));

        Assert.assertTrue(queue.expandCapacity(itemsToEnqueue.length));

        Assert.assertTrue(queue.hasCapacity(itemsToEnqueue.length));

        Assert.assertTrue(queue.enqueue(itemsToEnqueue));

        for (Integer item : itemsToEnqueue) {
            Assert.assertTrue(queue.contains(item));
        }

        List<Integer> collectionToEnqueue = new ArrayList<Integer>(Arrays.asList(new Integer[] { 6, 7, 8, 9, 10 }));

        Assert.assertFalse(queue.hasCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.expandCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.hasCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.enqueue(collectionToEnqueue));

        for (Integer item : collectionToEnqueue) {
            Assert.assertTrue(queue.contains(item));
        }
    }

    @Test
    public void shouldDequeueIfNotEmpty() {
        Queue<Integer> queue = new FIFOQueue<>();

        Assert.assertEquals(1, queue.getCapacity());
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
        Assert.assertEquals(null, queue.peek());
        Assert.assertFalse(queue.contains(0));

        Assert.assertNull(queue.dequeue());

        Assert.assertTrue(queue.hasCapacity(1));

        Assert.assertTrue(queue.enqueue(1));

        Assert.assertEquals(1, queue.getCapacity());
        Assert.assertFalse(queue.hasCapacity(1));
        Assert.assertEquals(1, queue.size());
        Assert.assertFalse(queue.isEmpty());
        Assert.assertTrue(queue.isFull());
        Assert.assertEquals(1, queue.peek().intValue());
        Assert.assertTrue(queue.contains(1));

        Assert.assertEquals(1, queue.dequeue().intValue());

        Assert.assertEquals(1, queue.getCapacity());
        Assert.assertTrue(queue.hasCapacity(1));
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
        Assert.assertEquals(null, queue.peek());
        Assert.assertFalse(queue.contains(1));
        Assert.assertFalse(queue.contains(2));

        List<Integer> collectionToEnqueue = new ArrayList<Integer>(Arrays.asList(new Integer[] { 2, 3, 4, 5, 6 }));

        Assert.assertFalse(queue.hasCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.expandCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.hasCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.enqueue(collectionToEnqueue));

        int index = 0;

        do {
            Assert.assertEquals(collectionToEnqueue.get(index), queue.dequeue());

            Assert.assertEquals(collectionToEnqueue.size() - (index + 1), queue.size());

            if (!queue.isEmpty()) {
                Assert.assertEquals(collectionToEnqueue.get(index + 1), queue.peek());
            }

            index++;

        } while (!queue.isEmpty());
    }

    @Test
    public void shouldGetAnItemGivenAPosition() {
        Queue<Integer> queue = new FIFOQueue<>();

        Assert.assertEquals(1, queue.getCapacity());
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
        Assert.assertEquals(null, queue.peek());
        Assert.assertFalse(queue.contains(0));

        List<Integer> collectionToEnqueue = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }));

        Assert.assertFalse(queue.hasCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.expandCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.hasCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.enqueue(collectionToEnqueue));

        for (int i = 0; i < collectionToEnqueue.size(); i++) {
            Assert.assertEquals(collectionToEnqueue.get(i), queue.getItemAt(i));
        }
    }

    @Test
    public void shouldRemoveAnItem() {
        Queue<Integer> queue = new FIFOQueue<>();

        Assert.assertEquals(1, queue.getCapacity());
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
        Assert.assertEquals(null, queue.peek());
        Assert.assertFalse(queue.remove(0));

        List<Integer> collectionToEnqueue = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }));

        Assert.assertFalse(queue.hasCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.expandCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.hasCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.enqueue(collectionToEnqueue));

        Assert.assertEquals(collectionToEnqueue.size() + 1, queue.getCapacity());

        int removed = 0;

        for (Integer item : collectionToEnqueue) {
            Assert.assertTrue(queue.remove(item));

            Assert.assertEquals(collectionToEnqueue.size() + 1, queue.getCapacity());
            Assert.assertEquals(collectionToEnqueue.size() - (removed + 1), queue.size());
            Assert.assertFalse(queue.contains(item));

            removed++;
        }
    }

    @Test
    public void shouldRemoveAnItemGivenItsPosition() {
        Queue<Integer> queue = new FIFOQueue<>();

        Assert.assertEquals(1, queue.getCapacity());
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
        Assert.assertEquals(null, queue.peek());

        List<Integer> collectionToEnqueue = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }));

        Assert.assertFalse(queue.hasCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.expandCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.hasCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.enqueue(collectionToEnqueue));

        Assert.assertEquals(collectionToEnqueue.size() + 1, queue.getCapacity());

        for (int i = 0; i < collectionToEnqueue.size(); i++) {
            Integer removed = queue.removeAt(0);

            Assert.assertEquals(collectionToEnqueue.get(i), removed);

            Assert.assertEquals(collectionToEnqueue.size() + 1, queue.getCapacity());
            Assert.assertEquals(collectionToEnqueue.size() - (i + 1), queue.size());

            Assert.assertFalse(queue.contains(removed));
        }
    }

    @Test
    public void shouldClearTheQueue() {
        Queue<Integer> queue = new FIFOQueue<>();

        Assert.assertEquals(1, queue.getCapacity());
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
        Assert.assertEquals(null, queue.peek());
        Assert.assertFalse(queue.contains(0));

        List<Integer> collectionToEnqueue = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }));

        Assert.assertFalse(queue.hasCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.expandCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.hasCapacity(collectionToEnqueue.size()));

        Assert.assertTrue(queue.enqueue(collectionToEnqueue));

        queue.clear();

        Assert.assertEquals(collectionToEnqueue.size() + 1, queue.getCapacity());
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
        Assert.assertEquals(null, queue.peek());
    }
}
