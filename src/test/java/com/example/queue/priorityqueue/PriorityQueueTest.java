package com.example.queue.priorityqueue;

import java.util.Arrays;

import com.example.queues.priorityqueue.PriorityQueue;
import com.example.queues.priorityqueue.PriorityQueueImpl;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for binary min heap.
 */
public class PriorityQueueTest {

    @Test
    public void shouldConstructPriorityQueue() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueueImpl<>();

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());

        priorityQueue = new PriorityQueueImpl<Integer>(10);

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(10, priorityQueue.getCapacity());

        Integer itemsToInsert[] = { 5, 1, 7, 3, 2, 0, 5, 6, 8, 4 };
        priorityQueue = new PriorityQueueImpl<Integer>(itemsToInsert);

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

        priorityQueue = new PriorityQueueImpl<Integer>(Arrays.asList(itemsToInsert));
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
        PriorityQueue<String> priorityQueue = new PriorityQueueImpl<>();

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(1, priorityQueue.getCapacity());

        priorityQueue = new PriorityQueueImpl<String>(10);

        Assert.assertEquals(0, priorityQueue.size());
        Assert.assertEquals(10, priorityQueue.getCapacity());

        String itemsToInsert[] = { "z", "m", "a", "a1", "ba", "b", "k", "0", "c", "x", "1z" };
        priorityQueue = new PriorityQueueImpl<String>(itemsToInsert);

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

        priorityQueue = new PriorityQueueImpl<String>(Arrays.asList(itemsToInsert));
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
        PriorityQueue<Integer> priorityQueue = new PriorityQueueImpl<Integer>(3);

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

        priorityQueue.enqueue(itemsToInsert);

        Assert.assertEquals(itemsToInsert.length + 2, priorityQueue.size());
        Assert.assertEquals(itemsToInsert.length + 2, priorityQueue.getCapacity());

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
    public void shouldAddItems() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueueImpl<>();

        Assert.assertEquals(0, priorityQueue.size());

        priorityQueue.enqueue(1);

        Assert.assertEquals(1, priorityQueue.size());

        Assert.assertEquals(1, priorityQueue.peek().intValue());

        priorityQueue.enqueue(0);

        Assert.assertEquals(0, priorityQueue.peek().intValue());

        priorityQueue.enqueue(3);

        priorityQueue.enqueue(5);

        priorityQueue.enqueue(8);

        priorityQueue.enqueue(6);

        priorityQueue.enqueue(4);

        priorityQueue.enqueue(5);

        priorityQueue.enqueue(2);

        priorityQueue.enqueue(7);

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
    public void shouldRemoveItems() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueueImpl<>();

        Assert.assertEquals(0, priorityQueue.size());

        priorityQueue.enqueue(1);

        Assert.assertEquals(1, priorityQueue.size());

        Assert.assertEquals(1, priorityQueue.peek().intValue());

        // element 0 does not exist

        Assert.assertFalse(priorityQueue.remove(0));

        Assert.assertEquals(1, priorityQueue.size());

        Assert.assertEquals(1, priorityQueue.peek().intValue());

        // element at position 0 should be removed
        Assert.assertEquals(1, priorityQueue.removeAt(0).intValue());

        Assert.assertEquals(0, priorityQueue.size());

        Assert.assertEquals(null, priorityQueue.peek());

        // insert more elements

        priorityQueue.enqueue(3);

        priorityQueue.enqueue(5);

        priorityQueue.enqueue(8);

        priorityQueue.enqueue(6);

        priorityQueue.enqueue(4);

        priorityQueue.enqueue(1);

        priorityQueue.enqueue(5);

        priorityQueue.enqueue(2);

        priorityQueue.enqueue(7);

        priorityQueue.enqueue(0);

        // remove some of them
        Assert.assertTrue(priorityQueue.remove(5));
        Assert.assertTrue(priorityQueue.remove(7));

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
}
