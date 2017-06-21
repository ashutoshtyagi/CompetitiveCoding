package com.fancita.leetcode.LinkedList;

/**
 * Created by ashutosh on 21/11/16.
 */
public class ReverseLinkedListII92 {

    public static void main(String[] args) {
        ReverseLinkedListII92 reverseLinkedListII92 = new ReverseLinkedListII92();
        ListNode head = new ListNode(1);
        /*head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);*/
        ListNode ret = reverseLinkedListII92.reverseBetween(head, 2, 6);
        Utils.printLinkedList(ret);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode it = head;
        ListNode prev = null;
        for (int i = 1; i <= m - 1; i++) {
            prev = it;
            it = it.next;
        }
        ListNode ret = reverse(prev, it, 1, it, n - m + 1);
        if (prev != null) {
            prev.next = ret;
        }
        return m == 1 ? ret : head;
    }

    public ListNode reverse(ListNode previous, ListNode present, int counter, ListNode first, int finalCount) {
        if (present == null) {
            return previous;
        }

        ListNode temp = present.next;

        if (present != first) {
            present.next = previous;
        } else present.next = null;

        if (counter == finalCount) {
            first.next = temp;
            return present;
        }

        return reverse(present, temp, ++counter, first, finalCount);
    }
}
