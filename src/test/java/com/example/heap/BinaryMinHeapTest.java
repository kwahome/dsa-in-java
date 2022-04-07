package com.example.heap;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for binary min heap.
 */
public class BinaryMinHeapTest {

    @Test
    public void shouldConstructMinHeap() {
        Heap<Integer> binaryMinHeap = new BinaryMinHeap<>();

        Assert.assertEquals(0, binaryMinHeap.getNumberOfItems());
        Assert.assertEquals(1, binaryMinHeap.getCapacity());

        binaryMinHeap = new BinaryMinHeap<Integer>(10);

        Assert.assertEquals(0, binaryMinHeap.getNumberOfItems());
        Assert.assertEquals(10, binaryMinHeap.getCapacity());

        Integer itemsToInsert[] = { 5, 1, 7, 3, 2, 0, 5, 6, 8, 4 };
        binaryMinHeap = new BinaryMinHeap<Integer>(itemsToInsert);

        Assert.assertEquals(itemsToInsert.length, binaryMinHeap.getNumberOfItems());
        Assert.assertEquals(itemsToInsert.length, binaryMinHeap.getCapacity());

        int expected[] = { 0, 1, 2, 3, 4, 5, 5, 6, 7, 8 };

        int index = 0;

        while (!binaryMinHeap.isEmpty()) {
            System.out.print(index);
            Assert.assertEquals(expected[index], binaryMinHeap.poll().intValue());

            index++;
        }

        binaryMinHeap = new BinaryMinHeap<Integer>(Arrays.asList(itemsToInsert));
        Assert.assertEquals(itemsToInsert.length, binaryMinHeap.getNumberOfItems());
        Assert.assertEquals(itemsToInsert.length, binaryMinHeap.getCapacity());

        index = 0;

        while (!binaryMinHeap.isEmpty()) {
            System.out.print(index);
            Assert.assertEquals(expected[index], binaryMinHeap.poll().intValue());

            index++;
        }

    }

    @Test
    public void shouldConstructMinHeap_StringTypes() {
        Heap<String> binaryMinHeap = new BinaryMinHeap<>();

        Assert.assertEquals(0, binaryMinHeap.getNumberOfItems());
        Assert.assertEquals(1, binaryMinHeap.getCapacity());

        binaryMinHeap = new BinaryMinHeap<String>(10);

        Assert.assertEquals(0, binaryMinHeap.getNumberOfItems());
        Assert.assertEquals(10, binaryMinHeap.getCapacity());

        String itemsToInsert[] = { "z", "m", "a", "a1", "ba", "b", "k", "0", "c", "x", "1z" };
        binaryMinHeap = new BinaryMinHeap<String>(itemsToInsert);

        Assert.assertEquals(itemsToInsert.length, binaryMinHeap.getNumberOfItems());
        Assert.assertEquals(itemsToInsert.length, binaryMinHeap.getCapacity());

        String expected[] = { "0", "1z", "a", "a1", "b", "ba", "c", "k", "m", "x", "z" };

        int index = 0;

        while (!binaryMinHeap.isEmpty()) {
            System.out.print(index);
            Assert.assertEquals(expected[index], binaryMinHeap.poll());

            index++;
        }

        binaryMinHeap = new BinaryMinHeap<String>(Arrays.asList(itemsToInsert));
        Assert.assertEquals(itemsToInsert.length, binaryMinHeap.getNumberOfItems());
        Assert.assertEquals(itemsToInsert.length, binaryMinHeap.getCapacity());

        index = 0;

        while (!binaryMinHeap.isEmpty()) {
            System.out.print(index);
            Assert.assertEquals(expected[index], binaryMinHeap.poll());

            index++;
        }

    }

    @Test
    public void shouldAddItems() {
        Heap<Integer> binaryMinHeap = new BinaryMinHeap<>();

        Assert.assertEquals(0, binaryMinHeap.getNumberOfItems());

        binaryMinHeap.insert(1);

        Assert.assertEquals(1, binaryMinHeap.getNumberOfItems());

        Assert.assertEquals(1, binaryMinHeap.peek().intValue());

        binaryMinHeap.insert(0);

        Assert.assertEquals(0, binaryMinHeap.peek().intValue());

        binaryMinHeap.insert(3);

        binaryMinHeap.insert(5);

        binaryMinHeap.insert(8);

        binaryMinHeap.insert(6);

        binaryMinHeap.insert(4);

        binaryMinHeap.insert(5);

        binaryMinHeap.insert(2);

        binaryMinHeap.insert(7);

        int expected[] = { 0, 1, 2, 3, 4, 5, 5, 6, 7, 8 };

        int index = 0;

        while (!binaryMinHeap.isEmpty()) {
            System.out.print(index);
            Assert.assertEquals(expected[index], binaryMinHeap.poll().intValue());

            index++;
        }
    }

    @Test
    public void shouldRemoveItems() {
        Heap<Integer> binaryMinHeap = new BinaryMinHeap<>();

        Assert.assertEquals(0, binaryMinHeap.getNumberOfItems());

        binaryMinHeap.insert(1);

        Assert.assertEquals(1, binaryMinHeap.getNumberOfItems());

        Assert.assertEquals(1, binaryMinHeap.peek().intValue());

        // element 0 does not exist

        Assert.assertFalse(binaryMinHeap.remove(0));

        Assert.assertEquals(1, binaryMinHeap.getNumberOfItems());

        Assert.assertEquals(1, binaryMinHeap.peek().intValue());

        // element at position 0 should be removed
        Assert.assertEquals(1, binaryMinHeap.removeAt(0).intValue());

        Assert.assertEquals(0, binaryMinHeap.getNumberOfItems());

        Assert.assertEquals(null, binaryMinHeap.peek());

        // insert more elements

        binaryMinHeap.insert(3);

        binaryMinHeap.insert(5);

        binaryMinHeap.insert(8);

        binaryMinHeap.insert(6);

        binaryMinHeap.insert(4);

        binaryMinHeap.insert(1);

        binaryMinHeap.insert(5);

        binaryMinHeap.insert(2);

        binaryMinHeap.insert(7);

        binaryMinHeap.insert(0);

        // remove some of them
        Assert.assertTrue(binaryMinHeap.remove(5));
        Assert.assertTrue(binaryMinHeap.remove(7));

        int expected[] = { 0, 1, 2, 3, 4, 5, 6, 8 };

        int index = 0;

        while (!binaryMinHeap.isEmpty()) {
            System.out.print(index);
            Assert.assertEquals(expected[index], binaryMinHeap.poll().intValue());

            index++;
        }

    }
}
