/*package com.fancita.codeforces;*/

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by ashutosh on 18/12/16.
 */
public class d383 extends FastIO {
    public static void main(String[] args) {
        int V = reader.readInt(); // no of hoses
        int E = reader.readInt(); // pair of friends / edges in graph
        int W = reader.readInt(); // maximum total weight of knapsack

        int[] weights = IOUtils.readIntArray(reader, V);
        int[] values = IOUtils.readIntArray(reader, V);

        Graph G = new Graph(V);
        for (int e = 0; e < E; e++) {
            G.addEdge(reader.readInt() - 1, reader.readInt() - 1);
        }

        ConnectedComponents cc = new ConnectedComponents(G);

        List<Integer>[] components = new List[cc.count()];
        int[] componentWeights = new int[cc.count()];
        int[] componentValues = new int[cc.count()];

        for (int i = 0; i < cc.count(); i++) {
            components[i] = new ArrayList<>();
        }

        for (int v = 0; v < V; v++) {
            components[cc.id(v)].add(v);
            componentValues[cc.id(v)] += values[v];
            componentWeights[cc.id(v)] += weights[v];
        }

        solveKnapsack(cc.count(), W, componentValues, componentWeights, components, values, weights);

        writer.flush();
        writer.close();
    }

    private static void solveKnapsack(int numberOfComponents, int maxWeightOfKnapsack,
                                      int[] componentValues, int[] componentWeights,
                                      List<Integer>[] components, int[] individualValues, int[] individualWeights) {
        int[][] dp = new int[maxWeightOfKnapsack+1][numberOfComponents];

        for (int w = 0; w <= maxWeightOfKnapsack; w++) {
            for (int i = 0; i < numberOfComponents; i++) {
                dp[w][i] = Integer.max(getValueFromDp(dp, w, i-1),
                                        componentValues[i] + getValueFromDp(dp, w-componentWeights[i], i-1));

                List<Integer> list = components[i];
                for (int individual : list) {
                    dp[w][i] = Integer.max(dp[w][i],
                            individualValues[individual] + getValueFromDp(dp, w - individualWeights[individual], i-1));
                }
            }
        }

        writer.printLine(dp[maxWeightOfKnapsack][numberOfComponents-1]);
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

class Graph {

    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new List[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();
    }

    /*public Graph(com.fancita.utils.FastIO.InputReader inputReader) {
        this(inputReader.readInt());
        int E = inputReader.readInt();
        for (int i = 0; i < E; i++) {
            int v = inputReader.readInt();
            int w = inputReader.readInt();
            addEdge(v, w);
        }
    }*/

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}

class ConnectedComponents {
    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponents(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w])
                dfs(G, w);
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
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

