package com.fancita.leetcode.BinarySearch;

/**
 * Created by ashutosh on 14/1/17.
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        System.out.println(new SearchA2DMatrix().searchMatrix(matrix,0));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix.length == 1 && matrix[0].length == 0) return false;
        int row = getRow(matrix, target);
        if (row == -1) return false;
        return binarySearchIsPresent(matrix[row], target);
    }

    private int getRow(int[][] matrix, int target) {
        int contender = -1;
        int left =  0, right = matrix.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) return mid;
            if (matrix[mid][0] < target) {
                contender = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return contender;
    }

    private boolean binarySearchIsPresent(int[] matrixRow, int target) {
        int left = 0, right = matrixRow.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrixRow[mid] == target) return true;
            if (matrixRow[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
