package com.example.queues.priorityqueue;

import java.util.Collection;

/**
 * PriorityQueue interface.
 */
public interface PriorityQueue<T extends Comparable<T>> {

    /**
     * Removes every item in the priority queue.
     * 
     * This is an O(n) operation.
     */
    void clear();

    /**
     * Check whether an item is contained in the priority queue.
     * 
     * This is an O(n) operation.
     * 
     * @return boolean
     */
    boolean contains(T item);

    /**
     * 
     * Remove the item at the top of the priority queue.
     *
     * This is an O(log(n)) operation because the priority queue
     * needs to be reorganized to maintain the order.
     * 
     * @return T
     */
    T dequeue();

    /**
     * Gets the capacity of the priority queue.
     * 
     * @return int
     */
    int getCapacity();

    /**
     * Return the item at the given position in the priority queue
     * if the position is valid otherwise return null.
     * 
     * This is an O(1) operation.
     * 
     * @return T
     */
    T getItemAt(int position);

    /**
     * Return the number of items in the priority queue.
     * 
     * This is an O(1) because the number of items in the
     * priority can be calculated as the offset of memory
     * locations of the array that backs the priority queue.
     * 
     * If a linked list is used, it becomes an O(n) operation.
     * 
     * @return int
     */
    int size();

    /**
     * Insert a non-null item to the priority queue.
     *
     * This is an O(log(n)) operation.
     */
    void enqueue(T item);

    /**
     * Insert a non-null array of items to the priority queue.
     * 
     * This is an O(log(n)) operation.
     */
    void enqueue(T[] items);

    /**
     * Insert a non-null collection of items to the priority queue.
     * 
     * This is an O(log(n)) operation.
     */
    void enqueue(Collection<T> items);

    /**
     * Check whether the priority queue has at least one item or not.
     * 
     * This is an O(1) operation.
     * 
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Return the value of the item at the root of the priority queue
     * or null if empty.
     * 
     * This is an O(1) operation.
     * 
     * @return T
     */
    T peek();

    /**
     * Remove an item from the priority queue.
     * 
     * This is an O(log(n)) operation because the priority queue
     * needs to be reorganized to maintain the order.
     * 
     * @return boolean
     */
    boolean remove(T item);

    /**
     * Remove an item from a given position in the priority queue.
     * 
     * This is an O(log(n)) operation because the priority queue
     * needs to be reorganized to maintain the order.
     * 
     * @return T
     */
    T removeAt(int position);
}
