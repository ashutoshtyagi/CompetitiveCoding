package com.fancita.codeforces;

/**
 * Created by ashutosh on 29/12/16.
 */
public class a111Div1 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        long x = Long.valueOf(reader.readString());
        int y = reader.readInt();

        int minSqrtX = (int) Math.sqrt(x) + 1;
        int minValInAns = y - (n - 1);
        long compare = ((long)minValInAns) * ((long)minValInAns) + n - 1;
        if (minValInAns <= 0 || compare < x) {
            writer.printLine("-1");
        } else {
            for (int i = 0; i < n - 1; i++) {
                writer.print("1 ");
            }
            writer.printLine(minValInAns);
        }

        writer.flush();
        writer.close();
    }
}