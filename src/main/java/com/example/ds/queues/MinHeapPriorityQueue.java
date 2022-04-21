package com.example.ds.queues;

import java.util.Collection;

import com.example.ds.heap.BinaryMinHeap;
import com.example.ds.heap.Heap;

/**
 * PriorityQueue implementation
 */
public class MinHeapPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    // A Heap that backs the priority queue.
    private Heap<T> backingHeap = null;

    // The capacity of the priority queue.
    private int capacity = 0;

    /**
     * Class constructor.
     * 
     */
    public MinHeapPriorityQueue() {
        this(1);
    }

    /**
     * Class constructor.
     * 
     * @param capacity an integer representing the capacity of the heap.
     */
    public MinHeapPriorityQueue(int capacity) {
        this.backingHeap = new BinaryMinHeap<>(capacity);

        this.capacity = capacity;
    }

    /**
     * Construct a priority queue given an array of items that should be inserted.
     * 
     * @param capacity an integer representing the capacity of the heap.
     */
    public MinHeapPriorityQueue(T[] items) {

        this.backingHeap = new BinaryMinHeap<>(items);

        this.capacity = items.length;
    }

    /**
     * Construct a heap given a collectoin of items that should be inserted.
     * 
     * It uses heapify in O(n) time.
     * 
     * @param capacity an integer representing the capacity of the heap.
     */
    public MinHeapPriorityQueue(Collection<T> items) {

        this.backingHeap = new BinaryMinHeap<>(items);

        this.capacity = items.size();
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        this.backingHeap.clear();
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(T item) {
        return this.backingHeap.contains(item);
    }

    /**
     * {@inheritDoc}
     */
    public T dequeue() {
        if (!this.isEmpty()) {
            return this.backingHeap.poll();
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean enqueue(T item) {

        if (this.hasCapacity(1)) {
            this.backingHeap.insert(item);

            return true;
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean enqueue(T[] items) {
        if (this.hasCapacity(items.length)) {
            this.backingHeap.insert(items);

            return true;
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean enqueue(Collection<T> items) {
        if (this.hasCapacity(items.size())) {
            this.backingHeap.insert(items);

            return true;
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean expandCapacity(int additionalCapacity) {
        this.capacity = this.capacity + additionalCapacity;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * {@inheritDoc}
     */
    public T getItemAt(int position) {
        return this.backingHeap.getItemAt(position);
    }

    /**
     * {@inheritDoc}
     */
    public boolean hasCapacity(int numberOfItems) {
        return !this.isFull() && (numberOfItems <= (this.getCapacity() - this.size()));
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return this.backingHeap.size();
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return this.backingHeap.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    public boolean isFull() {
        return this.getCapacity() == this.backingHeap.size();
    }

    /**
     * {@inheritDoc}
     */
    public T peek() {
        return this.backingHeap.peek();
    }

    /**
     * {@inheritDoc}
     */
    public boolean remove(T item) {
        if (this.backingHeap.remove(item)) {

            this.capacity--;

            return true;
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    public T removeAt(int position) {
        return this.backingHeap.removeAt(position);
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return this.backingHeap.toString();
    }
}
