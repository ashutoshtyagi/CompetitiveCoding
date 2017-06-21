package com.fancita.leetcode.Heap;

/**
 * Created by ashutosh on 10/2/17.
 */
public class GenericMinHeapElement {
    public int positionInHeap;
    public int number;

    public GenericMinHeapElement(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPositionInHeap() {
        return positionInHeap;
    }

    public void setPositionInHeap(int positionInHeap) {
        this.positionInHeap = positionInHeap;
    }
}
