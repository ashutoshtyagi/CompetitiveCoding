package com.fancita.Sedgewick.Graph.Part1;

/**
 * Created by ashutosh on 14/3/17.
 */
public interface GraphInterface {
    int V();

    int E();

    void addEdge(int v, int w);

    Iterable<Integer> adj(int v);
}
