package com.fancita.leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashutosh on 12/3/17.
 */
public class CopyListWithRandomPointer {

    public static void main(String[] args) {

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> mappingOfOriginalNodeToCloneNode = new HashMap<>();
        return cloneNode(head, mappingOfOriginalNodeToCloneNode);
    }

    private RandomListNode cloneNode(RandomListNode original, Map<RandomListNode, RandomListNode> map) {
        if (original == null) return null;

        RandomListNode clone = new RandomListNode(original.label);
        map.put(original, clone);

        clone.next = cloneNode(original.next, map);

        clone.random = map.get(original.random);

        return clone;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

}
