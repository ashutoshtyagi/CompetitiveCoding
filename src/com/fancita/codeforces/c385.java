package com.fancita.codeforces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashutosh on 17/12/16.
 */
public class c385 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt(), m = reader.readInt(), k = reader.readInt();

        boolean[] capital = new boolean[n+1];
        for (int i = 0; i < k; i++) {
            capital[reader.readInt()] = true;
        }

        boolean[][] matrix = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            matrix[reader.readInt()][reader.readInt()] = true;
        }

        List<check> list = new ArrayList<>();

    }

    class check {
        int nodes, edges;
    }
}
