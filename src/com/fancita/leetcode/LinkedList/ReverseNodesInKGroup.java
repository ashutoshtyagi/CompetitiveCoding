package com.fancita.leetcode.LinkedList;

/**
 * Created by ashutosh on 7/12/16.
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        Utils.printLinkedList(head);
        System.out.println();
        ListNode ret = reverseNodesInKGroup.reverseKGroup(head, 10);
        Utils.printLinkedList(ret);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        return f(head, head, null, 0, k, getLengthOfList(head));
    }

    private ListNode f(ListNode firstOfPresent, ListNode present, ListNode previous, int kTillNow,
                       int k, int remainingLength) {
        if (present == null) {
            return null;
        }

        if (kTillNow == 0 && k > remainingLength) {
            return present;
        }

        ListNode next = present.next;
        present.next = previous;
        kTillNow++;

        if (next == null) {
            return present;
        } else if (kTillNow == k) {
            firstOfPresent.next = f(next, next, null, 0, k, remainingLength - k);
            return present;
        } else return f(firstOfPresent, next, present, kTillNow, k, remainingLength);
    }

    public int getLengthOfList(ListNode head) {
        int ret = 0;
        while (head != null) {
            ret++;
            head = head.next;
        }
        return ret;
    }
}
