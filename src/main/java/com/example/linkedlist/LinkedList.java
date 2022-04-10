package com.example.linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * LinkedList interface.
 */
public interface LinkedList<T> extends Iterable<T> {

    /**
     * Appends an item at the end of a list.
     * 
     * @param item
     */
    void add(T item);

    /**
     * Insert an item at the given position in a list.
     * 
     * @param index
     * @param item
     */
    void add(int index, T item);

    /**
     * Append all of the elements in the specified collection to the end of this
     * list, in the order that they are returned by the specified collection's
     * iterator.
     *
     * @param collection
     */
    void addAll(Collection<? extends T> collection);

    /**
     * Append all the items in the specified array.
     * 
     * @param items
     */
    void addAll(T[] items);

    /**
     * Append all the elements in the specified collection, starting at the
     * specified position of the list.
     *
     * @param index
     * @param collection
     */
    void addAll(int index, Collection<? extends T> collection);

    /**
     * Append all the elements in the specified array, starting at the
     * specified position of the list.
     *
     * @param index
     * @param collection
     */
    void addAll(int index, T[] items);

    /**
     * Insert an item at the beginning of a list.
     */
    void addFirst(T item);

    /**
     * Insert all the elements in the specified collection, starting at the
     * specified position of the list.
     */
    void addFirst(Collection<? extends T> collection);

    /**
     * Insert all the elements in the specified array, starting at the
     * specified position of the list.
     */
    void addFirst(T[] items);

    /**
     * Append an item at the end of a list.
     * 
     * @param item
     */
    void addLast(T item);

    /**
     * Append all the elements in the specified collection at the end of a list.
     * 
     * @param item
     */
    void addLast(Collection<? extends T> collection);

    /**
     * Append all the elements in the specified array at the end of a list.
     * 
     * @param item
     */
    void addLast(T[] item);

    /**
     * Check whether an item is contained in the linked list.
     * 
     * This is an O(n) operation.
     * 
     * @return boolean
     */
    boolean contains(T item);

    /**
     * Return an iterator over the elements in a deque in reverse sequential order.
     * 
     * @return
     */
    Iterator<T> descendingIterator();

    /**
     * Return the item at the specified position in a list.
     * 
     * @param index
     * @return T
     */
    T get(int index);

    /**
     * Return the first item in the list.
     * 
     * @return T
     */
    T getFirst();

    /**
     * Return the head of the list.
     * 
     * @return LinkedListNode<T>
     */
    LinkedListNode<T> getHead();

    /**
     * Return the last item in the list.
     * 
     * @return T
     */
    T getLast();

    /**
     * Return the node at a specified position in the list.
     * 
     * @return LinkedListNode<T>
     */
    LinkedListNode<T> getNode(int index);

    /**
     * Return the tail of the list.
     * 
     * @return LinkedListNode<T>
     */
    LinkedListNode<T> getTail();

    /**
     * Return the index in a list of the first occurrence of the specified element,
     * or -1 if the list does not contain any element.
     * 
     * @param item
     * @return
     */
    int indexOf(T item);

    /**
     * Inserts an item after a given key.
     * 
     * @param key
     * @param toInsert
     */
    void insertAfter(T key, T toInsert);

    /**
     * Inserts an item before a given key.
     * 
     * @param key
     * @param toInsert
     */
    void insertBefore(T key, T toInsert);

    /**
     * Check whether the linked list has at least one item or not.
     * 
     * This is an O(1) operation.
     * 
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Return the index in a list of the last occurrence of the specified element,
     * or -1 if the list does not contain any element.
     * 
     * @param item
     * @return
     */
    int lastIndexOf(T item);

    /**
     * Return a list-iterator of the elements in proper sequence,
     * starting at the specified position in the list.
     * 
     * @param index
     * @return
     */
    ListIterator<T> listIterator(int index);

    /**
     * Return the first item in the linked list.
     * 
     * @return T
     */
    T peek();

    /**
     * Return the first item in the linked list.
     * 
     * @return T
     */
    T peekFirst();

    /**
     * Return the last item in the linked list.
     * 
     * @return T
     */
    T peekLast();

    /**
     * 
     * Remove and return the first item in the linked list.
     * 
     * @return T
     */
    T poll();

    /**
     * 
     * Remove and return the first item in the linked list.
     * 
     * @return T
     */
    T pollFirst();

    /**
     * 
     * Remove and return the last item in the linked list.
     * 
     * @return T
     */
    T pollLast();

    /**
     * Remove the first item from the linked list.
     * 
     * @return T
     */
    T remove();

    /**
     * Remove the first occurrence of an item from the linked list.
     * 
     * @return boolean
     */
    boolean remove(T item);

    /**
     * Remove the first item from the linked list.
     * 
     */
    T removeFirst();

    /**
     * Remove the last item from the linked list.
     * 
     */
    T removeLast();

    /**
     * Return the number of items in the queue.
     * 
     * @return int
     */
    int size();
}
