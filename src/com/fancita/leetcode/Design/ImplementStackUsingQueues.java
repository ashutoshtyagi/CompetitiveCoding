package com.fancita.leetcode.Design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ashutosh on 11/2/17.
 * https://leetcode.com/problems/implement-stack-using-queues/?tab=Description
 */
public class ImplementStackUsingQueues {

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

    private static class MyStack {

        Deque<Integer> que = null;

        /** Initialize your data structure here. */
        public MyStack() {
            que = new ArrayDeque<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            que.addLast(x);
            int i = 0;
            while (i <= que.size() - 2) {
                que.addLast(que.removeFirst());
                i++;
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return que.pollFirst();
        }

        /** Get the top element. */
        public int top() {
            return que.peekFirst();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return que.isEmpty();
        }
    }
}
