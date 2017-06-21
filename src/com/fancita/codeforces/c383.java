package com.fancita.codeforces;

/**
 * Created by ashutosh on 6/12/16.
 */
public class c383 extends FastIO {
    public static void main(String[] args) {

        /*Random random = new Random();
        while (true) {
            int n = random.nextInt(10) + 1;
            writer.printLine("n = " + n);

            int[] arr = new int[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = random.nextInt(n) + 1;
            }

            int a = run(arr, n);
            int b = runBrute(arr, n);
            writer.printLine(a);
            writer.printLine(b);
            if (a != b) {
                writer.printLine("a != b");
                writer.printLine(Arrays.toString(arr));
                break;
            }
        }


        writer.flush();
        writer.close();*/

        int n = reader.readInt();
        int[] arr = new int[n+1];
        IOUtils.readIntArray(reader, arr, 1);
        writer.printLine(run(arr, n));
        writer.flush();
        writer.close();
    }

    public static int run(int[] arr, int maxIndex) {
        int ret = 1;
        boolean[] visited = new boolean[maxIndex+1];
        for (int i = 1; i <= maxIndex; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int start = i;
                int present = arr[i];
                int count = 1;
                while (start != present) {
                    if (visited[present]) {
                        count = Integer.MIN_VALUE;
                        break;
                    }
                    count++;
                    visited[present] = true;
                    present = arr[present];
                }
                if (count == Integer.MIN_VALUE) {
                    ret = Integer.MIN_VALUE;
                    break;
                } else count = count % 2 == 0 ? count / 2 : count;
                ret = lcm(ret, count);
            }
        }
        /*writer.print(ret < 0 ? -1 : ret);*/
        return ret < 0 ? -1 : ret;
    }

    public static int lcm(int a, int b) { return a * (b / gcd(a, b)); }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int runBrute(int[] arr, int maxIndex) {
        int maxT = maxIndex;
        int t;
        for (t = 1; t <= maxT; t++) {
            if (t == maxT) {
                break;
            }
            boolean done = true;
            for (int i = 1; i <= maxIndex; i++) {
                int tIter =  1;
                int next = arr[i];
                while (tIter != t) {
                    tIter++;
                    next = arr[next];
                }

                int start = next;
                tIter = 1;
                next = arr[start];
                while (tIter != t) {
                    tIter++;
                    next = arr[next];
                }

                if (next != arr[i]) {
                    done = false;
                    break;
                }
            }

            if (done) {
                break;
            }

        }
        if (t == maxT) {
            /*writer.print(-1);*/
            return -1;
        } else {
            /*writer.print(t);*/
            return t;
        }

    }
}

/*
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

        */
/**
         * Read items into array starting from a given point
         * @param in
         * @param arr
         * @param i is starting point
         *//*

        public static void readIntArray(InputReader in, int[] arr, int i) {
            int n = arr.length;
            for (int j = i; j < n; j++) {
                arr[j] = in.readInt();
            }
        }
    }
}
*/
