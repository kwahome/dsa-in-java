package com.example.queues;

import java.util.Collection;

import com.example.heap.BinaryMinHeap;
import com.example.heap.Heap;

/**
 * PriorityQueue implementation
 */
public class MinHeapPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    // A Heap that backs the priority queue.
    private Heap<T> backingHeap = null;

    /**
     * Class constructor.
     * 
     */
    public MinHeapPriorityQueue() {
        this.backingHeap = new BinaryMinHeap<>();
    }

    /**
     * Class constructor.
     * 
     * @param capacity an integer representing the capacity of the heap.
     */
    public MinHeapPriorityQueue(int capacity) {
        this.backingHeap = new BinaryMinHeap<>(capacity);
    }

    /**
     * Construct a priority queue given an array of items that should be inserted.
     * 
     * @param capacity an integer representing the capacity of the heap.
     */
    public MinHeapPriorityQueue(T[] items) {

        this.backingHeap = new BinaryMinHeap<>(items);
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
    }

    @Override
    public void clear() {
        this.backingHeap.clear();
    }

    @Override
    public boolean contains(T item) {
        return this.backingHeap.contains(item);
    }

    @Override
    public T dequeue() {
        return this.backingHeap.poll();
    }

    @Override
    public int getCapacity() {
        return this.backingHeap.getCapacity();
    }

    @Override
    public T getItemAt(int position) {
        return this.backingHeap.getItemAt(position);
    }

    @Override
    public int size() {
        return this.backingHeap.size();
    }

    @Override
    public void enqueue(T item) {
        this.backingHeap.insert(item);
    }

    @Override
    public void enqueue(T[] items) {
        this.backingHeap.insert(items);
    }

    @Override
    public void enqueue(Collection<T> items) {
        this.backingHeap.insert(items);
    }

    @Override
    public boolean isEmpty() {
        return this.backingHeap.isEmpty();
    }

    @Override
    public T peek() {
        return this.backingHeap.peek();
    }

    @Override
    public boolean remove(T item) {
        return this.backingHeap.remove(item);
    }

    @Override
    public T removeAt(int position) {
        return this.backingHeap.removeAt(position);
    }

    @Override
    public String toString() {
        return this.backingHeap.toString();
    }
}
