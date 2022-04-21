package com.example.ds.stack;

import java.util.Collection;

import com.example.ds.linkedlist.LinkedList;
import com.example.ds.linkedlist.SinglyLinkedList;

/**
 * Implementation of a stack using a linked list.
 */
public class LinkedListBasedStack<T> implements Stack<T> {

    // An integer representing the capacity of the queue
    private int capacity;

    // A linked list that backs the FIFO queue implementation
    private LinkedList<T> backingLinkedList;

    /**
     * Class constructor.
     */
    public LinkedListBasedStack() {
        this(1);
    }

    /**
     * Class constructor.
     * 
     * @param capacity the capacity of the queue.
     */
    public LinkedListBasedStack(int capacity) {
        this.capacity = capacity;
        this.backingLinkedList = new SinglyLinkedList<>();
    }

    /**
     * Class constructor.
     * 
     * @param items an array of items to add to the queue.
     */
    public LinkedListBasedStack(T[] items) {
        this.capacity = items.length;

        this.backingLinkedList = new SinglyLinkedList<>(items);
    }

    /**
     * Class constructor.
     * 
     * @param items a collection of items to add to the queue.
     */
    public LinkedListBasedStack(Collection<T> items) {
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
        return this.size() >= this.getCapacity();
    }

    /**
     * {@inheritDoc}
     */
    public T peek() {
        return this.backingLinkedList.peekLast();
    }

    /**
     * {@inheritDoc}
     */
    public T pop() {
        if (!this.isEmpty()) {
            return this.backingLinkedList.pollLast();
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean push(T item) {
        if (!this.isFull()) {
            this.backingLinkedList.add(item);

            return true;
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    public void pushAll(T[] items) {
        this.backingLinkedList.addAll(items);
    }

    /**
     * {@inheritDoc}
     */
    public void pushAll(Collection<? extends T> items) {
        this.backingLinkedList.addAll(items);
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return this.backingLinkedList.size();
    }

}
