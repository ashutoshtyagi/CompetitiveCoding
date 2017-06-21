package com.fancita.codechef.practice_medium;


import java.io.*;
import java.util.InputMismatchException;

/**
 * Created by ashutosh on 30/5/17.
 * PALIN
 */
public class TheNextPalindrome {

    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        
        int testCases = fastIO.reader.readInt();
        while (testCases-- > 0) {
            String num = fastIO.reader.readString();
            System.out.println(findNextPalindrome(num));
        }
    }

    private static String findNextPalindrome(String num) {
        if (containsAllNines(num)) {
            return String.valueOf(Long.valueOf(num) + 2);
        }
        if (num.length() == 1) {
            if (num.equals("9")) return "11";
            return String.valueOf(Long.valueOf(num) + 1);
        }
        return num.length() % 2 == 0 ? findNextPalindromeEven(num) : findNextPalindromeOdd(num);
    }

    private static String findNextPalindromeOdd(String num) {
        String firstHalf = num.substring(0, (num.length() / 2) + 1);
        String firstPartOfFirstHalf = firstHalf.substring(0, firstHalf.length() - 1);
        String reversed = firstHalf + reverse(firstPartOfFirstHalf);
        if(Long.valueOf(reversed) > Long.valueOf(num)) {
            return reversed;
        }

        firstHalf = String.valueOf(Long.valueOf(firstHalf) + 1);
        firstPartOfFirstHalf = firstHalf.substring(0, firstHalf.length() - 1);
        reversed = firstHalf + reverse(firstPartOfFirstHalf);
        return reversed;
    }

    private static String findNextPalindromeEven(String num) {
        String firstHalf = num.substring(0, num.length() / 2);
        String reversed = reverse(firstHalf);
        if(Long.valueOf(firstHalf + reversed) > Long.valueOf(num)) {
            return firstHalf + reversed;
        }

        firstHalf = String.valueOf(Long.valueOf(firstHalf) + 1);
        reversed = reverse(firstHalf);
        return firstHalf + reversed;
    }

    private static boolean containsAllNines(String string) {
        char[] in = string.toCharArray();
        for (int i = 0; i < in.length; i++) {
            if (in[i] != '9') return false;
        }
        return true;
    }

    public static String reverse(String input){
        char[] in = input.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }

    private static class FastIO {

        public static InputReader reader;
        public static OutputWriter writer;

        public FastIO() {
            reader = new InputReader(System.in);
            writer	=	new OutputWriter(System.out);
        }

        public FastIO(InputStream inputStream) {
            reader = new InputReader(inputStream);
            writer	=	new OutputWriter(System.out);
        }

        public static class InputReader {

            private InputStream stream;
            private byte[] buf = new byte[1024];
            private int curChar;
            private int numChars;
            private InputReader.SpaceCharFilter filter;

            public InputReader(InputStream stream) {
                this.stream = stream;
            }

            public int read() {
                if (numChars == -1)
                    throw new InputMismatchException();
                if (curChar >= numChars) {
                    curChar = 0;
                    try {
                        numChars = stream.read(buf);
                    } catch (IOException e) {
                        throw new InputMismatchException();
                    }
                    if (numChars <= 0)
                        return -1;
                }
                return buf[curChar++];
            }

            public int readInt() {
                int c = read();
                while (isSpaceChar(c))
                    c = read();
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = read();
                }
                int res = 0;
                do {
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = read();
                } while (!isSpaceChar(c));
                return res * sgn;
            }

            public String readString() {
                int c = read();
                while (isSpaceChar(c))
                    c = read();
                StringBuilder res = new StringBuilder();
                do {
                    res.appendCodePoint(c);
                    c = read();
                } while (!isSpaceChar(c));
                return res.toString();
            }

            public boolean isSpaceChar(int c) {
                if (filter != null)
                    return filter.isSpaceChar(c);
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }

            public String next() {
                return readString();
            }

            public interface SpaceCharFilter {
                public boolean isSpaceChar(int ch);
            }
        }

        public static class OutputWriter {
            private final PrintWriter writer;

            public OutputWriter(OutputStream outputStream) {
                writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
            }

            public OutputWriter(Writer writer) {
                this.writer = new PrintWriter(writer);
            }

            public void print(Object... objects) {
                for (int i = 0; i < objects.length; i++) {
                    if (i != 0)
                        writer.print(' ');
                    writer.print(objects[i]);
                }
            }

            public void printLine(Object... objects) {
                print(objects);
                writer.println();
            }

            public void close() {
                writer.close();
            }

            public void flush() {
                writer.flush();
            }

        }

        public static class IOUtils {

            public static int[] readIntArray(InputReader in, int size) {
                int[] array = new int[size];
                for (int i = 0; i < size; i++)
                    array[i] = in.readInt();
                return array;
            }

            /**
             * Read items into array starting from a given point
             * @param in
             * @param arr
             * @param i
             */
            public static void readIntArray(InputReader in, int[] arr, int i) {
                int n = arr.length;
                for (int j = i; j < n; j++) {
                    arr[j] = in.readInt();
                }
            }
        }
    }


}


/**
 * Created by fancita on 1/11/16.
 */
