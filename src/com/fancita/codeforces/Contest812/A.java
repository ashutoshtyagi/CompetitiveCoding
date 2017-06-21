package com.fancita.codeforces.Contest812;

import java.io.*;
import java.util.InputMismatchException;

/**
 * Created by ashutosh on 1/6/17.
 */
public class A extends FastIO {
    public static void main(String[] args) {

        new A().execute();
    }

    public void execute() {
        int[][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = reader.readInt();
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 1 && (arr[i][3] == 1 || arr[getIndex(i, j)][3] == 1)) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }

    private static int getIndex(int i, int j) {
        switch (j) {
            case 0 :
                return (i + 3) % 4;
            case 1 :
                return (i + 2) % 4;
            case 2 :
                return (i + 1) % 4;
        }
        return 0;
    }

}
/*******************************/
