package com.fancita.leetcode.Tree;

/**
 * Created by ashutosh on 12/1/17.
 */
public class HouseRobberIII {
    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);*/
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(1);*/
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        System.out.println(new HouseRobberIII().rob(root));
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        retStruct ans = recurse(root);
        return Integer.max(ans.sumIncludingPresentNode, ans.sumOfLeftAndRightSubtrees);
    }

    private retStruct recurse(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return new retStruct(node.val,0);

        retStruct leftSubtree = recurse(node.left);
        retStruct rightSubtree = recurse(node.right);

        return new retStruct(node.val + (leftSubtree == null ? 0 : leftSubtree.sumOfLeftAndRightSubtrees) +
                (rightSubtree == null ? 0 : rightSubtree.sumOfLeftAndRightSubtrees),
                (leftSubtree == null ? 0 : Math.max(leftSubtree.sumIncludingPresentNode, leftSubtree.sumOfLeftAndRightSubtrees))
                        + (rightSubtree == null ? 0 : Math.max(rightSubtree.sumIncludingPresentNode, rightSubtree.sumOfLeftAndRightSubtrees)));
    }

    private class retStruct {
        int sumIncludingPresentNode, sumOfLeftAndRightSubtrees;

        public retStruct(int sumIncludingPresentNode, int sumOfLeftAndRightSubtrees) {
            this.sumIncludingPresentNode = sumIncludingPresentNode;
            this.sumOfLeftAndRightSubtrees = sumOfLeftAndRightSubtrees;
        }
    }
}
