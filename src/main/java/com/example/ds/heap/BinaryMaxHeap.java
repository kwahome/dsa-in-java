package com.example.ds.heap;

import java.util.Collection;

public class BinaryMaxHeap<T extends Comparable<T>> extends BinaryHeap<T> {

    /**
     * Class constructor.
     * 
     */
    public BinaryMaxHeap() {
        super();
    }

    /**
     * Class constructor.
     * 
     * @param capacity an integer representing the capacity of the heap.
     */
    public BinaryMaxHeap(int capacity) {
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
    public BinaryMaxHeap(T[] items) {

        super(items);
    }

    /**
     * Construct a heap given a collection of items that should be inserted.
     * 
     * It uses heapify in O(n) time.
     * 
     * @param items a collection of T items.
     */
    public BinaryMaxHeap(Collection<T> items) {

        super(items);
    }

    @Override
    protected void heapifyDown(int position) {

        while (this.hasLeftChild(position)) {
            int leftChildIndex = this.getIndexOfLeftChild(position);
            int rightChildIndex = this.getIndexOfRightChild(position);
            int smallestChildIndex = leftChildIndex;

            if (this.hasRightChild(position)
                    && this.greaterThan(this.getItemAt(rightChildIndex), this.getItemAt(leftChildIndex))) {
                smallestChildIndex = rightChildIndex;
            }

            if (this.lessThan(this.getItemAt(position), this.getItemAt(smallestChildIndex))) {
                this.swap(smallestChildIndex, position);
            } else {
                break;
            }

            position = smallestChildIndex;
        }
    }

    @Override
    protected void heapifyUp(int position) {
        int parent = this.getIndexOfParent(position);

        while (position > 0 && this.greaterThan(this.getItemAt(position), this.getItemAt(parent))) {
            swap(parent, position);

            position = parent;

            parent = (position - 1) / 2;
        }
    }
}
