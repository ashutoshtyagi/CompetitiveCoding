package com.fancita.leetcode.Strings;

import com.fancita.leetcode.Heap.IntegerMinHeap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashutosh on 5/3/17.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        DoublyLinkedListNode head = null, iterator = null;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            DoublyLinkedListNode newNode = null;

            for (int j = 0; j < t.length(); j++) {
                if (c == t.charAt(j)) {
                    newNode = new DoublyLinkedListNode(c, i);
                    break;
                }
            }

            if (newNode != null) {
                if (head == null) {
                    head = newNode;
                    iterator = head;
                } else {
                    iterator.next = newNode;
                    newNode.prev = iterator;
                    iterator = iterator.next;
                }
            }
        }

        if (head == null) {
            return "";
        }

        iterator = head;
        Map<Character, DoublyLinkedListNode> map = new HashMap<>(t.length());
        int minWindowTillNow = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        int characterCount = 0;

        while (iterator != null) {
            if (map.containsKey(iterator.c)) {
                head = removeFromList(map.get(iterator.c), head);
                map.put(iterator.c, iterator);
            } else {
                map.put(iterator.c, iterator);
                characterCount++;
            }

            if (characterCount == t.length()) {
                int contender = iterator.posInString - head.posInString + 1;
                if (contender < minWindowTillNow) {
                    minWindowTillNow = contender;
                    left = head.posInString;
                    right = iterator.posInString + 1;
                }
            }

            iterator = iterator.next;
        }

        return minWindowTillNow == Integer.MAX_VALUE ? "" : s.substring(left, right);
    }

    private DoublyLinkedListNode removeFromList(DoublyLinkedListNode node, DoublyLinkedListNode head) {
        if (head == node) {
            head = head.next;
            head.prev = null;
        } else {
            DoublyLinkedListNode next = node.next;
            node.prev.next = next;
            next.prev = node.prev;
        }

        return head;
    }

    class DoublyLinkedListNode {
        DoublyLinkedListNode prev, next;
        char c;
        int posInString;

        public DoublyLinkedListNode(char c, int i) {
            this.c = c;
            this.posInString = i;
        }
    }
}
