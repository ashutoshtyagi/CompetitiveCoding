package com.fancita.leetcode.LinkedList;

/**
 * Created by ashutosh on 5/3/17.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode firstList = new ListNode(9);
        firstList.next = new ListNode(9);
        firstList.next.next = new ListNode(9);
        /*firstList.next.next.next = new ListNode(3);*/

        ListNode secondList = new ListNode(9);
        secondList.next = new ListNode(0);
        secondList.next.next = new ListNode(9);

        ListNode ret = new AddTwoNumbers().addTwoNumbers(firstList, secondList);
        Utils.printLinkedList(ret);
    }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null, iterator = null;
            int carry = 0;

            while (l1 != null || l2 != null) {
                int num1 = 0;
                if (l1 != null) {
                    num1 = l1.val;
                    l1 = l1.next;
                }

                int num2 = 0;
                if (l2 != null) {
                    num2 = l2.val;
                    l2 = l2.next;
                }

                int sum = num1 +  num2 + carry;
                int onesDigit = sum % 10;

                ListNode node = new ListNode(onesDigit);

                if (head == null) {
                    head = node;
                    iterator = node;
                } else {
                    iterator.next = node;
                    iterator = iterator.next;
                }

                carry = sum / 10;
            }

            if (carry != 0) {
                ListNode newNode = new ListNode(carry);
                iterator.next = newNode;
            }

            return head;
        }
}
