package com.fancita.codeforces;

import com.fancita.utils.FastIO;

import java.io.*;
import java.util.InputMismatchException;

/**
 * Created by ashutosh on 6/12/16.
 */
public class a383 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        int mod = n % 4;
        if (mod == 0 && n != 0) {
            writer.print(6);
        } else if (mod == 1) {
            writer.print(8);
        } else if (mod == 2) {
            writer.print(4);
        } else if (mod == 3) {
            writer.print(2);
        } else if (n == 0) {
            writer.print(1);
        }

        writer.flush();
        writer.close();
    }
}

