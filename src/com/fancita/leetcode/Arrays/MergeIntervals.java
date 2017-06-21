package com.fancita.leetcode.Arrays;

import java.util.*;

/**
 * Created by ashutosh on 3/12/16.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        new MergeIntervals().run();
    }

    private void run() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(15, 18));
        List<Interval> ans = merge(intervals);
        System.out.println("Arrays.toString(ans.toArray()) = " + Arrays.toString(ans.toArray()));
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return Collections.emptyList();
        }

        intervals.sort(new IntervalComparator());

        List<Interval> ret = new ArrayList<>();

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval presentInterval = intervals.get(i);
            if (end >= presentInterval.start) {
                end = Integer.max(end, presentInterval.end);
            } else {
                ret.add(new Interval(start, end));
                start = presentInterval.start;
                end = presentInterval.end;
            }
        }
        ret.add(new Interval(start, end));
        return ret;
    }

    private class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }

    private class Interval {
        public int start;
        public int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
