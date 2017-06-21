package com.fancita.leetcode.Tree;

import com.fancita.leetcode.LinkedList.*;

import java.util.Arrays;

/**
 * Created by ashutosh on 6/1/17.
 */
public class BinaryTreeFromInorderAndPreorder {
    public static void main(String[] args) {
        /*int[] inorder = new int[] {1, 2, 3, 4, 5, 6};
        int[] preorder = new int[] {3, 1, 2, 5, 4, 6};*/
        int[] inorder = new int[] {2, 1};
        int[] preorder = new int[] {1, 2};
        TreeNode root = new BinaryTreeFromInorderAndPreorder().buildTree(preorder, inorder);
        System.out.println(Arrays.toString(new IterativeInorder().inorderTraversal(root).toArray()));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return recurse(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode recurse(int[] preorder, int preorderi, int preorderj,
                            int[] inorder, int inorderi, int inorderj) {
        if (preorderi > preorderj) {
            return null;
        }

        TreeNode presentNode = new TreeNode(preorder[preorderi]);

        /*int indexOfPresentNodeInInorder = binarySearch(inorder, inorderi, inorderj, preorder[preorderi]);*/
        int indexOfPresentNodeInInorder = linearSearch(inorder, inorderi, inorderj, preorder[preorderi]);
        /*if (indexOfPresentNodeInInorder == -1) {
            return null;
        }*/

        int sizeOfLeftSubTree = indexOfPresentNodeInInorder - inorderi;
        int sizeOfRightSubtree = inorderj - indexOfPresentNodeInInorder;

        TreeNode left = recurse(preorder, preorderi + 1, preorderi + sizeOfLeftSubTree,
                inorder, inorderi, indexOfPresentNodeInInorder - 1);
        TreeNode right = recurse(preorder,preorderi + sizeOfLeftSubTree + 1, preorderj,
                inorder,indexOfPresentNodeInInorder + 1, inorderj);

        presentNode.left = left;
        presentNode.right = right;

        return presentNode;
    }

    public int linearSearch(int[] inorder, int i, int j, int numberToSearch) {
        int ret = i;
        for (int it = i; it <= j; it++) {
            if (inorder[it] == numberToSearch) {
                ret = it;
                break;
            }
        }
        return ret;
    }

    public int binarySearch(int[] inorder, int i, int j, int numberToSearch) {
        int low, high, mid = -1;
        low = i; high = j;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (inorder[mid] < numberToSearch) {
                low = mid + 1;
            } else if (inorder[mid] > numberToSearch) {
                high = mid - 1;
            } else if (inorder[mid] == numberToSearch) {
                low = high = mid;
                break;
            }
        }

        return mid == -1 ? -1 : inorder[mid] == numberToSearch ? mid : -1;
    }
}
