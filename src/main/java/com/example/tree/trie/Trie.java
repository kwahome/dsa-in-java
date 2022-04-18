package com.example.tree.trie;

/**
 * Trie interface.
 */
public interface Trie {

    /**
     * Returns if the word is in the trie.
     * 
     * @param key string
     * @return boolean.
     */
    boolean contains(String key);

    /**
     * Returns if the prefix is in the trie.
     * 
     * @param prefix string
     * @return boolean.
     */
    boolean containsPrefix(String prefix);

    /**
     * Returns a boolean indicating whether the trie is empty.
     * 
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Insert a word into the trie.
     * 
     * When we insert a character(part of a key) into a trie,
     * we start from the root node and then search for a reference,
     * which corresponds to the first key character of the string
     * whose character we are trying to insert in the trie.
     * Two scenarios are possible:
     * 
     * 1. A reference exists, if, so then we traverse down the
     * tree following the reference to the next children level.
     * 
     * 2. A reference does not exist, then we create a new node
     * and refer it with parents reference matching the current
     * key character. We repeat this step until we get to the
     * last character of the key, then we mark the current node
     * as an end node and the algorithm finishes.
     * 
     * @param key string
     */
    void insert(String key);

    /**
     * Returns the root of the Trie.
     * 
     * @return TrieNode
     */
    TrieNode getRoot();

    /**
     * Remove a word from the trie.
     * 
     * @param key string
     * @return boolean
     */
    boolean remove(String key);

    /**
     * Returns a TrieNode containing a specified key.
     * 
     * @param key string
     * @return TrieNode.
     */
    TrieNode search(String key);

    /**
     * Returns the TrieNode containing a specified prefix.
     * 
     * @param prefix string
     * @return TrieNode
     */
    TrieNode searchPrefix(String prefix);
}
