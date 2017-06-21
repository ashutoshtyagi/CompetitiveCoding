package com.fancita.leetcode.Arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ashutosh on 27/3/17.
 */
public class FindRightInterval {

    public static void main(String[] args) {
        FindRightInterval findRightInterval = new FindRightInterval();
        System.out.println(Arrays.toString(findRightInterval.findRightInterval(new Interval[] {
                new Interval(3,4), new Interval(2,3), new Interval(1, 2)
        })));
    }

    public int[] findRightInterval(Interval[] intervals) {
        RetInterval[] retIntervals = new RetInterval[intervals.length];

        for (int i = 0; i < retIntervals.length; i++) {
            retIntervals[i] = new RetInterval(i, intervals[i]);
        }

        // 1. sort
        Arrays.sort(retIntervals, new Comparator<RetInterval>() {
            @Override
            public int compare(RetInterval o1, RetInterval o2) {
                return o1.interval.start - o2.interval.start;
            }
        });

        // 2. create final indexes array
        int[] ret = new int[retIntervals.length];

        // 3. binary search
        binarySearch(retIntervals, ret);

        // 4. return final indexes array
        return ret;
    }

    private void binarySearch(RetInterval[] retIntervals, int[] ret) {
        for (int i = 0; i < retIntervals.length; i++) {
            ret[retIntervals[i].originalIndex] = iterateBS(retIntervals, i + 1, retIntervals[i].interval.end);
        }
    }

    private int iterateBS(RetInterval[] retIntervals, int leftIndexInclusive, int searchItem) {
        int left = leftIndexInclusive, right = retIntervals.length - 1;
        int ret = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (retIntervals[mid].interval.start == searchItem) {
                ret = retIntervals[mid].originalIndex;
                break;
            } else if (retIntervals[mid].interval.start > searchItem) {
                ret = retIntervals[mid].originalIndex;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ret;
    }

    class RetInterval {
        int originalIndex;
        Interval interval;

        public RetInterval(int originalIndex, Interval interval) {
            this.originalIndex = originalIndex;
            this.interval = interval;
        }
    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}

