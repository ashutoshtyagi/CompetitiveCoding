package com.fancita.leetcode.Tree;

/**
 * Created by ashutosh on 8/1/17.
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class DeleteNodeInBST {

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);*/
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(new IterativeInorder().recursiveInorderTraversal(new DeleteNodeInBST().deleteNode(root, 1)));
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        TreeNode searchParent = null;
        TreeNode search = root;

        while (search != null) {
            if (key < search.val) {
                searchParent = search;
                search = search.left;
            } else if (key > search.val) {
                searchParent = search;
                search = search.right;
            } else if (key == search.val) {
                break;
            }
        }

        if (search == null) {
            return root;
        }

        TreeNode candidateParent = search;
        TreeNode candidate = null;

        // search candidate
        if (search.left != null) {
            candidate = search.left;
            while (candidate.right != null) {
                candidateParent = candidate;
                candidate = candidate.right;
            }
        } else if (search.right != null) {
            candidate = search.right;
            while (candidate.left != null) {
                candidateParent = candidate;
                candidate = candidate.left;
            }
        } else {
            if (searchParent == null) {
                return null;
            }

            if (search.val < searchParent.val) {
                searchParent.left = null;
            } else {
                searchParent.right = null;
            }

            return root;
        }

        if (candidate.val > candidateParent.val) {
            candidateParent.right = candidate.left;
        } else if (candidate.val < candidateParent.val) {
            candidateParent.left = candidate.right;
        }

        candidate.left = search.left;
        candidate.right = search.right;

        if (searchParent != null) {
            if (search.val < searchParent.val) {
                searchParent.left = candidate;
            } else {
                searchParent.right = candidate;
            }
        } else {
            return candidate;
        }

        return root;
    }
}
