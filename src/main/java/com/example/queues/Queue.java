package com.example.queues;

import java.util.Collection;

/**
 * Queue interface.
 */
public interface Queue<T> {

    /**
     * Removes every item in the queue.
     * 
     */
    void clear();

    /**
     * Check whether an item is contained in the queue.
     * 
     * @return boolean
     */
    boolean contains(T item);

    /**
     * 
     * Remove the item at the top of the queue.
     * 
     * @return T
     */
    T dequeue();

    /**
     * Insert a non-null item to the queue.
     * 
     */
    void enqueue(T item);

    /**
     * Insert a non-null array of items to the queue.
     * 
     */
    void enqueue(T[] items);

    /**
     * Insert a non-null collection of items to the queue.
     * 
     */
    void enqueue(Collection<T> items);

    /**
     * Gets the capacity of the queue.
     * 
     * @return int
     */
    int getCapacity();

    /**
     * Return the item at the given position in the queue
     * if the position is valid otherwise return null.
     * 
     * @return T
     */
    T getItemAt(int position);

    /**
     * Check whether the queue has at least one item or not.
     * 
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Return the value of the item at the top of the queue
     * or null if empty.
     * 
     * @return T
     */
    T peek();

    /**
     * Remove an item from the queue.
     * 
     * @return boolean
     */
    boolean remove(T item);

    /**
     * Remove an item from a given position in the queue.
     * 
     * @return T
     */
    T removeAt(int position);

    /**
     * Return the number of items in the queue.
     * 
     * @return int
     */
    int size();
}
