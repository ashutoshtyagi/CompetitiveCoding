package com.fancita.codeforces;

import com.fancita.utils.FastIO;

/**
 * Created by fancita on 13/11/16.
 */
public class b520 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        int m = reader.readInt();
        run(n, m);
        writer.flush();
        writer.close();
    }

    public static void run(int n, int m) {
        int ret = 0;
        while (n < m) {
            ret += m % 2 == 0 ? 1 : 2;
            m = (int) Math.ceil( ((double) m) / 2);
        }
        ret += n - m;
        writer.print(ret);
    }
}