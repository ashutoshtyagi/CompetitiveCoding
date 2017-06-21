package com.fancita.leetcode.DP;

/**
 * Created by ashutosh on 29/3/17.
 */
public class RangeSumQuery2DImmutable {
    public static void main(String[] args) {
        /*NumMatrix numMatrix = new NumMatrix(new int[][] {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}});
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));*/

        NumMatrix numMatrix = new NumMatrix(new int[][] {{-4, -5}});
        System.out.println(numMatrix.sumRegion(0,0,0,0));
        System.out.println(numMatrix.sumRegion(0,0,0,1));
        System.out.println(numMatrix.sumRegion(0,1,0,1));

    }

    private static class NumMatrix {

        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            sum = new int[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    System.out.println("i = " + i + ", j = " + j + ", matrix[i][j] = " + matrix[i][j]);
                    sum[i][j] = matrix[i][j] + getValueFromSum(i, j - 1) + getValueFromSum(i - 1, j) - getValueFromSum(i - 1, j - 1);
                }
            }
        }

        private int getValueFromSum(int i, int j) {
            if(i < 0 || j < 0) return 0;
            return sum[i][j];
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2][col2] - getValueFromSum(row2, col1 - 1) - getValueFromSum(row1 - 1, col2) + getValueFromSum(row1 - 1, col1 - 1);
        }
    }
}
