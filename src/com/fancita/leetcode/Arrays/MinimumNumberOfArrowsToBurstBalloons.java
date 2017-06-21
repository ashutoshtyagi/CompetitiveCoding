package com.fancita.leetcode.Arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ashutosh on 23/3/17.
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points = new int[][] {
                {1,2},
                {2,3},
                {3,4},
                {4,5},
                {5,6}
        };
        System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int ret = 1;
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= right) {
                right = Integer.min(right, points[i][1]);
            } else {
                ret += 1;
                right = points[i][1];
            }
        }


        return ret;
    }
}
