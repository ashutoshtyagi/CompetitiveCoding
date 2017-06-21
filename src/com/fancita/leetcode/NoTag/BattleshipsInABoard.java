package com.fancita.leetcode.NoTag;

/**
 * Created by ashutosh on 17/3/17.
 */
public class BattleshipsInABoard {

    public static void main(String[] args) {
        char[][] board = new char[][] {{'x', '.', '.', 'x'}, {'.', '.', '.', 'x'}, {'.', '.', '.', 'x'}};
        System.out.println(new BattleshipsInABoard().countBattleships(board));
    }

    public int countBattleships(char[][] board) {
        int ret = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                ret = board[i][j] == 'x' && !checkAbove(board, i, j) && !checkLeft(board, i, j) ? ret + 1 : ret ;
            }
        }

        return ret;
    }

    private boolean checkAbove(char[][] board, int i, int j) {
        return i != 0 && board[i - 1][j] == 'x';
    }

    private boolean checkLeft(char[][] board, int i, int j) {
        return j != 0 && board[i][j-1] == 'x';
    }
}
