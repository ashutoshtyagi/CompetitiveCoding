package com.fancita.leetcode.LinkedList;

/**
 * Created by ashutosh on 21/11/16.
 */
public class Utils {
    public static void printLinkedList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static int calculateSize(ListNode list) {
        int ret = 0;
        while (list != null) {
            ret++;
            list = list.next;
        }
        return ret;
    }
}
