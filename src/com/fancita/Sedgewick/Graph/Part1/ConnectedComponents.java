package com.fancita.Sedgewick.Graph.Part1;

import java.util.ArrayList;
import java.util.List;

import static com.fancita.utils.FastIO.reader;

/**
 * Created by ashutosh on 18/12/16.
 */
public class ConnectedComponents {
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


    /* main */
    public static void main(String[] args) {

        int V = reader.readInt();
        Graph G = new Graph(V);
        int E = reader.readInt();
        for (int e = 0; e < E; e++) {
            G.addEdge(reader.readInt() - 1, reader.readInt() - 1);
        }

        ConnectedComponents cc = new ConnectedComponents(G);

        int M = cc.count();
        System.out.println(M);

        List<Integer>[] components = new List[M];
        for (int i = 0; i < M; i++) {
            components[i] = new ArrayList<>();
        }

        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].add(v);
        }

        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                System.out.print((v + 1) + " ");
            }
            System.out.println();
        }
    }
}
