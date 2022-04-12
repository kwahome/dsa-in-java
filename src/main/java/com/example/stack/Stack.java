package com.example.stack;

import java.util.Collection;

/**
 * Stack interface.
 */
public interface Stack<T> {

    /**
     * Removes every item in the queue.
     * 
     */
    void clear();

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
     * Remove and return the item at the top of the stack.
     * 
     * @return T
     */
    T pop();

    /**
     * Add an item to the top of the stack.
     * 
     * @param item T
     * @return boolean
     */
    boolean push(T item);

    /**
     * Add all items to the top of the stack.
     * 
     * @param items an array of T items
     */
    void pushAll(T[] items);

    /**
     * Add all items to the top of the stack.
     * 
     * @param items a collection of T items
     */
    void pushAll(Collection<? extends T> items);

    /**
     * Return the number of items in the queue.
     * 
     * @return int
     */
    int size();

}
