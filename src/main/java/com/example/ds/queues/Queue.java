package com.example.ds.queues;

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
    boolean enqueue(T item);

    /**
     * Insert a non-null array of items to the queue.
     * 
     */
    boolean enqueue(T[] items);

    /**
     * Insert a non-null collection of items to the queue.
     * 
     */
    boolean enqueue(Collection<T> items);

    /**
     * Increases the capacity of a queue by the specified unit.
     * 
     */
    boolean expandCapacity(int additionalCapacity);

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
     * Returns a boolean indicating whether the queue has capacity
     * for the number of items specified or not.
     * 
     */
    boolean hasCapacity(int numberOfItems);

    /**
     * Check whether the queue has at least one item or not.
     * 
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Check whether the queue has reached its capacity.
     * 
     * @return boolean
     */
    boolean isFull();

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
