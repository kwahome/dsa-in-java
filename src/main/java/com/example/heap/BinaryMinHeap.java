package com.example.heap;

import java.util.Collection;

/**
 * Implementation of the binary min heap.
 */
public class BinaryMinHeap<T extends Comparable<T>> extends BinaryHeap<T> {

    /**
     * Class constructor.
     * 
     */
    public BinaryMinHeap() {
        super();
    }

    /**
     * Class constructor.
     * 
     * @param capacity an integer representing the capacity of the heap.
     */
    public BinaryMinHeap(int capacity) {
        super(capacity);
    }

    /**
     * Construct a heap given an array items that should be inserted.
     * 
     * It uses heapify in O(n) time, a great explanation.
     * 
     * http://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
     * 
     * @param items an array of T items.
     */
    public BinaryMinHeap(T[] items) {

        super(items);
    }

    /**
     * Construct a heap given a collection of items that should be inserted.
     * 
     * It uses heapify in O(n) time.
     * 
     * @param items a collection of T items.
     */
    public BinaryMinHeap(Collection<T> items) {

        super(items);
    }

    @Override
    protected void heapifyDown(int position) {

        while (this.hasLeftChild(position)) {
            // while there is a left child
            int leftChildIndex = this.getIndexOfLeftChild(position);
            int rightChildIndex = this.getIndexOfRightChild(position);
            int smallestChildIndex = leftChildIndex;

            if (this.hasRightChild(position)
                    && this.lessThan(this.getItemAt(rightChildIndex), this.getItemAt(leftChildIndex))) {
                // if the right child exists and is less than the left child,
                // the smallest child is the right child
                smallestChildIndex = rightChildIndex;
            }

            if (this.greaterThan(this.getItemAt(position), this.getItemAt(smallestChildIndex))) {
                // if the smallest child is less than the current item
                // swap them
                this.swap(smallestChildIndex, position);
            } else {
                break;
            }

            // set the current position to the smallest child index
            position = smallestChildIndex;
        }
    }

    @Override
    protected void heapifyUp(int position) {
        int parentIndex = this.getIndexOfParent(position);

        while (position > 0 && this.lessThan(this.getItemAt(position), this.getItemAt(parentIndex))) {
            // while there current position is greater than 0
            // and item at the current position is less than its parent, swap
            this.swap(parentIndex, position);

            // set the current position to the parent index
            position = parentIndex;

            // calculate the new parent index
            parentIndex = (position - 1) / 2;
        }
    }
}
