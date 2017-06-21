package com.fancita.codeforces.Contest812;

import java.io.*;
import java.util.InputMismatchException;

/**
 * Created by ashutosh on 1/6/17.
 */
public class B extends FastIO {
    public static void main(String[] args) {

        new B().execute();
    }

    public void execute() {

        int rows =  reader.readInt();
        int columns = reader.readInt() + 2;

        if (rows == 0 && columns == 2) {
            System.out.println("0");
            return;
        }

        int[] left_most = new int[rows];
        int[] right_most = new int[rows];

        int ans = 0, last = 0;

        for (int i = 0; i < rows; i++) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            String read = reader.readString();
            for (int j = 0; j < columns; j++) {
                if (read.charAt(j) == '1') {
                    min = Integer.min(min, j);
                    max = Integer.max(max, j);
                }
            }
            left_most[rows - 1 - i] = min;
            right_most[rows - 1 - i] = max;

            if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
                last += 1;
            } else {
                if (last > 0) {
                    ans += last;
                    last = 0;
                }
            }
        }

        if (rows == 1) {
            if (left_most[0] == 0 && right_most[0] == 0) {
                System.out.println("0");
                return;
            }
            System.out.println(right_most[0] < 0 ? "0" : right_most[0]);
            return;
        }

        int[][] f = new int[rows][4];
        f[0][0] = right_most[0] * 2;
        f[0][1] = columns - 1;
        f[0][2] = Integer.MAX_VALUE;
        f[0][3] = Integer.MAX_VALUE;

        for (int row = 1; row < rows - 1; row++) {
            f[row][0] = (right_most[row] == Integer.MIN_VALUE ? 1 : (right_most[row] + 1) * 2 - 1) + Integer.min(f[row - 1][0], f[row - 1][2]);
            f[row][1] = columns + Integer.min(f[row - 1][0], f[row - 1][2]);
            f[row][2] = columns + Integer.min(f[row - 1][1], f[row - 1][3]);
            f[row][3] = (left_most[row] == Integer.MAX_VALUE ? 1 : (columns - 1 - left_most[row] + 1)) * 2 - 1 + Integer.min(f[row - 1][1], f[row - 1][3]);
        }

        int print = Integer.min(
                (right_most[rows - 1] == Integer.MIN_VALUE ? 0 : right_most[rows - 1] + 1) + Integer.min(f[rows - 2][0], f[rows - 2][2]),
                (left_most[rows - 1] == Integer.MAX_VALUE ? 0 : columns - 1 - left_most[rows - 1] + 1) + Integer.min(f[rows - 2][1], f[rows - 2][3])
        );

        System.out.println(print < 0 ? "0" : print);
    }




}


class FastIO {

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
