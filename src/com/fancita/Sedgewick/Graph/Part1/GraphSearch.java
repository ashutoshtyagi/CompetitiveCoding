package com.fancita.Sedgewick.Graph.Part1;

/**
 * Created by ashutosh on 13/3/17.
 */
public interface GraphSearch {
    boolean marked(int v);
    int count();
    int source();
    int pathTo(int v);
}
