package com.fancita.leetcode.Design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ashutosh on 11/2/17.
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class ImplementQueueUsingStack {

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

    public static class MyQueue {

        private Deque<Integer> mainStack, auxiliaryStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            mainStack = new ArrayDeque<>();
            auxiliaryStack = new ArrayDeque<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!mainStack.isEmpty()) {
                auxiliaryStack.addLast(mainStack.pollLast());
            }

            mainStack.addLast(x);

            while (!auxiliaryStack.isEmpty()) {
                mainStack.addLast(auxiliaryStack.pollLast());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return mainStack.pollLast();
        }

        /** Get the front element. */
        public int peek() {
            return mainStack.peekLast();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return mainStack.isEmpty();
        }
    }
}
