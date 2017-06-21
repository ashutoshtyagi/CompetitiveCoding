package com.fancita.leetcode.Heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashutosh on 10/2/17.
 */
public class IntegerMinHeap {

    private List<Integer> list;

    public IntegerMinHeap() {
        list = new ArrayList<>();
    }

    public IntegerMinHeap(int maxCapacity) {
        list = new ArrayList<>(maxCapacity);
    }

    public void add(int k) {
        list.add(k);
        int lastIndex = list.size() - 1;
        moveUp(lastIndex);
    }

    public int viewMin() {
        if (list.size() == 0) return -1;

        int ret = list.get(0);
        return ret;
    }

    public int getMin() {
        if (list.size() == 0) return -1;

        int ret = list.get(0);
        int lastElement = list.remove(list.size() - 1);

        if (list.size() != 0) {
            list.set(0, lastElement);
            moveDown(0);
        }

        return ret;
    }

    public void replaceMin(int k) {
        if (list.size() == 0) {
            list.add(k);
            return;
        } else if (list.size() == 1) {
            list.set(0, k);
            return;
        }

        list.set(0, k);
        moveDown(0);
    }

    private void moveDown(int parentIndex) {
        if (parentIndex >= list.size()) return;

        int presentElement = list.get(parentIndex);

        int leftIndex = 2 * parentIndex + 1;
        int leftElement = leftIndex >= list.size() ? Integer.MAX_VALUE : list.get(leftIndex);

        int rightIndex = 2 * parentIndex + 2;
        int rightElement = rightIndex  >= list.size() ? Integer.MAX_VALUE : list.get(rightIndex);

        if (leftElement < rightElement) {
            if (presentElement > leftElement) {
                swap(parentIndex, 2 * parentIndex + 1);
                moveDown(2 * parentIndex + 1);
            } else {
                return;
            }
        } else {
            if (presentElement > rightElement) {
                swap(parentIndex, 2 * parentIndex + 2);
                moveDown(2 * parentIndex + 2);
            } else {
                return;
            }
        }
    }

    private void moveUp(int childIndex) {
        if (childIndex == 0) return;

        int parentIndex = (childIndex - 1) / 2;
        if (list.get(childIndex) < list.get(parentIndex)) {
            swap(parentIndex, childIndex);
        }

        moveUp(parentIndex);
    }

    private void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
