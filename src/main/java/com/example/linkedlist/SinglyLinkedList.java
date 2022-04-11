package com.example.linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Singly linked list implementation of a LinkedList<T>.
 */
public class SinglyLinkedList<T> implements LinkedList<T> {

    // The head of the linked list.
    private LinkedListNode<T> head;

    // The tail of the linked list.
    private LinkedListNode<T> tail;

    // The number of items in the list.
    private int numberOfItems;

    /**
     * Class constructor.
     */
    public SinglyLinkedList() {
        this.initialize();
    }

    /**
     * Class constructor.
     */
    public SinglyLinkedList(T[] items) {

        this();

        this.addAll(items);
    }

    /**
     * Class constructor.
     */
    public SinglyLinkedList(Collection<T> items) {

        this();

        this.addAll(items);
    }

    /**
     * {@inheritDoc}
     */
    public void add(T item) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(item, null);

        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            this.getTail().setNextNode(newNode);
        }

        this.tail = newNode;

        this.numberOfItems++;
    }

    /**
     * {@inheritDoc}
     */
    public void add(int index, T item) {
        if (this.isEmpty() || index > this.size()) {
            // the list is empty or the given index is beyond the next valid index

            // this.add(item);

            throw new IndexOutOfBoundsException("Index is out of bounds");

        }

        LinkedListNode<T> current = this.getHead();
        LinkedListNode<T> targetNode = null;

        int counter = 0;

        while (counter < index) {
            targetNode = current;
            current = current.getNextNode();
            counter++;
        }

        if (targetNode == null) {
            // We are inserting at the first position
            this.addFirst(item);
        } else {
            LinkedListNode<T> newNode = new LinkedListNode<T>(item, targetNode.getNextNode());

            targetNode.setNextNode(newNode);

            if (newNode.getNextNode() == null || index == this.numberOfItems) {
                this.tail = newNode;
            }

            this.numberOfItems++;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void addAll(Collection<? extends T> collection) {
        for (T item : collection) {
            this.add(item);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void addAll(T[] items) {
        for (T item : items) {
            this.add(item);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void addAll(int index, Collection<? extends T> collection) {
        if (this.isEmpty() || index > this.size()) {
            // the list is empty or the given index is beyond the next valid index

            // this.add(item);

            throw new IndexOutOfBoundsException("Index is out of bounds");

        }

        LinkedListNode<T> current = this.getHead();
        LinkedListNode<T> targetNode = null;

        int counter = 0;

        while (counter < index) {
            targetNode = current;
            current = current.getNextNode();
            counter++;
        }

        if (targetNode == null) {
            this.addFirst(collection);
        } else {
            for (T item : collection) {
                LinkedListNode<T> newNode = new LinkedListNode<T>(item, targetNode.getNextNode());

                targetNode.setNextNode(newNode);

                targetNode = newNode;

                this.numberOfItems++;
            }

            if (targetNode != null && targetNode.getNextNode() == null) {
                this.tail = targetNode;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void addAll(int index, T[] items) {
        if (this.isEmpty() || index > this.size()) {
            // the list is empty or the given index is beyond the next valid index

            // this.add(item);

            throw new IndexOutOfBoundsException("Index is out of bounds");

        }

        LinkedListNode<T> current = this.getHead();
        LinkedListNode<T> targetNode = null;

        int counter = 0;

        while (counter < index) {
            targetNode = current;
            current = current.getNextNode();
            counter++;
        }

        if (targetNode == null) {
            this.addFirst(items);
        } else {
            for (T item : items) {
                LinkedListNode<T> newNode = new LinkedListNode<T>(item, targetNode.getNextNode());

                targetNode.setNextNode(newNode);

                targetNode = newNode;

                this.numberOfItems++;
            }

            if (targetNode != null && targetNode.getNextNode() == null) {
                this.tail = targetNode;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void addFirst(T item) {
        this.head = new LinkedListNode<>(item, this.getHead());

        this.numberOfItems++;
    }

    /**
     * {@inheritDoc}
     */
    public void addFirst(Collection<? extends T> collection) {
        LinkedListNode<T> newHeadNode = null;
        LinkedListNode<T> previousNode = null;
        LinkedListNode<T> currentNewNode = null;

        for (T item : collection) {
            currentNewNode = new LinkedListNode<T>(item, null);

            if (previousNode != null) {
                previousNode.setNextNode(currentNewNode);
            }

            if (newHeadNode == null) {
                // our first node in the collection is the new head
                newHeadNode = currentNewNode;
            }

            previousNode = currentNewNode;

            this.numberOfItems++;
        }

        // point the last node in the collection to the previous head of the list
        currentNewNode.setNextNode(this.getHead());

        // set the new head
        this.head = newHeadNode;
    }

    /**
     * {@inheritDoc}
     */
    public void addFirst(T[] items) {
        LinkedListNode<T> newHeadNode = null;
        LinkedListNode<T> previousNode = null;
        LinkedListNode<T> currentNewNode = null;

        for (T item : items) {
            currentNewNode = new LinkedListNode<T>(item, null);

            if (previousNode != null) {
                previousNode.setNextNode(currentNewNode);
            }

            if (newHeadNode == null) {
                // our first node in the collection is the new head
                newHeadNode = currentNewNode;
            }

            previousNode = currentNewNode;

            this.numberOfItems++;
        }

        // point the last node in the collection to the previous head of the list
        currentNewNode.setNextNode(this.getHead());

        // set the new head
        this.head = newHeadNode;
    }

    /**
     * {@inheritDoc}
     */
    public void addLast(T item) {
        this.add(item);
    }

    /**
     * {@inheritDoc}
     */
    public void addLast(Collection<? extends T> collection) {
        this.addAll(collection);
    }

    /**
     * {@inheritDoc}
     */
    public void addLast(T[] item) {
        this.addAll(item);
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        this.initialize();
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(T item) {
        LinkedListNode<T> current = this.getHead();

        while (current != null) {
            if (current.getNodeData().equals(item)) {
                return true;
            }

            current = current.getNextNode();
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<T> descendingIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public T get(int index) {
        if (this.isEmpty() || index > this.size() || index < 0) {
            // the list is empty or the given index is beyond the next valid index

            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        LinkedListNode<T> node = this.getNode(index);

        return (node != null) ? node.getNodeData() : null;
    }

    /**
     * {@inheritDoc}
     */
    public T getFirst() {
        return (this.getHead() != null) ? this.getHead().getNodeData() : null;
    }

    /**
     * {@inheritDoc}
     */
    public LinkedListNode<T> getHead() {
        return this.head;
    }

    /**
     * {@inheritDoc}
     */
    public T getLast() {
        return (this.getTail() != null) ? this.getTail().getNodeData() : null;
    }

    /**
     * {@inheritDoc}
     */
    public LinkedListNode<T> getNode(int index) {
        if (this.isEmpty() || index > this.size() || index < 0) {
            // the list is empty or the given index is beyond the next valid index

            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        LinkedListNode<T> current = this.getHead();

        int indexCounter = 0;

        while (current != null && indexCounter <= index) {
            if (indexCounter == index) {
                return current;
            }

            current = current.getNextNode();

            indexCounter++;
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    public LinkedListNode<T> getTail() {
        return this.tail;
    }

    /**
     * {@inheritDoc}
     */
    public int indexOf(T item) {
        LinkedListNode<T> current = this.getHead();

        int indexCounter = 0;

        while (current != null && indexCounter < this.size()) {
            if (current.getNodeData().equals(item)) {
                return indexCounter;
            }

            current = current.getNextNode();

            indexCounter++;
        }

        return -1;
    }

    /**
     * {@inheritDoc}
     */
    public int lastIndexOf(T item) {
        LinkedListNode<T> current = this.getHead();

        int lastIndex = -1;

        int indexCounter = 0;

        while (current != null && indexCounter < this.size()) {
            if (current.getNodeData().equals(item)) {
                lastIndex = indexCounter;
            }

            current = current.getNextNode();

            indexCounter++;
        }

        return lastIndex;
    }

    /**
     * {@inheritDoc}
     */
    public void insertAfter(T key, T toInsert) {
        int indexOfKey = this.indexOf(key);

        if (indexOfKey == -1) {
            throw new IllegalArgumentException("The key='" + key + "' could not be found in the list.");
        }

        this.add(indexOfKey + 1, toInsert);
    }

    /**
     * {@inheritDoc}
     */
    public void insertBefore(T key, T toInsert) {
        int indexOfKey = this.indexOf(key);

        if (indexOfKey == -1) {
            throw new IllegalArgumentException("The key='" + key + "' could not be found in the list.");
        }

        // insert will move the item at the found index to the next position
        this.add(indexOfKey, toInsert);

    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return this.getHead() == null;
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            LinkedListNode<T> current = getHead();

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T data = current.getNodeData();
                    current = current.getNextNode();
                    return data;
                }

                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not implemented.");
            }

        };
    }

    /**
     * {@inheritDoc}
     */
    public ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public T peek() {
        return this.getFirst();
    }

    /**
     * {@inheritDoc}
     */
    public T peekFirst() {
        return this.peek();
    }

    /**
     * {@inheritDoc}
     */
    public T peekLast() {
        return this.getLast();
    }

    /**
     * {@inheritDoc}
     */
    public T poll() {
        return this.pollFirst();
    }

    /**
     * {@inheritDoc}
     */
    public T pollFirst() {
        return this.removeFirst();
    }

    /**
     * {@inheritDoc}
     */
    public T pollLast() {
        return this.removeLast();
    }

    /**
     * {@inheritDoc}
     */
    public T remove() {
        return this.removeFirst();
    }

    /**
     * {@inheritDoc}
     */
    public boolean remove(T item) {
        LinkedListNode<T> current = this.getHead();
        LinkedListNode<T> previous = null;

        // seek the item node and its preceding node
        while (current != null) {
            if (current.getNodeData().equals(item)) {
                break;
            }

            previous = current;
            current = current.getNextNode();
        }

        if (current != null) {
            if (current.equals(this.getHead()) || previous == null) {
                // we are removing the head node
                this.head = current.getNextNode();
            } else {
                previous.setNextNode(current.getNextNode());
            }

            if (current.equals(this.getTail()) || current.getNextNode() == null) {
                // this node is the tail node
                this.tail = previous;
            }

            // set to null so that its gc'ed
            current = null;

            this.numberOfItems--;

            return true;
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    public T removeAt(int index) {
        T item = this.get(index);

        LinkedListNode<T> current = this.getHead();
        LinkedListNode<T> previous = null;

        // seek the item node and its preceding node
        while (current != null) {
            if (current.getNodeData().equals(item)) {
                break;
            }

            previous = current;
            current = current.getNextNode();
        }

        if (current != null) {
            if (current.equals(this.getHead()) || previous == null) {
                // we are removing the head node
                this.head = current.getNextNode();
            } else {
                previous.setNextNode(current.getNextNode());
            }

            if (current.equals(this.getTail()) || current.getNextNode() == null) {
                // this node is the tail node
                this.tail = previous;
            }

            // set to null so that its gc'ed
            current = null;

            this.numberOfItems--;

            return item;
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }

        LinkedListNode<T> headNode = this.getHead();

        T data = (headNode == null) ? null : headNode.getNodeData();

        // decrease count by 1
        this.numberOfItems--;

        // set the head to the next node
        this.head = headNode.getNextNode();

        // set it to null so that is gc'ed
        headNode = null;

        return data;
    }

    /**
     * {@inheritDoc}
     */
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        LinkedListNode<T> tailNode = this.getTail();

        T data = (tailNode == null) ? null : tailNode.getNodeData();

        // decrease count by 1
        this.numberOfItems--;

        // set the tail to the previous node
        // as there are no back pointers, we'll need to iterate
        this.tail = this.getNode(Math.max(0, this.size() - 1));

        // if the tail equals the head
        // we have polled to the start of the list
        if (tailNode == this.getHead()) {
            this.head = null;
        }

        // set it to null so that is gc'ed
        tailNode = null;

        return data;
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return this.numberOfItems;
    }

    private void initialize() {
        this.head = null;
        this.tail = null;
        this.numberOfItems = 0;
    }
}
