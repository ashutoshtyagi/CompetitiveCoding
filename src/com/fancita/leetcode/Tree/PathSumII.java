package com.fancita.leetcode.Tree;

import java.util.*;

/**
 * Created by ashutosh on 8/1/17.
 */
public class PathSumII {
    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);
        List<List<Integer>> ret = new PathSumII().pathSum(root, 22);*/
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        List<List<Integer>> ret = new PathSumII().pathSum(root, -5);
        System.out.println(Arrays.toString(ret.toArray()));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> outerList = new ArrayList<>();
        Deque<Integer> innerDeque = new LinkedList<>();
        rootToLeafPath(root, sum, outerList, innerDeque);
        return outerList;
    }

    private void rootToLeafPath(TreeNode node, int leftOverSum, List<List<Integer>> outerList, Deque<Integer> innerDeque) {
        if (node == null /*|| leftOverSum - node.val < 0*/) {
            return;
        } else if (leftOverSum - node.val == 0) {
            if (node.left == null && node.right == null) {
                innerDeque.addLast(node.val);
                List<Integer> toAdd = new LinkedList<>(innerDeque);
                outerList.add(toAdd);
                innerDeque.removeLast();
            } else {
                innerDeque.addLast(node.val);
                rootToLeafPath(node.left, leftOverSum - node.val, outerList, innerDeque);
                rootToLeafPath(node.right, leftOverSum - node.val, outerList, innerDeque);
                innerDeque.removeLast();
            }
            return;
        } else {
            innerDeque.addLast(node.val);
            rootToLeafPath(node.left, leftOverSum - node.val, outerList, innerDeque);
            rootToLeafPath(node.right, leftOverSum - node.val, outerList, innerDeque);
            innerDeque.removeLast();
            return;
        }
    }

    private void anyPath(TreeNode node, int leftOverSum, List<List<Integer>> outerList, Deque<Integer> innerDeque) {
        if (node == null || leftOverSum - node.val < 0) {
            return;
        } else if (leftOverSum - node.val == 0) {
            innerDeque.addLast(node.val);
            List<Integer> toAdd = new LinkedList<>(innerDeque);
            outerList.add(toAdd);
            innerDeque.removeLast();
            return;
        } else {
            innerDeque.addLast(node.val);
            rootToLeafPath(node.left, leftOverSum - node.val, outerList, innerDeque);
            rootToLeafPath(node.right, leftOverSum - node.val, outerList, innerDeque);
            innerDeque.removeLast();
            return;
        }
    }
}
