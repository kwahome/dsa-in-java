package com.example.ds.tree.trie;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * PrefixTrie test class.
 */
public class PrefixTrieTest {

    private PrefixTrieConfiguration prefixTrieConfiguration;

    @Before
    public void setUp() {
        this.prefixTrieConfiguration = new PrefixTrieConfiguration(26, "en", 'a');
    }

    @Test
    public void shouldCreatePrefixTrie() {
        Trie prefixTrie = new PrefixTrie(this.prefixTrieConfiguration);

        Assert.assertNotNull(prefixTrie);
        Assert.assertTrue(prefixTrie.isEmpty());
        Assert.assertFalse(prefixTrie.contains("hello"));
        Assert.assertFalse(prefixTrie.containsPrefix("he"));
        Assert.assertFalse(prefixTrie.containsPrefix("ello"));

        Assert.assertNull(prefixTrie.search("hello"));
        Assert.assertNull(prefixTrie.searchPrefix("he"));
        Assert.assertNull(prefixTrie.searchPrefix("ello"));

        Assert.assertEquals(this.prefixTrieConfiguration.getAlphabetSize(), prefixTrie.getRoot().getChildren().length);
        Assert.assertFalse(prefixTrie.getRoot().isWord());
    }

    @Test
    public void shouldInsertAWord() {
        Trie prefixTrie = new PrefixTrie(this.prefixTrieConfiguration);

        Assert.assertNotNull(prefixTrie);
        Assert.assertTrue(prefixTrie.isEmpty());
        Assert.assertFalse(prefixTrie.contains("hello"));
        Assert.assertFalse(prefixTrie.containsPrefix("he"));
        Assert.assertFalse(prefixTrie.containsPrefix("ello"));

        Assert.assertNull(prefixTrie.search("hello"));
        Assert.assertNull(prefixTrie.searchPrefix("he"));
        Assert.assertNull(prefixTrie.searchPrefix("ello"));

        Assert.assertEquals(this.prefixTrieConfiguration.getAlphabetSize(), prefixTrie.getRoot().getChildren().length);
        Assert.assertFalse(prefixTrie.getRoot().isWord());

        prefixTrie.insert("hello");

        Assert.assertFalse(prefixTrie.isEmpty());
        Assert.assertTrue(prefixTrie.contains("hello"));
        Assert.assertTrue(prefixTrie.containsPrefix("he"));
        Assert.assertFalse(prefixTrie.containsPrefix("ello"));

        Assert.assertNotNull(prefixTrie.search("hello"));
        Assert.assertNotNull(prefixTrie.searchPrefix("he"));
        Assert.assertNull(prefixTrie.searchPrefix("ello"));
    }

