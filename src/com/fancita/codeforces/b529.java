package com.fancita.codeforces;

import com.fancita.utils.FastIO;

/**
 * Created by fancita on 13/11/16.
 */
public class b529 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        writer.print((long) Math.pow(n - 2, 2));
        writer.flush();
        writer.close();
    }
}

