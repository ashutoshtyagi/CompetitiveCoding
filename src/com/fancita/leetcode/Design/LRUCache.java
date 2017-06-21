package com.fancita.leetcode.Design;

import java.util.HashMap;

/**
 * Created by ashutosh on 8/1/17.
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(2, 1);
        cache.set(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.set(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    private int capacity;
    private int presentCapacity;
    private HashMap<Integer, Node> map;
    private DLinkedList dLinkedList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        presentCapacity = 0;
        map = new HashMap<>(capacity);
        dLinkedList = new DLinkedList();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            dLinkedList.reset(node);
            return node.val;
        } else return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            dLinkedList.reset(node);
            return;
        }

        if (presentCapacity == capacity) {
            Node prevHead = dLinkedList.removeHead();
            map.remove(prevHead.key);
        } else presentCapacity++;

        Node newNode = new Node(key, value);
        dLinkedList.add(newNode);
        map.put(key, newNode);
    }




    private class Node {
        int val, key;
        public Node prev, next;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    private class DLinkedList {
        Node head, tail;

        public void add(Node node) {
            if (head == null) {
                head = node;
                tail = node;
                return;
            }

            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        public Node removeHead() {
            if (head == null) return null;

            Node node = head;
            head = head.next;
            return node;
        }

        public void reset(Node node) {
            if (node.next == null) return;

            if (head == node) head = head.next;

            if (node.prev != null) node.prev.next = node.next;

            if (node.next != null) node.next.prev = node.prev;

            node.prev = tail;
            node.next = null;
            tail.next = node;

            tail = node;
        }
    }
}
