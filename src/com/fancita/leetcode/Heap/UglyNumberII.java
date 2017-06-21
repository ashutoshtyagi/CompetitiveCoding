package com.fancita.leetcode.Heap;

import java.util.*;

/**
 * Created by ashutosh on 21/2/17.
 */
public class UglyNumberII {
    public static void main(String[] args) {
        UglyNumberII uglyNumberII = new UglyNumberII();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Do you want to continue? y/n?");
            String ch = scanner.next();
            if (ch.equals("n")) break;

            System.out.println("Enter n");
            int n = Integer.valueOf(scanner.next());

            System.out.println("answer = " + uglyNumberII.nthUglyNumber(n));
        }
    }

    public int nthUglyNumber(int n) {
        MinHeapLong minHeapLong = new MinHeapLong(n);
        Set<Long> set = new HashSet<>(n);

        long contender = 1;
        minHeapLong.insert(2);
        minHeapLong.insert(3);
        minHeapLong.insert(5);
        System.out.println(contender + " ");
        set.add(contender);

        for (int i = 1; i < n; i++) {
            contender = minHeapLong.getMin();
            if (!set.contains(2 * contender)) {
                minHeapLong.insert(2 * contender);
                set.add(2 * contender);
            }
            if (!set.contains(3 * contender)) {
                minHeapLong.insert(3 * contender);
                set.add(3 * contender);
            }
            if (!set.contains(5 * contender)) {
                minHeapLong.insert(5 * contender);
                set.add(5 * contender);
            }
            System.out.println(contender + " ");
        }

        return (int) contender;
    }

}

class MinHeapLong {

    private List<Long> array;

    public MinHeapLong(int maxCapacity) {
        array = new ArrayList<>(maxCapacity);
    }

    public void insert(long n) {
        array.add(n);
        moveUp(array.size() - 1);
    }

    public long getMin() {
        if (array.size() > 0) {
            long ret = array.get(0);
            swap(0, array.size() - 1);
            array.remove(array.size() - 1);
            moveDown(0);
            return ret;
        }
        return Long.MAX_VALUE;
    }

    private void moveUp(int childIndex) {
        if (childIndex == 0) return;

        int parentIndex = (childIndex - 1) / 2;
        if (array.get(parentIndex) > array.get(childIndex)) {
            swap(childIndex, parentIndex);
            moveUp(parentIndex);
        }
        return;
    }

    private void moveDown(int parentIndex) {
        if (parentIndex > array.size() - 1) return;

        long parent = array.get(parentIndex);

        int leftChildIndex = 2 * parentIndex + 1;
        long leftChild = leftChildIndex < array.size() ? array.get(leftChildIndex) : Long.MAX_VALUE;

        int rightChildIndex = 2 *  parentIndex + 2;
        long rightChild = rightChildIndex < array.size() ? array.get(rightChildIndex) : Long.MAX_VALUE;

        if (leftChild < rightChild && parent > leftChild) {
            swap(parentIndex, leftChildIndex);
            moveDown(leftChildIndex);
        } else if (rightChild < leftChild && parent > rightChild) {
            swap(parentIndex, rightChildIndex);
            moveDown(rightChildIndex);
        } else {
            return;
        }
    }

    private void swap(int index1, int index2) {
        long n1 = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, n1);
    }
}
