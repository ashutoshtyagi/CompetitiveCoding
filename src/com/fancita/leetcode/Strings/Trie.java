package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 18/2/17.
 *
 * Your Trie object will be instantiated and called as such:
 *  Trie obj = new Trie();
 *  obj.insert(word);
 *  boolean param_2 = obj.search(word);
 *  boolean param_3 = obj.startsWith(prefix);
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("prefixxx");
        System.out.println(trie.search("prefixx"));
        System.out.println(trie.startsWith("prefix"));
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode iterator = root;
        for (int i = 0; i < word.length(); i++) {
            if (iterator.trieNodes[word.charAt(i) - 'a'] == null) {
                iterator.trieNodes[word.charAt(i) - 'a'] = new TrieNode();
            }
            iterator = iterator.trieNodes[word.charAt(i) - 'a'];
        }
        iterator.wordEndsHere = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode iterator = root;
        for (int i = 0; i < word.length(); i++) {
            if (iterator.trieNodes[word.charAt(i) - 'a'] == null) {
                return false;
            }
            iterator = iterator.trieNodes[word.charAt(i) - 'a'];
        }
        return iterator.wordEndsHere;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode iterator = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (iterator.trieNodes[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            iterator = iterator.trieNodes[prefix.charAt(i) - 'a'];
        }
        return true;
    }

    private class TrieNode {
        public TrieNode[] trieNodes;
        public boolean wordEndsHere = false;

        public TrieNode() {
            trieNodes = new TrieNode[26];
        }
    }
}
