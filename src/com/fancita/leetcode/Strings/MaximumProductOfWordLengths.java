package com.fancita.leetcode.Strings;

/**
 * Created by ashutosh on 23/3/17.
 */
public class MaximumProductOfWordLengths {

    public static void main(String[] args) {
        String[] words = new String[] {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(new MaximumProductOfWordLengths().maxProduct(words));
    }

    public int maxProduct(String[] words) {
        if (words.length == 0 || words.length == 1) return 0;

        LinkedListElement[] charIndexArr = new LinkedListElement[26];
        boolean[][] matrix = new boolean[words.length][words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] charArr = word.toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                LinkedListElement head = charIndexArr[charArr[j] - 'a'];
                if (head == null) {
                    charIndexArr[charArr[j] - 'a'] = new LinkedListElement(i);
                    matrix[i][i] = true;
                } else {
                    addToList(head, i, matrix);
                }
            }
        }

        int maxTillNow = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!matrix[i][j]) {
                    int product = words[i].length() * words[j].length();
                    maxTillNow = Integer.max(maxTillNow, product);
                }
            }
        }

        return maxTillNow;
    }

    private void addToList(LinkedListElement head, int wordIndex, boolean[][] matrix) {
        matrix[wordIndex][wordIndex] = true;
        while (head.next != null) {
            matrix[wordIndex][head.wordIndex] = true;
            matrix[head.wordIndex][wordIndex] = true;
            head = head.next;
        }
        matrix[wordIndex][head.wordIndex] = true;
        matrix[head.wordIndex][wordIndex] = true;
        head.next = new LinkedListElement(wordIndex);
    }

    class LinkedListElement {
        int wordIndex;
        LinkedListElement next;

        public LinkedListElement(int wordIndex) {
            this.wordIndex = wordIndex;
            next = null;
        }
    }
}
