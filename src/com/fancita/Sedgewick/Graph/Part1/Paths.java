package com.fancita.Sedgewick.Graph.Part1;

/**
 * Created by ashutosh on 13/3/17.
 */
public interface Paths {
    boolean hasPathTo(int v);
    Iterable<Integer> pathTo(int v);
}
