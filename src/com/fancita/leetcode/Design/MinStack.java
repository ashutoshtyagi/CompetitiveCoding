package com.fancita.leetcode.Design;

import com.fancita.leetcode.Heap.GenericMinHeap;
import com.fancita.leetcode.Heap.GenericMinHeapElement;

/**
 * Created by ashutosh on 10/2/17.
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.
    }

    /** initialize your data structure here. */

    private MinStackNode head = null, tail = null;
    private GenericMinHeap<MinStackNode> minHeap;

    public MinStack() {
        minHeap = new GenericMinHeap<>();
    }

    public void push(int x) {
        MinStackNode minStackNode = new MinStackNode(x);
        if (head == null) {
            head = minStackNode;
            tail = minStackNode;
        } else {
            tail.right = minStackNode;
            minStackNode.left = tail;
            tail = tail.right;
        }

        minHeap.add(minStackNode);
    }

    public void pop() {
        if (tail == null) return;

        MinStackNode ret = tail;
        if (tail.left == null) {
            head = null;
            tail = null;
        } else {
            tail = tail.left;
            tail.right = null;
        }

        minHeap.removeElement(ret);
    }

    public int top() {
        if (tail != null) {
            return tail.getNumber();
        }
        return Integer.MAX_VALUE;
    }

    public int getMin() {
        return minHeap.viewMin();
    }

    /* basically it is a doubly linked list*/
    public class MinStackNode extends GenericMinHeapElement {
        public MinStackNode left;
        public MinStackNode right;

        public MinStackNode(int number) {
            super(number);
        }
    }
}