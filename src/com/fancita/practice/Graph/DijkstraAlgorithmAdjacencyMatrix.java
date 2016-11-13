package com.fancita.practice.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by fancita on 1/11/16.
 * https://www.hackerrank.com/challenges/dijkstrashortreach
 * TIMING OUT DUE TO ADJACENCY MATRIX
 */
public class DijkstraAlgorithmAdjacencyMatrix {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int t = reader.nextInt();

        while (t > 0) {
            t--;

            int numberOfVertices = reader.nextInt();
            int[][] graph = new int[numberOfVertices][numberOfVertices];
            for (int i = 0; i < numberOfVertices; i++) {
                Arrays.fill(graph[i], Integer.MAX_VALUE);
            }

            int numberOfEdges = reader.nextInt();

            for (int i = 0; i < numberOfEdges; i++) {

                int firstIndex = reader.nextInt();
                int secondIndex = reader.nextInt();
                int value = reader.nextInt();

                if (graph[firstIndex - 1][secondIndex - 1] > value) {
                    graph[firstIndex - 1][secondIndex - 1] = value;
                }
                if (graph[secondIndex - 1][firstIndex - 1] > value) {
                    graph[secondIndex - 1][firstIndex - 1] = value;
                }
            }

            int startingPosition = reader.nextInt();

            printShortestPathsUsingDijkstra(graph, startingPosition - 1);
            /*printArrayElementsSpaceSeparated(printShortestPathsUsingDijkstra(graph, startingPosition - 1), startingPosition - 1);*/
            /*System.out.println(Arrays.toString(printShortestPathsUsingDijkstra(graph, startingPosition - 1)));*/
        }
    }

    private static int[] printShortestPathsUsingDijkstra(int[][] graph, int startingPosition) {
        int[] retArr = new int[graph[0].length];
        Arrays.fill(retArr, Integer.MAX_VALUE);
        retArr[startingPosition] = 0;

        PriorityQueue<PriorityQueueNode> priorityQueue = new PriorityQueue<>(graph[0].length);
        priorityQueue.add(new PriorityQueueNode(startingPosition, 0));

        while (!priorityQueue.isEmpty()) {

            PriorityQueueNode node = priorityQueue.poll();

            for (int i = 0; i < graph[0].length; i++) {

                if (graph[node.index][i] != Integer.MAX_VALUE) {

                    int minDistUsingThisNode = node.minDistanceToThisNodeTillNow + graph[node.index][i];

                    if (minDistUsingThisNode < retArr[i]) {
                        PriorityQueueNode newNode = new PriorityQueueNode(i, minDistUsingThisNode);
                        priorityQueue.remove(newNode);
                        priorityQueue.add(newNode);
                        retArr[i] = minDistUsingThisNode;
                    }
                }
            }
        }

        /* TODO make infinity to -1*/
        for (int i = 0; i < graph[0].length; i++) {
            if (i != startingPosition) {
                System.out.print((retArr[i] == Integer.MAX_VALUE ? -1 : retArr[i]) + " ");
            }
        }
        System.out.println();

        return retArr;
    }

    private static class PriorityQueueNode implements Comparable<PriorityQueueNode>{
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
}