    @Test
    public void shouldRemoveAWord() {
        Trie prefixTrie = new PrefixTrie(this.prefixTrieConfiguration);

        Assert.assertNotNull(prefixTrie);
        Assert.assertTrue(prefixTrie.isEmpty());
        Assert.assertFalse(prefixTrie.contains("hello"));
        Assert.assertFalse(prefixTrie.containsPrefix("he"));
        Assert.assertFalse(prefixTrie.containsPrefix("ello"));

        Assert.assertNull(prefixTrie.search("hello"));
        Assert.assertNull(prefixTrie.searchPrefix("he"));
        Assert.assertNull(prefixTrie.searchPrefix("ello"));

        Assert.assertEquals(this.prefixTrieConfiguration.getAlphabetSize(), prefixTrie.getRoot().getChildren().length);
        Assert.assertFalse(prefixTrie.getRoot().isWord());

        Assert.assertFalse(prefixTrie.remove(""));
        Assert.assertFalse(prefixTrie.remove(null));
        Assert.assertFalse(prefixTrie.remove("hello"));

        prefixTrie.insert("hello");

        Assert.assertFalse(prefixTrie.remove(""));
        Assert.assertFalse(prefixTrie.remove(null));
        Assert.assertFalse(prefixTrie.remove("pair"));

        Assert.assertFalse(prefixTrie.isEmpty());
        Assert.assertTrue(prefixTrie.contains("hello"));
        Assert.assertTrue(prefixTrie.containsPrefix("he"));
        Assert.assertFalse(prefixTrie.containsPrefix("ello"));
        Assert.assertNotNull(prefixTrie.search("hello"));
        Assert.assertNotNull(prefixTrie.searchPrefix("he"));
        Assert.assertNull(prefixTrie.searchPrefix("ello"));

        Assert.assertTrue(prefixTrie.remove("hello"));

        Assert.assertTrue(prefixTrie.isEmpty());
        Assert.assertFalse(prefixTrie.contains("hello"));
        Assert.assertFalse(prefixTrie.containsPrefix("he"));
        Assert.assertFalse(prefixTrie.containsPrefix("ello"));
        Assert.assertNull(prefixTrie.search("hello"));
        Assert.assertNull(prefixTrie.searchPrefix("he"));
        Assert.assertNull(prefixTrie.searchPrefix("ello"));

        Assert.assertFalse(prefixTrie.remove(""));
        Assert.assertFalse(prefixTrie.remove(null));
        Assert.assertFalse(prefixTrie.remove("hello"));

        prefixTrie.insert("paul");
        prefixTrie.insert("pair");

        Assert.assertFalse(prefixTrie.isEmpty());
        Assert.assertTrue(prefixTrie.contains("paul"));
        Assert.assertTrue(prefixTrie.contains("pair"));
        Assert.assertTrue(prefixTrie.containsPrefix("pa"));
        Assert.assertTrue(prefixTrie.containsPrefix("pau"));
        Assert.assertTrue(prefixTrie.containsPrefix("pai"));
        Assert.assertFalse(prefixTrie.contains("hello"));
        Assert.assertFalse(prefixTrie.containsPrefix("he"));
        Assert.assertFalse(prefixTrie.containsPrefix("ello"));

        Assert.assertTrue(prefixTrie.remove("pair"));

        Assert.assertFalse(prefixTrie.isEmpty());
        Assert.assertTrue(prefixTrie.contains("paul"));
        Assert.assertFalse(prefixTrie.contains("pair"));
        Assert.assertTrue(prefixTrie.containsPrefix("pa"));
        Assert.assertTrue(prefixTrie.containsPrefix("pau"));
        Assert.assertFalse(prefixTrie.containsPrefix("pai"));

        prefixTrie.insert("paul");
        prefixTrie.insert("pair");
        prefixTrie.insert("pairs");
        prefixTrie.insert("paid");
        prefixTrie.insert("pain");
        prefixTrie.insert("paint");
        prefixTrie.insert("pains");

        Assert.assertFalse(prefixTrie.isEmpty());
        Assert.assertTrue(prefixTrie.contains("paul"));
        Assert.assertTrue(prefixTrie.contains("pair"));
        Assert.assertTrue(prefixTrie.contains("pairs"));
        Assert.assertTrue(prefixTrie.contains("paid"));
        Assert.assertTrue(prefixTrie.contains("pain"));
        Assert.assertTrue(prefixTrie.contains("paint"));
        Assert.assertTrue(prefixTrie.contains("pains"));
        Assert.assertTrue(prefixTrie.containsPrefix("pa"));
        Assert.assertTrue(prefixTrie.containsPrefix("pau"));
        Assert.assertTrue(prefixTrie.containsPrefix("pai"));
        Assert.assertTrue(prefixTrie.containsPrefix("paul"));
        Assert.assertTrue(prefixTrie.containsPrefix("pair"));
        Assert.assertTrue(prefixTrie.containsPrefix("pairs"));
        Assert.assertTrue(prefixTrie.containsPrefix("paid"));
        Assert.assertTrue(prefixTrie.containsPrefix("pain"));
        Assert.assertTrue(prefixTrie.containsPrefix("paint"));
        Assert.assertTrue(prefixTrie.containsPrefix("pains"));

        Assert.assertTrue(prefixTrie.remove("pair"));

        Assert.assertFalse(prefixTrie.isEmpty());
        Assert.assertTrue(prefixTrie.contains("paul"));
        Assert.assertFalse(prefixTrie.contains("pair"));
        Assert.assertTrue(prefixTrie.contains("pairs"));
        Assert.assertTrue(prefixTrie.contains("paid"));
        Assert.assertTrue(prefixTrie.contains("pain"));
        Assert.assertTrue(prefixTrie.contains("paint"));
        Assert.assertTrue(prefixTrie.contains("pains"));
        Assert.assertTrue(prefixTrie.containsPrefix("pa"));
        Assert.assertTrue(prefixTrie.containsPrefix("pau"));
        Assert.assertTrue(prefixTrie.containsPrefix("pai"));
        Assert.assertTrue(prefixTrie.containsPrefix("paul"));
        Assert.assertTrue(prefixTrie.containsPrefix("pair"));
        Assert.assertTrue(prefixTrie.containsPrefix("pairs"));
        Assert.assertTrue(prefixTrie.containsPrefix("paid"));
        Assert.assertTrue(prefixTrie.containsPrefix("pain"));
        Assert.assertTrue(prefixTrie.containsPrefix("paint"));
        Assert.assertTrue(prefixTrie.containsPrefix("pains"));

        Assert.assertTrue(prefixTrie.remove("pain"));

        Assert.assertFalse(prefixTrie.isEmpty());
        Assert.assertTrue(prefixTrie.contains("paul"));
        Assert.assertFalse(prefixTrie.contains("pair"));
        Assert.assertFalse(prefixTrie.contains("pain"));
        Assert.assertTrue(prefixTrie.contains("paid"));
        Assert.assertTrue(prefixTrie.contains("paint"));
        Assert.assertTrue(prefixTrie.contains("pains"));
        Assert.assertTrue(prefixTrie.containsPrefix("pa"));
        Assert.assertTrue(prefixTrie.containsPrefix("pau"));
        Assert.assertTrue(prefixTrie.containsPrefix("pai"));
        Assert.assertTrue(prefixTrie.containsPrefix("paul"));
        Assert.assertTrue(prefixTrie.containsPrefix("pair"));
        Assert.assertTrue(prefixTrie.containsPrefix("paid"));
        Assert.assertTrue(prefixTrie.containsPrefix("pain"));
        Assert.assertTrue(prefixTrie.containsPrefix("paint"));
        Assert.assertTrue(prefixTrie.containsPrefix("pains"));
    }
}
