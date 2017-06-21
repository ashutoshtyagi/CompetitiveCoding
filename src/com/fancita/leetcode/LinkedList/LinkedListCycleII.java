package com.fancita.leetcode.LinkedList;

/**
 * Created by ashutosh on 8/4/17.
 */
public class LinkedListCycleII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head/*new ListNode(4)*/;
        /*head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;*/
        ListNode cycle = new LinkedListCycleII().detectCycle(head);
        if(cycle == null) {
            System.out.println("no cycle");
            return;
        }
        System.out.println("cycle at " + cycle.val);

    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null && slow.val != fast.val) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast == null || fast.next == null) return null;

        slow = head;
        fast = fast.next;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
