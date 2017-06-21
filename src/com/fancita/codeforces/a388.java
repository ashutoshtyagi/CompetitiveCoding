package com.fancita.codeforces;

import java.io.*;
import java.util.InputMismatchException;

/**
 * Created by ashutosh on 19/12/16.
 */
public class a388 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        int noOf2s = 0;
        int noOf3s = 1;
        if (n % 2 == 0) {
            noOf2s = n / 2;
            writer.printLine(noOf2s);
            for (int i = 0; i < noOf2s; i++) {
                writer.print("2 ");
            }
        } else {
            noOf2s = (n - 3) / 2;
            writer.printLine(noOf2s + noOf3s);
            for (int i = 0; i < noOf2s; i++) {
                writer.print("2 ");
            }
            writer.print("3");
        }

        writer.flush();
        writer.close();
    }
}

