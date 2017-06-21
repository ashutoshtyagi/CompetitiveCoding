package com.fancita.leetcode.Heap;

/**
 * Created by ashutosh on 10/2/17.
 */
public class TestIntegerMinHeap {
    public static void main(String[] args) {
        IntegerMinHeap integerMinHeap = new IntegerMinHeap();
        integerMinHeap.add(1);
        integerMinHeap.add(2);
        integerMinHeap.add(3);
        integerMinHeap.add(4);
        integerMinHeap.add(5);
        System.out.println(integerMinHeap.getMin());
        System.out.println(integerMinHeap.getMin());
        System.out.println(integerMinHeap.getMin());
        System.out.println(integerMinHeap.getMin());
        System.out.println(integerMinHeap.getMin());
    }
}
