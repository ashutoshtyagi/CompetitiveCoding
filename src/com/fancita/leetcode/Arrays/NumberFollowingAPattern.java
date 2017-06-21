package com.fancita.leetcode.Arrays;

import java.util.Scanner;

/**
 * Created by ashutosh on 23/4/17.
 */
public class NumberFollowingAPattern {

    public static void main (String[] args) {
        //code

        Scanner in = new Scanner(System.in);
        int t = Integer.valueOf(in.nextLine()); //number of test cases

        for(int i = 0; i < t; i++){//each test case
            String inp = in.nextLine();
            //System.out.println(inp);
            System.out.println(function(inp));
        }

    }

    private static String function(String inp) {
        //System.out.println(inp);
        StringBuilder ans = new StringBuilder(inp.length() + 2);
        boolean[] nums = new boolean[10];
        for(int i = 1; i <= 9; i++) {
            ans.append("" + i);
            nums[i] = true;
            boolean ret = recurse(inp, ans, 0, nums);
            if(ret) break;
            nums[i] = false;
            ans.setLength(0);
        }
        return ans.toString();
    }

    private static boolean recurse(String inp, StringBuilder ans, int index, boolean[] nums) {
        if(index == inp.length()) {
            return true;
        }

        //System.out.println(ans);

        int last = ans.charAt(ans.length() - 1) - '0';

        if(inp.charAt(index) == 'I') {
            for(int i = 1; i <= 9; i++) {
                if(!nums[i] && i > last) {
                    nums[i] = true;
                    ans.append(i);
                    boolean ret = recurse(inp, ans, index + 1, nums);
                    if(ret) return true;
                    ans.setLength(ans.length() - 1);
                    //ans = ans.substring(0, ans.length() - 1);
                    nums[i] = false;
                }
            }
        } else {
            for(int i = 1; i <= 9; i++) {
                if(!nums[i] && i < last) {
                    nums[i] = true;
                    ans.append(i);
                    boolean ret = recurse(inp, ans, index + 1, nums);
                    if(ret) return true;
                    ans.setLength(ans.length() - 1);
                    nums[i] = false;
                }
            }
        }

        return false;
    }
}