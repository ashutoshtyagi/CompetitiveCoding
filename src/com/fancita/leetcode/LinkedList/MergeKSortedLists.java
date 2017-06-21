package com.fancita.leetcode.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashutosh on 23/2/17.
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode firstList = new ListNode(4);
        firstList.next = new ListNode(5);
        firstList.next.next = new ListNode(6);

        ListNode secondList = new ListNode(7);
        secondList.next = new ListNode(8);
        secondList.next.next = new ListNode(9);

        ListNode thirdList = new ListNode(1);
        thirdList.next = new ListNode(2);
        thirdList.next.next = new ListNode(3);

        /*ListNode[] lists = new ListNode[] {
                firstList, secondList, thirdList
        };*/

        ListNode[] internal = new ListNode[] {};
        ListNode[] lists = new ListNode[] {

        };

        Utils.printLinkedList(new MergeKSortedLists().mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode ret = null;
        ListNode retIterator = null;

        MinHeap minHeap = new MinHeap(lists.length);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.getMin();

            if (ret == null) {
                ret = min;
                retIterator = min;
            } else {
                retIterator.next = min;
                retIterator = retIterator.next;
            }
        }

        return ret;
    }

    public class MinHeap {

        private List<ListNode> arr;

        public MinHeap(int maxCapacity) {
            this.arr = new ArrayList<>(maxCapacity);
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

        public int getSize() {
            return arr.size();
        }

        public ListNode getMin() {
            if (arr.size() == 0) return null;

            ListNode ret = arr.get(0);
            if (ret.next != null) {
                arr.set(0, ret.next);
            } else {
                swap(0, arr.size() - 1);
                arr.remove(arr.size() - 1);
            }

            moveDown(0);

            return ret;
        }

        public void add(ListNode node) {
            arr.add(node);
            moveUp(arr.size() - 1);
        }

        private void moveUp(int childIndex) {
            if (childIndex == 0 || childIndex >= arr.size()) return;

            int parentIndex = (childIndex - 1) / 2;

            ListNode child = arr.get(childIndex);
            ListNode parent = arr.get(parentIndex);

            if (child.val < parent.val) {
                swap(childIndex, parentIndex);
                moveUp(parentIndex);
            }
        }

        private void moveDown(int parentIndex) {
            if (parentIndex >= arr.size()) return;

            ListNode parent = arr.get(parentIndex);

            int leftIndex = 2 * parentIndex + 1;
            ListNode left = leftIndex >= arr.size() ? null : arr.get(leftIndex);

            int rightIndex = 2 * parentIndex + 2;
            ListNode right = rightIndex >= arr.size() ? null : arr.get(rightIndex);

            if (left == null && right == null) {
                return;
            } else if (left != null && right != null) {
                if (left.val <= right.val && parent.val > left.val) {
                    swap(parentIndex, leftIndex);
                    moveDown(leftIndex);
                } else if (right.val < left.val && parent.val > right.val) {
                    swap(parentIndex, rightIndex);
                    moveDown(rightIndex);
                }
            } else if (left == null && right.val  < parent.val) {
                swap(rightIndex, parentIndex);
                moveDown(rightIndex);
            } else if (right == null && left.val < parent.val) {
                swap(leftIndex, parentIndex);
                moveDown(leftIndex);
            }

            return;
        }

        private void swap(int leftIndex, int rightIndex) {
            ListNode left = arr.get(leftIndex);
            arr.set(leftIndex, arr.get(rightIndex));
            arr.set(rightIndex, left);
        }
    }
}
