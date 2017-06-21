package com.fancita.codeforces;

/**
 * Created by ashutosh on 17/12/16.
 */
public class b385 extends FastIO {
    public static void main(String[] args) {
        int rows = reader.readInt();
        int columns = reader.readInt();
        int numberOfStars = 0;
        int rightMost = Integer.MIN_VALUE, bottomMost = Integer.MIN_VALUE;
        int leftMost = Integer.MAX_VALUE, topMost = Integer.MAX_VALUE;

        for (int r = 0; r < rows; r++) {
            String input = reader.readString();
            for (int c = 0; c < columns; c++) {
                char presentChar = input.charAt(c);
                if (presentChar == 'X') {
                    leftMost = Integer.min(leftMost, c);
                    topMost = Integer.min(topMost, r);
                    rightMost = Integer.max(rightMost, c);
                    bottomMost = Integer.max(bottomMost, r);
                    numberOfStars++;
                }
            }
        }

        writer.printLine( numberOfStars == (rightMost - leftMost + 1) * (bottomMost - topMost + 1) ? "YES" :  "NO");

        writer.flush();
        writer.close();

    }
}
