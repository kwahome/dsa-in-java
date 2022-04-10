package com.example.linkedlist;

/**
 * A linked list node.
 */
public class LinkedListNode<T> {

    private T data;
    private LinkedListNode<T> next;

    /**
     * Constructor to create a new linked list node.
     * 
     * @param data T
     * @param next LinkedListNode<T>
     */
    public LinkedListNode(T data, LinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Gets the data held by a linked list node.
     * 
     * @return T
     */
    public T getNodeData() {
        return this.data;
    }

    /**
     * Gets the next node pointed to by a linked list node.
     * 
     * @return T
     */
    public LinkedListNode<T> getNextNode() {
        return this.next;
    }

    /**
     * Sets the next node pointed to by a linked list node.
     * 
     * @return T
     */
    public void setNextNode(LinkedListNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        if (this.getNodeData() != null) {
            return this.getNodeData() + " + " + this.getNextNode().toString();
        }

        return "";
    }
}
