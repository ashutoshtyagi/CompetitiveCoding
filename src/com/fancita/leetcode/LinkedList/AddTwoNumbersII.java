package com.fancita.leetcode.LinkedList;

import java.util.Stack;

/**
 * Created by ashutosh on 26/11/16.
 */
public class AddTwoNumbersII {
    public static void main(String[] args) {
        AddTwoNumbersII addTwoNumbersII = new AddTwoNumbersII();

        ListNode firstList = new ListNode(9);
        firstList.next = new ListNode(9);
        /*firstList.next.next = new ListNode(4);
        firstList.next.next.next = new ListNode(3);*/

        ListNode secondList = new ListNode(1);
        /*secondList.next = new ListNode(6);
        secondList.next.next = new ListNode(4);*/

        ListNode ret = addTwoNumbersII.addTwoNumbers(firstList, secondList);
        Utils.printLinkedList(ret);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = createStack(l1);
        Stack<ListNode> stack2 = createStack(l2);

        int carry = 0;
        ListNode prevNode = null;
        while (!stack1.empty() || !stack2.empty()) {
            int num1 = 0, num2 = 0;

            if (!stack1.empty()) {
                ListNode item1 = stack1.pop();
                if (item1 != null) {
                    num1 = item1.val;
                }
            }

            if (!stack2.empty()) {
                ListNode item2 = stack2.pop();
                if (item2 != null) {
                    num2 = item2.val;
                }
            }

            int sum = carry + num1 + num2;

            int onesDigit = sum % 10;
            sum = sum / 10;
            int tensDigit = sum;

            ListNode newNode = new ListNode(onesDigit);
            if (prevNode != null) {
                newNode.next = prevNode;
            }

            prevNode = newNode;
            carry = tensDigit;
        }

        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = prevNode;
            prevNode = newNode;
        }

        return prevNode;
    }

    public Stack<ListNode> createStack(ListNode listNode) {
        Stack<ListNode> ret = new Stack<>();
        while (listNode != null) {
            ret.push(listNode);
            listNode = listNode.next;
        }
        return ret;
    }
}
