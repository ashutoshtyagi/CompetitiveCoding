package com.fancita.codeforces;

/**
 * Created by fancita on 12/11/16.
 */
public class b688 extends FastIO {

    public static void main(String[] args) {
        String n = reader.readString();
        writer.print(reverseString(n));
        writer.flush();
        writer.close();
    }

    public static String reverseString(String string) {
        return string + new StringBuilder(string).reverse().toString();
    }
}
