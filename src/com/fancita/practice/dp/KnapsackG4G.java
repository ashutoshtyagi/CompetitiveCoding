package com.fancita.practice.dp;

import java.io.*;
import java.util.InputMismatchException;

/**
 * Created by ashutosh on 18/12/16.
 */
public class KnapsackG4G extends FastIO {
    public static void main(String[] args) {
        int T = reader.readInt();
        while (T-- > 0) {
            int N = reader.readInt();
            int W = reader.readInt();
            int[] values = IOUtils.readIntArray(reader, N);
            int[] weights = IOUtils.readIntArray(reader, N);

            solveKnapsack(N, W, values, weights);
        }

        writer.flush();
        writer.close();
    }

    private static void solveKnapsack(int N, int W, int[] values, int[] weights) {
        int[][] dp = new int[W+1][N];

        for (int w = 0; w <= W; w++) {
            for (int i = 0; i < N; i++) {
                dp[w][i] = Integer.max(getValueFromDp(dp, w, i-1), values[i] + getValueFromDp(dp, w-weights[i], i-1));
            }
        }

        writer.printLine(dp[W][N-1]);
    }

    private static int getValueFromDp(int[][] dp, int w, int i) {
        if (w < 0) {
            return Integer.MIN_VALUE;
        }
        if (w == 0) {
            return 0;
        }
        if (i < 0) {
            return 0;
        }
        return dp[w][i];
    }
}

class FastIO {

    public static InputReader reader = new InputReader(System.in);
    public static OutputWriter writer	=	new OutputWriter(System.out);

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
         * @param i is starting point
         */
        public static void readIntArray(InputReader in, int[] arr, int i) {
            int n = arr.length;
            for (int j = i; j < n; j++) {
                arr[j] = in.readInt();
            }
        }
    }
}

