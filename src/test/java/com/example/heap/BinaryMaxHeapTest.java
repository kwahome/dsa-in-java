package com.example.heap;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for binary max heap.
 */
public class BinaryMaxHeapTest {

    @Test
    public void shouldConstructMaxHeap() {
        Heap<Integer> binaryMaxHeap = new BinaryMaxHeap<>();

        Assert.assertEquals(0, binaryMaxHeap.size());
        Assert.assertEquals(1, binaryMaxHeap.getCapacity());

        binaryMaxHeap = new BinaryMaxHeap<Integer>(10);

        Assert.assertEquals(0, binaryMaxHeap.size());
        Assert.assertEquals(10, binaryMaxHeap.getCapacity());

        Integer itemsToInsert[] = { 5, 1, 7, 3, 2, 0, 5, 6, 8, 4 };
        binaryMaxHeap = new BinaryMaxHeap<Integer>(itemsToInsert);

        Assert.assertEquals(itemsToInsert.length, binaryMaxHeap.size());
        Assert.assertEquals(itemsToInsert.length, binaryMaxHeap.getCapacity());

        int expected[] = { 8, 7, 6, 5, 5, 4, 3, 2, 1, 0 };

        int index = 0;

        while (!binaryMaxHeap.isEmpty()) {
            int topItem = binaryMaxHeap.poll().intValue();

            System.out.print(topItem + ", ");

            Assert.assertEquals(expected[index], topItem);
            Assert.assertEquals(expected.length - (index + 1), binaryMaxHeap.size());

            index++;
        }

        binaryMaxHeap = new BinaryMaxHeap<Integer>(Arrays.asList(itemsToInsert));
        Assert.assertEquals(itemsToInsert.length, binaryMaxHeap.size());
        Assert.assertEquals(itemsToInsert.length, binaryMaxHeap.getCapacity());

        index = 0;

        while (!binaryMaxHeap.isEmpty()) {
            int topItem = binaryMaxHeap.poll().intValue();

            System.out.print(topItem + ", ");

            Assert.assertEquals(expected[index], topItem);
            Assert.assertEquals(expected.length - (index + 1), binaryMaxHeap.size());

            index++;
        }

    }

    @Test
    public void shouldConstructMaxHeap_StringTypes() {
        Heap<String> binaryMaxHeap = new BinaryMaxHeap<>();

        Assert.assertEquals(0, binaryMaxHeap.size());
        Assert.assertEquals(1, binaryMaxHeap.getCapacity());

        binaryMaxHeap = new BinaryMaxHeap<String>(10);

        Assert.assertEquals(0, binaryMaxHeap.size());
        Assert.assertEquals(10, binaryMaxHeap.getCapacity());

        String itemsToInsert[] = { "z", "m", "a", "a1", "ba", "b", "k", "0", "c", "x", "1z" };
        binaryMaxHeap = new BinaryMaxHeap<String>(itemsToInsert);

        Assert.assertEquals(itemsToInsert.length, binaryMaxHeap.size());
        Assert.assertEquals(itemsToInsert.length, binaryMaxHeap.getCapacity());

        String expected[] = { "z", "x", "m", "k", "c", "ba", "b", "a1", "a", "1z", "0" };

        int index = 0;

        while (!binaryMaxHeap.isEmpty()) {
            String topItem = binaryMaxHeap.poll();

            System.out.print(topItem + ", ");

            Assert.assertEquals(expected[index], topItem);
            Assert.assertEquals(expected.length - (index + 1), binaryMaxHeap.size());

            index++;
        }

        binaryMaxHeap = new BinaryMaxHeap<String>(Arrays.asList(itemsToInsert));
        Assert.assertEquals(itemsToInsert.length, binaryMaxHeap.size());
        Assert.assertEquals(itemsToInsert.length, binaryMaxHeap.getCapacity());

        index = 0;

        while (!binaryMaxHeap.isEmpty()) {
            String topItem = binaryMaxHeap.poll();

            System.out.print(topItem + ", ");

            Assert.assertEquals(expected[index], topItem);
            Assert.assertEquals(expected.length - (index + 1), binaryMaxHeap.size());

            index++;
        }

    }

