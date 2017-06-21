package com.fancita.leetcode.LinkedList;

/**
 * Created by ashutosh on 2/12/16.
 */
public class MergeSortLinkedList {
    public static void main(String[] args) {
        MergeSortLinkedList mergeSortLinkedList = new MergeSortLinkedList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        ListNode ret = mergeSortLinkedList.sortList(head);
        Utils.printLinkedList(ret);
    }

    public ListNode sortList(ListNode list) {
        int size = Utils.calculateSize(list);
        return mergeSort(list, size);
    }

    private ListNode mergeSort(ListNode list, int size) {
        if (size == 1 || size == 0) {
            return list;
        }

        ListNode leftList = list;
        ListNode rightList = null;

        int mid = size / 2;
        ListNode midIter = list;
        for (int midInt = 1; midInt < mid; midInt++) {
            midIter = midIter.next;
        }

        rightList = midIter.next;
        midIter.next = null;

        ListNode left = mergeSort(leftList, size / 2);
        ListNode right = mergeSort(rightList, size % 2 == 0 ? size / 2 : size / 2 + 1);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode ret = null, retIter = null;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                if (ret == null) {
                    ret = left;
                }
                if (retIter == null) {
                    retIter = left;
                    left = left.next;
                } else {
                    retIter.next = left;
                    retIter = retIter.next;
                    left = left.next;
                }
            } else {
                if (ret == null) {
                    ret = right;
                }
                if (retIter == null) {
                    retIter = right;
                    right = right.next;
                } else {
                    retIter.next = right;
                    retIter = retIter.next;
                    right = right.next;
                }
            }
        }

        if (left == null) {
            retIter.next = right;
        } else retIter.next = left;

        return ret;
    }
}
