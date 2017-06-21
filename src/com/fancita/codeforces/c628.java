package com.fancita.codeforces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ashutosh on 29/12/16.
 */
public class c628 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        int k = reader.readInt();
        String string = reader.readString();

        List<OBJ> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char c =  string.charAt(i);
            OBJ obj = new OBJ(c, i, Integer.max('z' - c, c - 'a'), ('z' - c) > (c - 'a')  ? 'z' : 'a');
            list.add(obj);
        }

        Collections.sort(list, new MaxSubtractionComparator());

        for (OBJ obj : list) {
            if (obj.maxSubtraction < k) {
                obj.ch = obj.replaceChar;
                k -= obj.maxSubtraction;
            } else if (obj.maxSubtraction >= k) {
                obj.ch = (obj.ch - k >= 'a' ? (char) (obj.ch - k) : (char) (obj.ch  + k));
                k = 0;
            }
        }

        if (k <= 0) {
            Collections.sort(list, new PositionInStringComparator());

            StringBuilder stringBuilder = new StringBuilder(n);
            for (OBJ obj : list) {
                stringBuilder.append(obj.ch);
            }

            writer.printLine(stringBuilder.toString());
        } else writer.printLine("-1");

        writer.flush();
        writer.close();
    }

    private static class OBJ  {
        char ch;
        int positionInString;
        int maxSubtraction;
        char replaceChar;

        public OBJ(char ch, int positionInString, int maxSubtraction, char replaceChar) {
            this.ch = ch;
            this.positionInString = positionInString;
            this.maxSubtraction = maxSubtraction;
            this.replaceChar = replaceChar;
        }
    }

    private static class MaxSubtractionComparator implements Comparator<OBJ> {

        @Override
        public int compare(OBJ o1, OBJ o2) {
            return o2.maxSubtraction - o1.maxSubtraction;
        }
    }

    private static class PositionInStringComparator implements Comparator<OBJ> {

        @Override
        public int compare(OBJ o1, OBJ o2) {
            return o1.positionInString - o2.positionInString;
        }
    }

}