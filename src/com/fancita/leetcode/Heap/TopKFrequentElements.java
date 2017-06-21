package com.fancita.leetcode.Heap;

import java.util.*;

/**
 * Created by ashutosh on 11/2/17.
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] arr =  new int[] {1,1,1,2,2,3,3,3,4,5,6,3};
        int k = 3;
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(arr, k).toArray()));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k == 0) return Collections.emptyList();

        FrequencyMinHeap<FrequencyMinHeapElement> minHeap = new FrequencyMinHeap<>(k);
        Map<Integer, FrequencyMinHeapElement> hashMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            FrequencyMinHeapElement element;

            if (hashMap.containsKey(num)) {
                element = hashMap.get(num);
                element.increaseFrequency();
                if (element.positionInHeap != -1) {
                    minHeap.onFrequencyUpdated(element);
                } else {
                    if (element.frequency > minHeap.viewMinFrequency()) {
                        minHeap.replaceMinFrequency(element);
                    }
                }
            } else {
                element = new FrequencyMinHeapElement(num);
                hashMap.put(num, element);

                if (minHeap.getSize() < k) {
                    minHeap.add(element);
                }
            }
        }

        return minHeap.getIntegerList();
    }


    /* number in genericminheapelement will act as frequency */
    private class FrequencyMinHeapElement {

        public int val;
        public int frequency = 1;
        public int positionInHeap = -1;

        public FrequencyMinHeapElement(int val) {
            this.val = val;
        }

        public void increaseFrequency() {
            frequency++;
        }
    }

    private class FrequencyMinHeap<T extends FrequencyMinHeapElement> {

        private List<T> list;

        public FrequencyMinHeap(int maxCapacity) {
            list = new ArrayList<>(maxCapacity);
        }

        public List<Integer> getIntegerList() {
            List<Integer> ret = new ArrayList<>(list.size());
            for (int i = 0; i < list.size(); i++) {
                ret.add(list.get(i).val);
            }
            return ret;
        }

        public int getSize() {
            return list.size();
        }

        public void add(T k) {
            list.add(k);
            k.positionInHeap = list.size() - 1;
            moveUp(list.size() - 1);
        }

        /* called when frequency of the element which is in the list already, is updated */
        public void onFrequencyUpdated(T k) {
            moveDown(k.positionInHeap);
        }

        public int viewMinFrequency() {
            if (list.size() == 0) return Integer.MAX_VALUE;

            int ret = list.get(0).frequency;
            return ret;
        }

        public void replaceMinFrequency(T k) {
            k.positionInHeap = 0;

            if (list.size() == 0) {
                list.add(k);
                return;
            } else if (list.size() == 1) {
                T minFreqElementAtPresent = list.get(0);
                minFreqElementAtPresent.positionInHeap = -1;
                list.set(0, k);
                return;
            }

            T minFreqElementAtPresent = list.get(0);
            minFreqElementAtPresent.positionInHeap = -1;
            list.set(0, k);
            moveDown(0);
        }

        private void moveDown(int parentIndex) {
            if (parentIndex >= list.size()) return;

            T parentElement = list.get(parentIndex);

            int leftChildIndex = 2 * parentIndex + 1;
            T leftChild = leftChildIndex >= list.size() ? null : list.get(leftChildIndex);

            int rightChildIndex = 2 * parentIndex + 2;
            T rightChild = rightChildIndex >= list.size() ? null : list.get(rightChildIndex);

            if (leftChild == null && rightChild == null) return;

            if (rightChild == null || leftChild.frequency <= rightChild.frequency) {
                if (parentElement.frequency > leftChild.frequency) {
                   swap(parentIndex, leftChildIndex);
                   moveDown(leftChildIndex);
                }
            } else {
                if (parentElement.frequency > rightChild.frequency) {
                    swap(parentIndex, rightChildIndex);
                    moveDown(rightChildIndex);
                }
            }

            return;
        }

        private void moveUp(int childIndex) {
            if (childIndex == 0) return;

            int parentIndex = (childIndex - 1) / 2;
            if (list.get(childIndex).frequency < list.get(parentIndex).frequency) {
                swap(childIndex, parentIndex);
                moveUp(parentIndex);
            }
        }

        private void swap(int i, int j) {
            T iElement = list.get(i);
            list.set(i, list.get(j));
            list.set(j, iElement);
            list.get(i).positionInHeap = i;
            list.get(j).positionInHeap = j;
        }
    }
}
