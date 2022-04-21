package com.example.ds.tree.trie;

/**
 * A Trie node.
 */
public class TrieNode {

    // An array of the trie node's children
    private TrieNode[] children;

    // Boolean indicating a valid word
    private boolean isEnd;

    /**
     * Constructor.
     */
    public TrieNode(int size) {
        this.isEnd = false;
        this.children = new TrieNode[size];
    }

    /**
     * Returns the children of the TrieNode.
     * 
     * @return TrieNode[]
     */
    public TrieNode[] getChildren() {
        return this.children;
    }

    /**
     * Returns the number of children of the TrieNode.
     * 
     * @return int
     */
    public int getChildrenCount() {
        int count = 0;

        for (TrieNode child : this.getChildren()) {
            if (child != null) {
                count++;
            }
        }

        return count;
    }

    /**
     * Returns the child at a specified index.
     * 
     * @return TrieNode
     */
    public TrieNode getChildAt(int index) throws IndexOutOfBoundsException {
        return this.getChildren()[index];
    }

    /**
     * Returns a boolean indicating whether the node is empty.
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        for (TrieNode child : this.getChildren()) {
            if (child != null) {
                return false;
            }
        }

        return true;
    }

    /**
     * Gets a boolean indicating end of a word.
     * 
     * @return boolean
     */
    public boolean isWord() {
        return this.isEnd;
    }

    /**
     * Returns the children of the TrieNode.
     * 
     * @param TrieNode[]
     */
    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    /**
     * Sets the child into a specified index.
     * 
     * @return boolean
     */
    public boolean setChildAt(int index, TrieNode child) throws IndexOutOfBoundsException {
        this.getChildren()[index] = child;

        return true;
    }

    /**
     * Sets a boolean indicating end of a word.
     * 
     * @param flag
     */
    public void setWord(boolean flag) {
        this.isEnd = flag;
    }
}
