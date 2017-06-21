package com.fancita.leetcode.LinkedList;

/**
 * Created by ashutosh on 18/2/17.
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head =  new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        /*head.next.next.next = new ListNode(1);*/
        System.out.println(new PalindromeLinkedList().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        int lengthOfList = length(head);
        if (lengthOfList == 1 ||  lengthOfList == 0) {
            return true;
        }

        ListNode secondList = null;
        if (lengthOfList % 2 == 0) {
            ListNode previousToSecondList = getNth(head, lengthOfList / 2);
            secondList = previousToSecondList.next;
            previousToSecondList.next = null;
        } else {
            ListNode endOfFirstList = getNth(head, lengthOfList / 2);
            secondList = endOfFirstList.next.next;
            endOfFirstList.next.next = null;
            endOfFirstList.next = null;
        }

        secondList = reverse(secondList);
        return areListsSame(head, secondList);
    }

    private ListNode getNth(ListNode head, int n) {
        int nCounter = 1;
        while (nCounter < n) {
            nCounter++;
            head = head.next;
        }
        return head;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ret = recurse(head);
        head.next.next = head;
        head.next = null;
        return ret;
    }

    private ListNode recurse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode ret = recurse(head.next);
        head.next.next = head;
        return ret;
    }

    private boolean areListsSame(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null && head1.val == head2.val) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return (head1 == null) && (head2 == null);
    }

    private int length(ListNode head) {
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }
        return l;
    }
}
