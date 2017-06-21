package com.fancita.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ashutosh on 5/4/17.
 */
public class PermutationsII {

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[] {1,2,3}).toString());
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> mahaList = new ArrayList();

        if(nums.length == 0) return mahaList;

        List<Integer> numsList = new ArrayList<>(nums.length);
        for (int i : nums) numsList.add(i);

        recurse(mahaList, nums, numsList, 0, nums.length - 1);
        return mahaList;
    }

    private void recurse(List<List<Integer>> mahaList, int[] numsArr, List<Integer> nums, int i, int j) {
        if(i > j) {
            List<Integer> addList = new ArrayList(nums);
            //if(!mahaList.contains(addList))
                mahaList.add(addList);
            return;
        }

        for(int k = i; k <= j; k++) {
            //nums.remove(k);
            //if(nums.get(k).equals(nums.get(i))) continue;
            //System.out.println("i, k = " + i + ", " + k + ". val => " + numsArr[i] + ", " + numsArr[k]);
            if(i != k && nums.get(i) == nums.get(k)) continue;
            swap(nums, i, k);
            recurse(mahaList, numsArr, nums, i+1, j);
            swap(nums, i, k);

        }
    }

    private void swap(List<Integer> nums, int i, int j) {
        int a = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, a);
    }
}
