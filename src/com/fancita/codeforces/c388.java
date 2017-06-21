package com.fancita.codeforces;

import java.io.*;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ashutosh on 19/12/16.
 */
public class c388 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        String inp =  reader.readString();

        Queue<Integer> queueD = new LinkedList<>();
        Queue<Integer> queueR = new LinkedList<>();

        // initial fill
        for (int i = 0; i < inp.length(); i++) {
            char c = inp.charAt(i);
            if (c == 'D') {
                queueD.add(i);
            } else if (c == 'R') {
                queueR.add(i);
            }
        }

        while (queueD.size() != 0 && queueR.size() != 0) {
            int d = queueD.poll();
            int r = queueR.poll();

            if (d < r) {
                queueD.add(d + n);
            } else queueR.add(r + n);
        }

        writer.printLine(queueD.size() != 0 ? "D" : "R");

        writer.flush();
        writer.close();
    }
}


