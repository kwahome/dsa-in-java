package com.example.tree.trie;

/**
 * Configuration for an English language prefix trie.
 * 
 */
public class PrefixTrieConfiguration {

    // The size of the alphabet
    private int alphabetSize;

    // The language code
    private String languageCode;

    // The first character in the alphabet
    private char firstAlphabetChar;

    public PrefixTrieConfiguration(int alphabetSize, String languageCode, char firstAlphabetChar) {
        this.alphabetSize = alphabetSize;
        this.languageCode = languageCode;
        this.firstAlphabetChar = firstAlphabetChar;
    }

    /**
     * Gets the size of the alphabet in use.
     * 
     * @return int
     */
    public int getAlphabetSize() {
        return this.alphabetSize;
    }

    /**
     * Gets the ISO language code of the target language.
     * 
     * @return string
     */
    public String getLanguageCode() {
        return this.languageCode;
    }

    /**
     * Gets the first char of the alphabet in use.
     * 
     * @return char
     */
    public char getFirstAlphabetCharacter() {
        return this.firstAlphabetChar;
    }

}
