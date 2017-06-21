package com.fancita.leetcode.BinarySearch;

import java.util.Arrays;

/**
 * Created by ashutosh on 26/4/17.
 */
public class Sqrt {
    public static void main(String[] args) {
        //System.out.println((float) 4.12 + (float) 0.002);
        //System.out.println(new Sqrt().sqrt(17, 5));
        //System.out.println(new Sqrt().decimalPlaces(17.000));
        System.out.println(new Sqrt().sqrt(2147483647));
        //System.out.println(new Sqrt().getDecimal(4, 2));
    }

    private float sqrt(int num, int decimalPlaces) {
        if(num == 0) return 0;
        float floor = sqrt(num);
        if(floor * floor == num) return floor;
        while(decimalPlaces(floor) < decimalPlaces) {
            int decimalPlacesFloor = decimalPlaces(floor);

            int left = 1, right = 9;
            while(left < right - 1) {
                int mid = left + (right - left) / 2;
                float decimalAdd = getDecimal(mid, decimalPlacesFloor + 1);
                float localFloor = (float) floor + (float) decimalAdd;
                if(localFloor * localFloor < num) left = mid;
                else if (localFloor * localFloor > num) right = mid - 1;
                else return localFloor;
            }
            /*
            float left = floor + getDecimal(1, decimalPlacesFloor + 1);
            float right = floor + getDecimal(9, decimalPlacesFloor + 1);
            while (left < right) {
                float mid = left + (right - left) / 2;
                if(mid * mid < num) left = mid;
                else if (mid * mid > num) right = mid - getDecimal(1, decimalPlacesFloor + 1);
                else return mid;
            }
            */
            float rightd = floor + getDecimal(right, decimalPlacesFloor + 1);

            floor = rightd * rightd < num ? rightd : floor + getDecimal(left, decimalPlacesFloor + 1);
        }
        return floor;
    }

    private float getDecimal(int num, int decimalPlacesFloor) {
        return (float) num / (float) (Math.pow(10, decimalPlacesFloor));
    }

    private int sqrt(int num) {
        int left = 1, right = num / 2;
        while(left < right - 1)  {
            int mid = left + (right - left) / 2;
            System.out.println(left + ", "  + right + ", " + mid + ", " + (mid * mid));
            if(mid * mid <= 0) {
                right = mid -1;
                continue;
            }
            if(mid * mid < num) left = mid;
            else if(mid * mid > num) right = mid - 1;
            else return mid;
        }
        return right * right >= 0 && right * right <= num ? right : left;
    }

    private int decimalPlaces(float num) {
        if(num == Math.ceil(num)) return 0;
        String str = String.valueOf(num);
        //System.out.println(Arrays.toString(str.split("\\.")));
        return str.contains(".") ? str.split("\\.")[1].length() : 0;
    }
}
