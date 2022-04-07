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
     * Construct a heap given an array elements that should be inserted.
     * 
     * It uses heapify in O(n) time, a great explanation.
     * 
     * http://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
     * 
     * @param capacity an integer representing the capacity of the heap.
     */
    public BinaryMinHeap(T[] elements) {

        super(elements);
    }

    /**
     * Construct a heap given a collectoin of elements that should be inserted.
     * 
     * It uses heapify in O(n) time.
     * 
     * @param capacity an integer representing the capacity of the heap.
     */
    public BinaryMinHeap(Collection<T> elements) {

        super(elements);
    }

    @Override
    protected void heapifyDown(int position) {

        while (this.hasLeftChild(position)) {
            int leftChildIndex = this.getIndexOfLeftChild(position);
            int rightChildIndex = this.getIndexOfRightChild(position);
            int smallestChildIndex = leftChildIndex;

            if (this.hasRightChild(position)
                    && this.lessThan(this.getItemAt(rightChildIndex), this.getItemAt(leftChildIndex))) {
                smallestChildIndex = rightChildIndex;
            }

            if (this.greaterThan(this.getItemAt(position), this.getItemAt(smallestChildIndex))) {
                this.swap(smallestChildIndex, position);
            } else {
                break;
            }

            position = smallestChildIndex;
        }
    }

    @Override
    protected void heapifyUp(int position) {
        int parentIndex = this.getIndexOfParent(position);

        while (position > 0 && this.lessThan(this.getItemAt(position), this.getItemAt(parentIndex))) {
            this.swap(parentIndex, position);

            position = parentIndex;

            parentIndex = (position - 1) / 2;
        }
    }
}
