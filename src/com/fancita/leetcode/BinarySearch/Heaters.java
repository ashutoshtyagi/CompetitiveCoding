package com.fancita.leetcode.BinarySearch;

import java.util.Arrays;

/**
 * Created by ashutosh on 13/1/17.
 */
public class Heaters {
    public static void main(String[] args) {
        int[] houses = new int[] {1,2,3,4};
        int[] heaters = new int[] {1,4};
        System.out.println(new Heaters().findRadius(houses, heaters));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            max = Integer.max(max, binarySearch(houses[i], heaters));
        }
        return max;
    }

    private int binarySearch(int house, int[] heaters) {
        int contender = -1;
        int left = 0, right = heaters.length -  1;

        // loop
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (house == heaters[mid]) {
                contender = mid;
                break;
            }
            if (house > heaters[mid]) {
                contender = Integer.max(contender, mid);
                left = mid +  1;
            } else if (house < heaters[mid]) {
                right = mid - 1;
            }
        }

        if (contender == -1) {
            return heaters[0] - house;
        } else if (contender == heaters.length - 1) {
            return house - heaters[heaters.length - 1];
        } else {
            return Integer.min(house - heaters[contender], heaters[contender + 1] - house);
        }
    }
}
