package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 19/2/17.
 */
public class AddAndSearchWordDataStructureDesign {

    public static void main(String[] args) {
        AddAndSearchWordDataStructureDesign design = new AddAndSearchWordDataStructureDesign();
        design.addWord("bad");
        design.addWord("dad");
        design.addWord("mad");
        System.out.println(design.search("pad"));
        System.out.println(design.search("bad"));
        System.out.println(design.search(".ad"));
        System.out.println(design.search("b.."));
        System.out.println(design.search("."));
        System.out.println(design.search(""));
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public AddAndSearchWordDataStructureDesign() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void addWord(String word) {
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
        return recursiveSearch(iterator, word, 0);
    }

    public boolean recursiveSearch(TrieNode iterator, String word, int index) {
        if (index == word.length()) {
            return iterator.wordEndsHere;
        }

        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (iterator.trieNodes[i] == null) {
                    continue;
                }
                boolean ret = recursiveSearch(iterator.trieNodes[i], word, index + 1);
                if (ret) return true;
            }
            return false;
        } else {
            if (iterator.trieNodes[word.charAt(index) - 'a'] == null) {
                return false;
            }
            return recursiveSearch(iterator.trieNodes[word.charAt(index) - 'a'], word, index + 1);
        }
    }

    private class TrieNode {
        public TrieNode[] trieNodes;
        public boolean wordEndsHere = false;

        public TrieNode() {
            trieNodes = new TrieNode[26];
        }
    }
}
