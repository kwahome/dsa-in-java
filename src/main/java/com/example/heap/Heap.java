package com.example.heap;

/**
 * Heap interface.
 */
public interface Heap<T extends Comparable<T>> {

    /**
     * Removes every element in the heap.
     * 
     * This is an O(n) operation.
     */
    void clear();

    /**
     * Check whether an element is contained in the heap.
     * 
     * This is an O(n) operation.
     * 
     * @return boolean
     */
    boolean contains(T element);

    /**
     * Gets the capacity of the heap.
     * 
     * @return int
     */
    int getCapacity();

    /**
     * Return the item at the given position in the heap if the
     * position is a valid index on the backing array otherwise
     * return null.
     * 
     * This is an O(1) operation.
     * 
     * @return T
     */
    T getItemAt(int position);

    /**
     * Return the number of elements in the heap.
     * 
     * This is an O(1) because the number of elements in the
     * heap can be calculated as the offset of memory locations
     * of the array that backs the heap.
     * 
     * If a linked list is used, it becomes an O(n) operation.
     * 
     * @return int
     */
    int getNumberOfItems();

    /**
     * Insert a non-null element to the heap.
     * 
     * This is an O(log(n)) operation.
     */
    void insert(T element);

    /**
     * Check whether the heap has at least one element or not.
     * 
     * This is an O(1) operation.
     * 
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Return the value of the element at the root of the heap
     * or null if empty.
     * 
     * This is an O(1) operation.
     * 
     * @return T
     */
    T peek();

    /**
     * Remove the element at the root of the heap.
     * 
     * This is an O(log(n)) operation because the
     * heap needs to be reorganized to maintain the
     * heap invariant.
     * 
     * @return T
     */
    T poll();

    /**
     * Remove an element from the heap.
     * 
     * This is an O(log(n)) operation because the
     * heap needs to be reorganized to maintain the
     * heap invariant.
     * 
     * @return boolean
     */
    boolean remove(T element);

    /**
     * Remove an element from a given position in the heap.
     * 
     * This is an O(log(n)) operation because the
     * heap needs to be reorganized to maintain the
     * heap invariant.
     * 
     * @return T
     */
    T removeAt(int position);
}
