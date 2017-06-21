package com.fancita.leetcode.LinkedList;

/**
 * Created by ashutosh on 21/11/16.
 */
public class ReverseLinkedList206 {

    public static void main(String[] args) {
        ReverseLinkedList206 reverseLinkedList206 = new ReverseLinkedList206();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode ret = reverseLinkedList206.reverseList(head);
        Utils.printLinkedList(ret);
    }

    public ListNode reverseList(ListNode head) {
        return this.reverse(null, head);
    }

    public ListNode reverse(ListNode previous, ListNode present) {
        if (present == null) {
            return null;
        }
        ListNode temp = present.next;
        present.next = previous;
        if(temp == null) {
            return present;
        }
        return reverse(present, temp);
    }
}
