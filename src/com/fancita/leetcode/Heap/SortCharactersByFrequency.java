package com.fancita.leetcode.Heap;

import com.fancita.leetcode.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ashutosh on 19/2/17.
 */
public class SortCharactersByFrequency {


    /*private Map<Character, MaxHeapElement> hashMap;
    private MaxHeap maxHeap;
    private String string;*/

    public static void main(String[] args) {
        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
        System.out.println(sortCharactersByFrequency.frequencySort("caac"));
    }

    public String frequencySort(String string) {
        Map<Character, MaxHeapElement> hashMap = new HashMap<>(string.length());
        MaxHeap maxHeap = new MaxHeap(string.length());

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (hashMap.containsKey(ch)) {
                MaxHeapElement maxHeapElement = hashMap.get(ch);
                maxHeapElement.frequency += 1;
                maxHeap.update(maxHeapElement);
            } else {
                MaxHeapElement maxHeapElement = new MaxHeapElement(ch);
                hashMap.put(ch, maxHeapElement);
                maxHeap.insert(maxHeapElement);
            }
        }

        StringBuilder ret = new StringBuilder(string.length());
        while (!maxHeap.isEmpty()) {
            MaxHeapElement maxHeapElement = maxHeap.getMax();
            char ch = maxHeapElement.c;
            int frequency = maxHeapElement.frequency;
            for (int i = 0; i < frequency; i++) {
                ret.append(ch);
            }
        }

        return ret.toString();
    }
}

class MaxHeapElement {
    char c;
    int frequency;
    int indexInArray;

    public MaxHeapElement(char c) {
        this.c = c;
        this.frequency = 1;
    }
}

class MaxHeap {

    List<MaxHeapElement> arr;

    public MaxHeap(int maxCapacity) {
        this.arr = new ArrayList<>(maxCapacity);
    }

    public void insert(MaxHeapElement heapElement) {
        arr.add(heapElement);
        heapElement.indexInArray = arr.size() - 1;
        moveUp(arr.size() - 1);
    }

    public void update(MaxHeapElement heapElement) {
        moveUp(heapElement.indexInArray);
    }

    public MaxHeapElement viewMax() {
        return arr.size() > 0 ? arr.get(0) : null;
    }

    public MaxHeapElement getMax() {
        MaxHeapElement ret = arr.get(0);
        swap(0, arr.size() - 1);
        arr.remove(arr.size() - 1);
        moveDown(0);
        return ret;
    }

    public boolean isEmpty() {
        return arr.size() == 0;
    }

    private void moveDown(int parentIndex) {
        if (parentIndex >= arr.size()) {
            return;
        }

        MaxHeapElement parent = arr.get(parentIndex);

        int leftIndex = 2 * parentIndex + 1;
        MaxHeapElement leftChild = leftIndex < arr.size() ? arr.get(leftIndex) : null;

        int rightIndex = 2 * parentIndex + 2;
        MaxHeapElement rightChild = rightIndex < arr.size() ? arr.get(rightIndex) : null;

        if (leftChild == null && rightChild == null) {
            return;
        } else if (leftChild != null && rightChild == null) {
            if (leftChild.frequency > parent.frequency) {
                swap(leftIndex, parentIndex);
                moveDown(leftIndex);
            } else return;
        } else if (rightChild != null && leftChild == null) {
            if (rightChild.frequency > parent.frequency) {
                swap(rightIndex, parentIndex);
                moveDown(rightIndex);
            } else return;
        } else {
            int contender = leftChild.frequency > rightChild.frequency ?  leftIndex : rightIndex;
            swap(contender, parentIndex);
            moveDown(contender);
        }
        return;
    }

    private void moveUp(int childIndex) {
        if (childIndex == 0) {
            return;
        }

        int parentIndex = (childIndex - 1) / 2;

        MaxHeapElement parent = arr.get(parentIndex);
        MaxHeapElement child = arr.get(childIndex);

        if (parent.frequency < child.frequency) {
            swap(childIndex, parentIndex);
            moveUp(parentIndex);
        } else return;
    }

    private void swap(int index1, int index2) {
        MaxHeapElement maxHeapElement1 = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, maxHeapElement1);
        arr.get(index1).indexInArray = index1;
        arr.get(index2).indexInArray = index2;
    }
}