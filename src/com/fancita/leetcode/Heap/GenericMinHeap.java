package com.fancita.leetcode.Heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashutosh on 10/2/17.
 */
public class GenericMinHeap<T extends GenericMinHeapElement> {

    private List<T> list;

    public GenericMinHeap() {
        list = new ArrayList<T>();
    }

    public void add(T k) {
        list.add(k);
        k.setPositionInHeap(list.size() - 1);
        int lastIndex = list.size() - 1;
        moveUp(lastIndex);
    }

    public int viewMin() {
        if (list.size() == 0) return Integer.MAX_VALUE;

        T ret = list.get(0);
        return ret.getNumber();
    }

    public int getMin() {
        if (list.size() == 0) return Integer.MAX_VALUE;

        T ret = list.get(0);
        T lastElement = list.remove(list.size() - 1);

        if (list.size() != 0) {
            list.set(0, lastElement);
            moveDown(0);
        }

        return ret.getNumber();
    }

    public void removeElement(T t) {
        if (t == null) return;

        int positionOfGivenElement = t.getPositionInHeap();
        swap(positionOfGivenElement, list.size() - 1);
        list.remove(list.size() - 1);
        moveDown(positionOfGivenElement);
    }

    private void moveDown(int parentIndex) {
        if (parentIndex >= list.size()) return;

        T presentElement = list.get(parentIndex);

        int leftIndex = 2 * parentIndex + 1;
        T leftElement = leftIndex >= list.size() ? null : list.get(leftIndex);

        int rightIndex = 2 * parentIndex + 2;
        T rightElement = rightIndex  >= list.size() ? null : list.get(rightIndex);

        if (leftElement == null && rightElement == null) return;

        if (rightElement == null || leftElement.getNumber() < rightElement.getNumber()) {
            if (presentElement.getNumber() > leftElement.getNumber()) {
                swap(parentIndex, 2 * parentIndex + 1);
                moveDown(2 * parentIndex + 1);
            } else {
                return;
            }
        } else {
            if (presentElement.getNumber() > rightElement.getNumber()) {
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
        if (list.get(childIndex).getNumber() < list.get(parentIndex).getNumber()) {
            swap(parentIndex, childIndex);
            moveUp(parentIndex);
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
        list.get(i).setPositionInHeap(i);
        list.get(j).setPositionInHeap(j);
    }
}
