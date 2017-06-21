package com.fancita.leetcode.Heap;

import com.fancita.utils.Pair;

import java.util.*;

/**
 * Created by ashutosh on 23/3/17.
 */
public class KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {
        /*int[][] matrix = new int[][] {
                {1, 2, 4},
                {3, 6, 8},
                {5, 7, 19}
        };*/

        int[][] matrix = new int[][] {
                {93,157,226,308,365,384,479,539,557,652},
                {118,234,287,368,395,432,480,607,634,723},
                {132,263,381,453,525,533,577,650,707,800},
                {171,307,473,504,526,596,643,719,776,842},
                {233,319,514,571,668,710,733,777,875,886},
                {318,362,555,605,717,782,809,884,889,940},
                {349,415,622,708,787,795,824,921,957,1014},
                {414,420,656,789,813,898,954,1052,1095,1175},
                {430,477,705,863,961,991,1003,1121,1190,1236},
                {524,611,793,868,1027,1111,1112,1123,1252,1253}
        };

        System.out.println(new KthSmallestElementInASortedMatrix().kthSmallest(matrix, 32));
    }

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || k > matrix.length * matrix[0].length) return Integer.MAX_VALUE;

        positionVisitedMatrix = new boolean[matrix.length][matrix[0].length];

        IntegerMinHeap minHeap = new IntegerMinHeap(matrix.length * matrix[0].length, getHeapElement(matrix, 0, 0));

        int kIter = 0;
        HeapElement element = null;

        while (kIter < k) {
            kIter++;
            element = minHeap.viewMin();
            /*minHeap.printList();
            System.out.println("element = " +  element.toString() );
            System.out.println("\n");*/
            if (kIter != k) minHeap.replaceMin(getHeapElement(matrix, element.i, element.j + 1), getHeapElement(matrix, element.i + 1, element.j));
        }

        return element == null ? matrix[0][0] : element.val;
    }

    private boolean[][] positionVisitedMatrix;

    private HeapElement getHeapElement(int[][] matrix, int i, int j) {
        if (i < matrix.length && matrix.length > 0 && j < matrix[0].length) {
            if (!positionVisitedMatrix[i][j]) {
                positionVisitedMatrix[i][j] = true;
                return new HeapElement(matrix[i][j], i, j);
            }
        }
        return null;
    }

    class HeapElement {
        int val;
        int i, j;

        public HeapElement(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "HeapElement{" +
                    "val=" + val +
                    ", i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    class IntegerMinHeap {

        private List<HeapElement> list;

        public IntegerMinHeap(int capacity, HeapElement first) {
            this.list = new ArrayList<>(capacity);
            list.add(first);
        }

        public void printList() {
            System.out.println(Arrays.toString(list.toArray()));
        }

        public HeapElement viewMin() {
            if (list.size() > 0) return list.get(0);
            return null;
        }

        private void removeMin() {
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
            moveDown(0);
        }

        public void replaceMin(HeapElement contender1, HeapElement contender2) {
            removeMin();

            /* do check if both are null */
            if (contender1 == null && contender2 == null) {
                return;
            }

            if (contender1 != null) {
                list.add(contender1);
                moveUp(list.size() - 1);
            }

            if (contender2 != null) {
                list.add(contender2);
                moveUp(list.size() - 1);
            }
            /*HeapElement smaller = getSmaller(contender1, contender2);
            HeapElement larger = smaller == contender1 ? contender2 : contender1;

            list.set(0, smaller);
            if (larger != null) list.add(larger);

            moveDown(0);*/
        }

        private void moveUp(int childIndex) {
            if (childIndex == 0) return;

            int parentIndex = (childIndex - 1) / 2;

            HeapElement parent = list.get(parentIndex);
            HeapElement child = list.get(childIndex);

            if (parent.val > child.val) {
                exchange(parentIndex, childIndex);
                moveUp(parentIndex);
            }
            return;
        }

        private void moveDown(int parentIndex) {
            if (parentIndex >= list.size()) return;

            int leftIndex = 2 * parentIndex + 1;
            int rightIndex = 2 * parentIndex + 2;

            if (leftIndex >= list.size() && rightIndex >= list.size()) return;

            int smallerHeapElementIndex = getSmallerHeapElementIndex(leftIndex, rightIndex);
            if (list.get(parentIndex).val > list.get(smallerHeapElementIndex).val) {
                exchange(smallerHeapElementIndex, parentIndex);
                moveDown(smallerHeapElementIndex);
            }
            return;
        }

        private int getSmallerHeapElementIndex(int leftIndex, int rightIndex) {
            if (leftIndex < list.size() && (rightIndex >= list.size() || list.get(leftIndex).val < list.get(rightIndex).val)) {
                return leftIndex;
            }
            return rightIndex;
        }

        private HeapElement getSmaller(HeapElement contender1, HeapElement contender2) {
            if (contender1 != null && (contender2 == null || contender1.val < contender2.val)) {
                return contender1;
            }
            return contender2;
        }

        private void exchange(int index1, int index2) {
            HeapElement one = list.get(index1);
            HeapElement two = list.get(index2);
            list.set(index1, two);
            list.set(index2, one);
        }
    }
}