    @Test
    public void shouldExpandCapacity() {
        Heap<Integer> binaryMaxHeap = new BinaryMaxHeap<Integer>(3);

        Assert.assertEquals(0, binaryMaxHeap.size());
        Assert.assertEquals(3, binaryMaxHeap.getCapacity());

        binaryMaxHeap.insert(-1);
        Assert.assertEquals(-1, binaryMaxHeap.peek().intValue());
        Assert.assertEquals(1, binaryMaxHeap.size());
        Assert.assertEquals(3, binaryMaxHeap.getCapacity());

        binaryMaxHeap.insert(9);
        Assert.assertEquals(9, binaryMaxHeap.peek().intValue());
        Assert.assertEquals(2, binaryMaxHeap.size());
        Assert.assertEquals(3, binaryMaxHeap.getCapacity());

        Integer itemsToInsert[] = { 5, 1, 7, 3, 2, 0, 5, 6, 8, 4 };

        binaryMaxHeap.insert(itemsToInsert);

        Assert.assertEquals(itemsToInsert.length + 2, binaryMaxHeap.size());
        Assert.assertEquals(itemsToInsert.length + 2, binaryMaxHeap.getCapacity());

        int expected[] = { 9, 8, 7, 6, 5, 5, 4, 3, 2, 1, 0, -1 };

        int index = 0;

        while (!binaryMaxHeap.isEmpty()) {
            int topItem = binaryMaxHeap.poll().intValue();

            System.out.print(topItem + ", ");

            Assert.assertEquals(expected[index], topItem);
            Assert.assertEquals(expected.length - (index + 1), binaryMaxHeap.size());

            index++;
        }
    }

    @Test
    public void shouldAddItems() {
        Heap<Integer> binaryMaxHeap = new BinaryMaxHeap<>();

        Assert.assertEquals(0, binaryMaxHeap.size());

        binaryMaxHeap.insert(1);

        Assert.assertEquals(1, binaryMaxHeap.size());

        Assert.assertEquals(1, binaryMaxHeap.peek().intValue());

        binaryMaxHeap.insert(0);

        Assert.assertEquals(1, binaryMaxHeap.peek().intValue());

        binaryMaxHeap.insert(3);

        binaryMaxHeap.insert(5);

        binaryMaxHeap.insert(8);

        binaryMaxHeap.insert(6);

        binaryMaxHeap.insert(4);

        binaryMaxHeap.insert(5);

        binaryMaxHeap.insert(2);

        binaryMaxHeap.insert(7);

        int expected[] = { 8, 7, 6, 5, 5, 4, 3, 2, 1, 0 };

        int index = 0;

        while (!binaryMaxHeap.isEmpty()) {
            int topItem = binaryMaxHeap.poll().intValue();

            System.out.print(topItem + ", ");

            Assert.assertEquals(expected[index], topItem);
            Assert.assertEquals(expected.length - (index + 1), binaryMaxHeap.size());

            index++;
        }
    }

    @Test
    public void shouldRemoveItems() {
        Heap<Integer> binaryMaxHeap = new BinaryMaxHeap<>();

        Assert.assertEquals(0, binaryMaxHeap.size());

        binaryMaxHeap.insert(1);

        Assert.assertEquals(1, binaryMaxHeap.size());

        Assert.assertEquals(1, binaryMaxHeap.peek().intValue());

        // element 0 does not exist

        Assert.assertFalse(binaryMaxHeap.remove(0));

        Assert.assertEquals(1, binaryMaxHeap.size());

        Assert.assertEquals(1, binaryMaxHeap.peek().intValue());

        // element at position 0 should be removed
        Assert.assertEquals(1, binaryMaxHeap.removeAt(0).intValue());

        Assert.assertEquals(0, binaryMaxHeap.size());

        Assert.assertEquals(null, binaryMaxHeap.peek());

        // insert more elements

        binaryMaxHeap.insert(3);

        binaryMaxHeap.insert(5);

        binaryMaxHeap.insert(8);

        binaryMaxHeap.insert(6);

        binaryMaxHeap.insert(4);

        binaryMaxHeap.insert(1);

        binaryMaxHeap.insert(5);

        binaryMaxHeap.insert(2);

        binaryMaxHeap.insert(7);

        binaryMaxHeap.insert(0);

        // remove some of them
        Assert.assertTrue(binaryMaxHeap.remove(5));
        Assert.assertTrue(binaryMaxHeap.remove(7));

        int expected[] = { 8, 6, 5, 4, 3, 2, 1, 0 };

        int index = 0;

        while (!binaryMaxHeap.isEmpty()) {
            int topItem = binaryMaxHeap.poll().intValue();

            System.out.print(topItem + ", ");

            Assert.assertEquals(expected[index], topItem);
            Assert.assertEquals(expected.length - (index + 1), binaryMaxHeap.size());

            index++;
        }

    }
}
