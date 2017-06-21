package com.fancita.Sedgewick.Graph.Part1;

import com.fancita.utils.FastIO;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by ashutosh on 18/12/16.
 */
public class Graph implements GraphInterface {

    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new List[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();
    }

    public Graph(FastIO.InputReader reader) {
        try {
            this.V = reader.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            adj = (List<Integer>[]) new List[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<>();
            }
            int E = reader.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = reader.readInt();
                int w = reader.readInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w);
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

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

    public String toString() {
        StringBuilder retSB = new StringBuilder();
        for (int u = 0; u < adj.length; u++) {
            retSB.append(u + " -> ");
            for (Integer v : adj[u]) {
                retSB.append(v + " ");
            }
            retSB.append("\n");
        }

        return retSB.toString();
    }
}
