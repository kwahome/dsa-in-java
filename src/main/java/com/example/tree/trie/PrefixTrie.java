package com.example.tree.trie;

/**
 * Prefix trie implementation.
 */
public class PrefixTrie implements Trie {

    // Root of the trie
    private TrieNode root;

    // The trie configuration
    private PrefixTrieConfiguration configuration;

    /**
     * Constructor
     */
    public PrefixTrie(PrefixTrieConfiguration configuration) {
        this.configuration = configuration;
        this.initialize();
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(String key) {
        return this.search(key) != null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean containsPrefix(String prefix) {
        return this.searchPrefix(prefix) != null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return this.getRoot() != null ? this.getRoot().isEmpty() : true;
    }

    /**
     * {@inheritDoc}
     */
    public void insert(String key) {

        if (this.isEmpty()) {
            this.initialize();
        }

        TrieNode current = this.getRoot();

        // Iterate over each character in the string
        // An alternative is to convert the string into
        // a char array and iterate each char
        for (int position = 0; position < key.length(); position++) {

            int index = key.charAt(position) - this.configuration.getFirstAlphabetCharacter();

            if (current.getChildAt(index) == null) {
                current.setChildAt(index, new TrieNode(this.configuration.getAlphabetSize()));
            }

            current = current.getChildAt(index);
        }

        current.setWord(true);
    }

    /**
     * Gets the root of the trie.
     * 
     * @return TrieNode
     */
    public TrieNode getRoot() {
        return this.root;
    }

    /**
     * {@inheritDoc}
     */
    public boolean remove(String key) {

        boolean deleted = false;

        TrieNode current = this.getRoot();

        if (key != null && !current.isEmpty()) {

            // We want to mark where to start the delete
            TrieNode deleteBelow = null;
            int deleteIndex = -1;

            for (int position = 0; position < key.length(); position++) {

                int index = key.charAt(position) - this.configuration.getFirstAlphabetCharacter();

                TrieNode next = current.getChildAt(index);

                if (next == null) {
                    // key not in trie
                    deleted = false;

                    break;
                }

                if (current.getChildrenCount() > 1) {
                    // a node with more than one child has paths
                    // to more words so we cannot wholesome
                    // delete it but we can delete below it
                    // on the index of the char we are looking at
                    deleteBelow = current;
                    deleteIndex = index;
                }

                current = next;
            }

            if (!current.isWord()) {
                // word isn't in trie
                deleted = false;
            }

            if (deleteBelow == null) {
                // there was only one word in the trie
                // We are deleting the entire trie
                this.initialize();

                deleted = true;
            } else {
                deleteBelow.getChildren()[deleteIndex] = null;

                deleted = true;
            }
        }

        return deleted;
    }

    /**
     * {@inheritDoc}
     */
    public TrieNode search(String key) {

        TrieNode current = this.getRoot();

        if (current != null) {
            // Iterate over each character in the string
            // An alternative is to convert the string into
            // a char array and iterate each char
            for (int position = 0; position < key.length(); position++) {

                int index = key.charAt(position) - this.configuration.getFirstAlphabetCharacter();

                if (current.getChildAt(index) == null) {
                    return null;
                }

                current = current.getChildAt(index);
            }
        }

        return current != null && current.isWord() ? current : null;
    }

    /**
     * {@inheritDoc}
     */
    public TrieNode searchPrefix(String prefix) {
        TrieNode current = this.getRoot();

        if (current != null) {
            // Iterate over each character in the string
            // An alternative is to convert the string into
            // a char array and iterate each char
            for (int position = 0; position < prefix.length(); position++) {

                int index = prefix.charAt(position) - this.configuration.getFirstAlphabetCharacter();

                if (current.getChildAt(index) == null) {
                    return null;
                }

                current = current.getChildAt(index);
            }
        }

        return current;
    }

    private void initialize() {
        this.root = new TrieNode(this.configuration.getAlphabetSize());
    }
}
