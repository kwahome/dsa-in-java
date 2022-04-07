package com.example.heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Abstract class for the Heap implementation.
 */
public abstract class BinaryHeap<T extends Comparable<T>> implements Heap<T> {

    // A dynamic list to track the elements inside the heap
    private List<T> heapBackingList = null;

    // An integer representing the capacity of the heap.
    private int capacity;

    /**
     * Class constructor.
     * 
     */
    public BinaryHeap() {
        this(1);
    }

    /**
     * Class constructor.
     * 
     * @param capacity an integer representing the capacity of the heap.
     */
    public BinaryHeap(int capacity) {
        this.heapBackingList = new ArrayList<>(capacity);
        this.capacity = capacity;
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
    public BinaryHeap(T[] elements) {

        this.capacity = elements.length;

        this.heapBackingList = new ArrayList<T>(this.capacity);

        // Place all element in the backing list
        for (int i = 0; i < this.capacity; i++) {
            this.heapBackingList.add(elements[i]);
        }

        // Heapify process, O(n)
        for (int i = Math.max(0, (this.capacity / 2) - 1); i >= 0; i--) {
            this.heapifyDown(i);
        }
    }

    /**
     * Construct a heap given a collectoin of elements that should be inserted.
     * 
     * It uses heapify in O(n) time.
     * 
     * @param capacity an integer representing the capacity of the heap.
     */
    public BinaryHeap(Collection<T> elements) {

        this.capacity = elements.size();

        this.heapBackingList = new ArrayList<T>(this.capacity);

        // Add all elements of the given collection to the heap, O(n)
        this.heapBackingList.addAll(elements);

        // Heapify process, O(n)
        for (int i = Math.max(0, (this.capacity / 2) - 1); i >= 0; i--) {
            this.heapifyDown(i);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        this.heapBackingList.clear();
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(T element) {
        // Linear scan to check membership
        for (int i = 0; i < this.getNumberOfItems(); i++) {
            if (this.getItemAt(i).equals(element)) {
                return true;
            }
        }
        return false;
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
        return (position >= this.getNumberOfItems() || position < 0) ? null : this.heapBackingList.get(position);
    }

    /**
     * {@inheritDoc}
     */
    public void insert(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }

        this.heapBackingList.add(element);

        this.heapifyUp(this.getNumberOfItems() - 1);
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return this.getNumberOfItems() == 0;
    }

    /**
     * {@inheritDoc}
     */
    public T peek() {
        return (!this.isEmpty()) ? this.getItemAt(0) : null;
    }

    /**
     * {@inheritDoc}
     */
    public T poll() {
        return this.removeAt(0);
    }

    /**
     * {@inheritDoc}
     */
    public boolean remove(T element) {
        if (element == null) {
            return false;
        }

        // Linear removal via search, O(n)
        for (int i = 0; i < this.getNumberOfItems(); i++) {
            if (element.equals(this.getItemAt(i))) {
                this.removeAt(i);
                return true;
            }
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    public T removeAt(int position) {
        if (this.isEmpty()) {
            return null;
        }

        T removed = this.getItemAt(position);

        int indexOfLastElement = this.getNumberOfItems() - 1;

        this.swap(position, indexOfLastElement);

        // Remove the swapped item at last postion from the backing
        this.heapBackingList.remove(indexOfLastElement);

        // Check if the last element was removed
        if (position == indexOfLastElement) {
            return removed;
        }

        // heapify
        this.heapifyDown(position);

        if (this.getItemAt(position).equals(this.getItemAt(position))) {
            this.heapifyUp(position);
        }

        return removed;
    }

    /**
     * {@inheritDoc}
     */
    public int getNumberOfItems() {
        return this.heapBackingList.size();
    }

    protected abstract void heapifyDown(int position);

    protected abstract void heapifyUp(int position);

    protected int getIndexOfLeftChild(int position) {
        return (2 * position) + 1;
    }

    protected int getIndexOfRightChild(int position) {
        return (2 * position) + 2;
    }

    // Returning the position of
    // the parent for the node currently at position
    protected int getIndexOfParent(int position) {
        return position / 2;
    }

    // Tests if the value of a < b
    protected boolean greaterThan(T a, T b) {
        return a.compareTo(b) > 0;
    }

    // Tests if the value of a <= b
    protected boolean greaterThanOrEqual(T a, T b) {
        return a.compareTo(b) >= 0;
    }

    protected boolean hasLeftChild(int index) {
        return this.getIndexOfLeftChild(index) < this.getNumberOfItems();
    }

    protected boolean hasRightChild(int index) {
        return this.getIndexOfRightChild(index) < this.getNumberOfItems();
    }

    // Returning true if the passed
    // node is a leaf node
    protected boolean isLeaf(int position) {

        if (position > (this.getNumberOfItems() / 2) && position <= this.getNumberOfItems()) {
            return true;
        }

        return false;
    }

    // Tests if the value of a < b
    protected boolean lessThan(T a, T b) {
        return a.compareTo(b) < 0;
    }

    // Tests if the value of a <= b
    protected boolean lessThanOrEqual(T a, T b) {
        return a.compareTo(b) <= 0;
    }

    protected void swap(int i, int j) {
        T elementAtI = heapBackingList.get(i);

        this.heapBackingList.set(i, heapBackingList.get(j));
        this.heapBackingList.set(j, elementAtI);
    }

    @Override
    public String toString() {
        return this.heapBackingList.toString();
    }
}
