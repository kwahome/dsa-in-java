package com.example.queues;

import java.util.Collection;

import com.example.linkedlist.LinkedList;
import com.example.linkedlist.SinglyLinkedList;

/**
 * First In First Out queue implementation.
 */
public class FIFOQueue<T> implements Queue<T> {

    // An integer representing the capacity of the queue
    private int capacity;

    // A linked list that backs the FIFO queue implementation
    private LinkedList<T> backingLinkedList;

    /**
     * Class constructor.
     */
    public FIFOQueue() {
        this(1);
    }

    /**
     * Class constructor.
     * 
     * @param capacity the capacity of the queue.
     */
    public FIFOQueue(int capacity) {
        this.capacity = capacity;
        this.backingLinkedList = new SinglyLinkedList<>();
    }

    /**
     * Class constructor.
     * 
     * @param items an array of items to add to the queue.
     */
    public FIFOQueue(T[] items) {
        this.capacity = items.length;

        this.backingLinkedList = new SinglyLinkedList<>(items);
    }

    /**
     * Class constructor.
     * 
     * @param items a collection of items to add to the queue.
     */
    public FIFOQueue(Collection<T> items) {
        this.capacity = items.size();

        this.backingLinkedList = new SinglyLinkedList<>(items);
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        this.backingLinkedList.clear();
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(T item) {
        return this.backingLinkedList.contains(item);
    }

    /**
     * {@inheritDoc}
     */
    public T dequeue() {
        if (!this.isEmpty()) {
            return this.backingLinkedList.poll();
        }

        return null;
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
        return this.backingLinkedList.get(position);
    }

    /**
     * {@inheritDoc}
     */
    public boolean enqueue(T item) {
        if (this.hasCapacity(1)) {
            // there is capacity
            this.backingLinkedList.add(item);

            return true;
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean enqueue(T[] items) {
        if (this.hasCapacity(items.length)) {
            // there is capacity
            this.backingLinkedList.addAll(items);

            return true;
        }

        return false;

    }

    /**
     * {@inheritDoc}
     */
    public boolean enqueue(Collection<T> items) {
        if (this.hasCapacity(items.size())) {
            // there is capacity
            this.backingLinkedList.addAll(items);

            return true;
        }

        return false;
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
    public boolean isEmpty() {
        return this.backingLinkedList.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    public boolean isFull() {
        return this.getCapacity() == this.size();
    }

    /**
     * {@inheritDoc}
     */
    public T peek() {
        return this.backingLinkedList.peek();
    }

    /**
     * {@inheritDoc}
     */
    public boolean remove(T item) {
        return this.backingLinkedList.remove(item);
    }

    /**
     * {@inheritDoc}
     */
    public T removeAt(int position) {
        return this.backingLinkedList.removeAt(position);
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return this.backingLinkedList.size();
    }

}
