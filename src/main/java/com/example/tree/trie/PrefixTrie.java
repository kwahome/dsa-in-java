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

        TrieNode root = this.getRoot();

        if (key != null && !root.isEmpty()) {

            // We want to mark where to start the delete
            TrieNode deleteBelow = null;
            int deleteIndex = -1;
            boolean deleteChildren = false;

            for (int position = 0; position < key.length(); position++) {

                char charAtPosition = key.charAt(position);

                int index = charAtPosition - this.configuration.getFirstAlphabetCharacter();

                TrieNode charNode = root.getChildAt(index);

                if (charNode == null) {
                    // key not in trie
                    return false;
                }

                // Check whether the current root node is a prefix for more than one word
                if (root.getChildrenCount() > 1) {
                    // We are at the least common ancestor between our delete key
                    // and other words in the trie.
                    // We want to mark this shared char as the point to delete
                    // chars that make up our word if they have no other prefix
                    // associated with them.
                    deleteBelow = root;
                    deleteIndex = index;
                    deleteChildren = true;
                }

                // Then check whether our last character while not a prefix for more than one
                // other words, is a prefix for one word that continues after it.
                if (position == key.length() - 1 && charNode.getChildrenCount() > 0) {
                    // We are at the last char in the delete key and the node associated
                    // with this char has more children that form prefixes for other words,
                    // thus they cannot be deleted but rather we can unmark our delete key
                    // as a word in the trie
                    deleteBelow = charNode;
                    deleteIndex = index;
                    deleteChildren = false;
                }

                root = charNode;
            }

            if (!root.isWord()) {
                // word isn't in trie
                return false;
            }

            if (deleteBelow == null) {
                // there was only one word in the trie
                // We are deleting the entire trie
                this.initialize();

                return true;
            }

            if (deleteChildren) {
                deleteBelow.getChildren()[deleteIndex] = null;

            } else {
                deleteBelow.setWord(false);
            }

            return true;
        }

        return false;
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
