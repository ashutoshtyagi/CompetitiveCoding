package com.fancita.leetcode.LinkedList;

/**
 * Created by ashutosh on 3/12/16.
 */
public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        ListNode ret = insertionSort.insertionSortList(head);
        Utils.printLinkedList(ret);
    }

    private ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode lastItemOfSortedList = head;

        while (lastItemOfSortedList.next != null) {
            ListNode presentNode = lastItemOfSortedList.next;
            lastItemOfSortedList.next = presentNode.next;
            presentNode.next = null;

            ListNode sortedListIterator = head;
            ListNode nodePreviousToSortedListIterator = null;
            while (sortedListIterator != lastItemOfSortedList.next
                    && sortedListIterator.val < presentNode.val) {
                nodePreviousToSortedListIterator = sortedListIterator;
                sortedListIterator = sortedListIterator.next;
            }

            if (nodePreviousToSortedListIterator == null) {
                presentNode.next = sortedListIterator;
                head = presentNode;
            } else if (sortedListIterator == lastItemOfSortedList.next) {
                presentNode.next = sortedListIterator;
                nodePreviousToSortedListIterator.next = presentNode;
                lastItemOfSortedList = presentNode;
            } else {
                presentNode.next = sortedListIterator;
                nodePreviousToSortedListIterator.next = presentNode;
            }
        }

        return head;
    }
}
