package com.fancita.codeforces;

/**
 * Created by ashutosh on 21/12/16.
 */
public class d386 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        int k = reader.readInt();
        int g = reader.readInt();
        int b = reader.readInt();

        char[] ret = new char[n];
        ret[0] = g > b ? 'G' : 'B';
        int countTillPrevChar = 1;
        if (ret[0] == 'G') {
            g--;
        } else b--;

        boolean needToPrint = true;

        for (int i = 1; i < n; i++) {
            char contendor = g > b ? 'G' : 'B';
            char insert;
            if (contendor == ret[i-1] && countTillPrevChar < k) {
                insert = contendor;
                ret[i] = insert;
                countTillPrevChar++;

            } else {
                insert = contendor != ret[i-1] ? contendor : contendor == 'G' ? 'B' : 'G';
                if ((insert == 'G' && g == 0) || (insert == 'B' && b == 0)) {
                    writer.printLine("NO");
                    needToPrint = false;
                    break;
                }
                ret[i] = insert;
                countTillPrevChar = 1;
            }
            if (insert == 'G') {
                g--;
            } else b--;
        }

        if (needToPrint)
            writer.printLine(new String(ret));
        writer.flush();
        writer.close();
    }
}

