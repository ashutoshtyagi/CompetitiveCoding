package com.fancita.leetcode.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashutosh on 12/1/17.
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSumIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        System.out.println(new PathSumIII().pathSum(root, 8));
    }

    /*private int count = 0;*/

    public int pathSum(TreeNode root, int sum) {
        // TODO initial capacity? when given number of nodes
        Map<Integer, Integer> hashMap = new HashMap<>(100);
        hashMap.put(0, 1);
        int count = recurse(root, 0, sum, hashMap);
        return count;
    }

    private int recurse(TreeNode node, int sumTillNow, int targetSum, Map<Integer, Integer> hashmap) {
        if (node == null) return 0;

        int countRet = 0;
        int sumIncludingCurrent = sumTillNow + node.val;
        if (hashmap.containsKey(sumIncludingCurrent - targetSum)) {
            /*count += hashmap.get(sumIncludingCurrent - targetSum);*/
            countRet += hashmap.get(sumIncludingCurrent - targetSum);
        }

        hashmap.put(sumIncludingCurrent, hashmap.getOrDefault(sumIncludingCurrent, 0) + 1);

        countRet += recurse(node.left, sumIncludingCurrent, targetSum, hashmap);
        countRet += recurse(node.right, sumIncludingCurrent, targetSum, hashmap);

        hashmap.put(sumIncludingCurrent, hashmap.get(sumIncludingCurrent) - 1);

        return countRet;
    }
}
