package com.fancita.codeforces;

/**
 * Created by ashutosh on 18/12/16.
 */
public class a386 extends FastIO {
    public static void main(String[] args) {
        int a = reader.readInt();
        int b = reader.readInt();
        int c = reader.readInt();

        while (a > 0) {
            int a2 = a * 2;
            int a4 = a * 4;
            if (a2 <= b && a4 <= c) {
                break;
            } else a--;
        }

        if (a == 0) {
            writer.printLine("0");
        } else {
            writer.printLine((a + 2*a + 4*a));
        }

        writer.flush();
        writer.close();
    }
}



