package com.fancita.leetcode.LinkedList;

/**
 * Created by ashutosh on 16/3/17.
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        /*head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);*/
        ListNode ret = new OddEvenLinkedList().oddEvenList(head);
        Utils.printLinkedList(ret);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;

        ListNode oddList = null, oddListIterator = null, evenList = null, evenListIterator = null;

        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {
                if (oddList == null) {
                    oddList = head;
                    oddListIterator = head;
                } else {
                    oddListIterator.next = head;
                    oddListIterator = oddListIterator.next;
                }
            } else {
                if (evenList == null) {
                    evenList = head;
                    evenListIterator = head;
                } else {
                    evenListIterator.next = head;
                    evenListIterator = evenListIterator.next;
                }
            }

            head = head.next;
            count++;
        }

        if (count % 2 == 0 && count != 2) {
            evenListIterator.next = null;
        } else {
            oddListIterator.next = null;
        }

        oddListIterator.next = evenList;
        return oddList;
    }
}
