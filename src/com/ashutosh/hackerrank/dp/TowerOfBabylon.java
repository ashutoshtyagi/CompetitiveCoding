package com.ashutosh.hackerrank.dp;

import java.util.*;

/**
 * Created by ashutosh on 1/11/16.
 * http://www.spoj.com/problems/BABTWR/
 */
public class TowerOfBabylon {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n;
        while ((n = reader.nextInt()) != 0) {

            List<Box> list = new ArrayList<>(3*n);

            for (int i = 0; i < n; i++) {
                int[] arr = new int[3];
                arr[0] = reader.nextInt();
                arr[1] = reader.nextInt();
                arr[2] = reader.nextInt();

                Arrays.sort(arr);

                list.add(new TowerOfBabylon.Box(arr[0], arr[1], arr[2]));
                list.add(new TowerOfBabylon.Box(arr[1], arr[0], arr[2]));
                list.add(new TowerOfBabylon.Box(arr[2], arr[0], arr[1]));
            }

            System.out.println(getLIS(list));
        }
    }

    private static long getLIS(List<Box> list) {
        /*Collections.sort(list, new areaComparator());*/
        Collections.sort(list, new dComparator());

        long[] dp = new long[list.size()];
        long maxTillNow = Long.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            dp[i] = list.get(i).h;
            for (int j = i; j >= 0; j--) {
                /*dp[i] = Long.max(dp[i], list.get(j).w > list.get(i).w ? dp[j] + list.get(i).h : 0);*/
                dp[i] = Long.max(dp[i], list.get(j).compareTo(list.get(i)) > 0 ? dp[j] + list.get(i).h : 0);
            }
            maxTillNow = Long.max(maxTillNow, dp[i]);
        }

        return maxTillNow;
    }

    private static class Box implements Comparable<Box>{
        int h, w, d;

        public Box(int h, int w, int d) {
            this.h = h;
            this.w = w;
            this.d = d;
        }

        @Override
        public int compareTo(Box o) {
            return (this.d - o.d) * (this.w - o.w);
            /*return this.w - o.w;*/
        }
    }

    private static class dComparator implements Comparator<Box> {
        @Override
        public int compare(Box o1, Box o2) {
            return o2.d - o1.d;
        }
    }
}
