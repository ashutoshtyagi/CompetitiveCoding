package com.fancita.codeforces;

import java.io.*;
import java.util.*;

/**
 * Created by ashutosh on 29/12/16.
 */
public class c5 extends FastIO {
    public static void main(String[] args) {
        String string = reader.readString();
        Deque<Integer> dequeStack = new ArrayDeque<>(string.length());
        List<Pair> pairs = new ArrayList<>(string.length() / 2);

        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == ')') {

                if (!dequeStack.isEmpty()) {
                    int dequeIndex = dequeStack.removeFirst();
                    pairs.add(new Pair(dequeIndex, i));
                }
            } else {
                dequeStack.addFirst(i);
            }
        }

        Collections.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.low - o2.low;
            }
        });


        int maxTillNow = 0;
        int count = 1;

        int presentFirstIndex = -2;
        int presentLastIndex = -2;

        for (Pair pair : pairs) {
            if (pair.low > presentFirstIndex && pair.high < presentLastIndex) {
                continue;
            } else if (pair.low == presentLastIndex + 1)  {
                presentLastIndex = pair.high;

            } else if (pair.low > presentLastIndex + 1) {
                if (presentFirstIndex >= 0 && presentLastIndex >= 0) {
                    int presentSize = presentLastIndex - presentFirstIndex + 1;
                    if (maxTillNow == presentSize) {
                        count++;
                    } else if (maxTillNow < presentSize) {
                        maxTillNow = presentSize;
                        count = 1;
                    }
                }
                presentFirstIndex = pair.low;
                presentLastIndex = pair.high;
            }
        }

        if (presentFirstIndex >= 0 && presentLastIndex >= 0) {
            int presentSize = presentLastIndex - presentFirstIndex + 1;
            if (maxTillNow == presentSize) {
                count++;
            } else if (maxTillNow < presentSize) {
                maxTillNow = presentSize;
                count = 1;
            }
        }

        writer.printLine(maxTillNow + " " + count);
        writer.flush();
        writer.close();
    }
}

class Pair {
    int low, high;

    public Pair(int low, int high) {
        this.low = low;
        this.high = high;
    }
}
