package com.ashutosh.hackerrank.Graph;

import java.io.*;
import java.util.*;

/**
 * Created by ashutosh on 1/11/16.
 * https://www.hackerrank.com/challenges/dijkstrashortreach
 */
public class DijkstraAlgorithmAdjacencyList {

    private static InputReader reader;
    private static OutputWriter writer;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        /*Scanner reader = new Scanner(System.in);*/
        reader 		= new InputReader(System.in);
        writer	=	new OutputWriter(System.out);

        int t = reader.readInt();

        while (t > 0) {
            t--;

            int numberOfVertices = reader.readInt();

            ArrayList<Node>[] graph = (ArrayList<Node>[]) new ArrayList[numberOfVertices];

            int numberOfEdges = reader.readInt();

            for (int i = 0; i < numberOfEdges; i++) {

                int firstIndex = reader.readInt();
                int secondIndex = reader.readInt();
                int value = reader.readInt();

                Node secondIndexNode = new Node(secondIndex - 1, value);
                if (graph[firstIndex - 1] == null) {
                    graph[firstIndex - 1] = new ArrayList<>();
                }
                List<Node> firstIndexList = graph[firstIndex - 1];
                if (firstIndexList.contains(secondIndexNode)) {
                    int index = firstIndexList.indexOf(secondIndexNode);
                    Node nodeFromList = firstIndexList.get(index);
                    if (nodeFromList.distance > value) {
                        nodeFromList.distance = value;
                    }
                } else {
                    firstIndexList.add(secondIndexNode);
                }

                Node firstIndexNode = new Node(firstIndex - 1, value);
                if (graph[secondIndex - 1] == null) {
                    graph[secondIndex - 1] = new ArrayList<>();
                }
                List<Node> secondIndexList = graph[secondIndex - 1];
                if (secondIndexList.contains(firstIndexNode)) {
                    int index = secondIndexList.indexOf(firstIndexNode);
                    Node nodeFromList = secondIndexList.get(index);
                    if (nodeFromList.distance > value) {
                        nodeFromList.distance = value;
                    }
                } else {
                    secondIndexList.add(firstIndexNode);
                }
            }

            int startingPosition = reader.readInt() - 1;

            printShortestPathsUsingDijkstra(graph, startingPosition);

            writer.flush();
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        writer.printLine("TIME TAKEN = " + elapsedTime);
        writer.flush();

        writer.close();
    }

    private static void printShortestPathsUsingDijkstra(ArrayList<Node>[] graph, int startingPosition) {
        /*long startTime = System.currentTimeMillis();*/

        int[] retArr = new int[graph.length];
        Arrays.fill(retArr, Integer.MAX_VALUE);
        retArr[startingPosition] = 0;

        PriorityQueue<PriorityQueueNode> priorityQueue = new PriorityQueue<>(graph.length);
        priorityQueue.add(new PriorityQueueNode(startingPosition, 0));

        while (!priorityQueue.isEmpty()) {

            PriorityQueueNode node = priorityQueue.poll();
            int indexOfNode = node.index;

            for (Node listNode : graph[indexOfNode]) {
                int i = listNode.index;

                int minDistUsingThisNode = node.minDistanceToThisNodeTillNow + listNode.distance;

                if (minDistUsingThisNode < retArr[i]) {
                    PriorityQueueNode newNode = new PriorityQueueNode(i, minDistUsingThisNode);
                    priorityQueue.remove(newNode);
                    priorityQueue.add(newNode);
                    retArr[i] = minDistUsingThisNode;
                }
            }

        }

        for (int i = 0; i < retArr.length; i++) {
            if (i != startingPosition) {
                writer.print((retArr[i] == Integer.MAX_VALUE ? -1 : retArr[i]) + " ");
            }
        }
        writer.printLine();

        /*long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        writer.printLine(elapsedTime);*/
    }

    private static class PriorityQueueNode implements Comparable<PriorityQueueNode> {
        int index;
        int minDistanceToThisNodeTillNow;

        public PriorityQueueNode(int index) {
            this.index = index;
        }

        public PriorityQueueNode(int index, int minDistanceToThisNodeTillNow) {
            this.index = index;
            this.minDistanceToThisNodeTillNow = minDistanceToThisNodeTillNow;
        }

        @Override
        public int compareTo(PriorityQueueNode o) {
            return this.minDistanceToThisNodeTillNow - o.minDistanceToThisNodeTillNow;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PriorityQueueNode that = (PriorityQueueNode) o;

            return index == that.index;

        }

        @Override
        public int hashCode() {
            return index;
        }
    }

    private static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index) {
            this.index = index;
        }

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node that = (Node) o;

            return index == that.index;

        }

        @Override
        public int hashCode() {
            return index;
        }
    }


    private static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

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

    private static class OutputWriter {
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

    private static class IOUtils {

        public static int[] readIntArray(InputReader in, int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++)
                array[i] = in.readInt();
            return array;
        }


    }
}
