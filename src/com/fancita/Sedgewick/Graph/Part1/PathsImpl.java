package com.fancita.Sedgewick.Graph.Part1;

import java.util.Stack;

/**
 * Created by ashutosh on 13/3/17.
 */
public class PathsImpl implements Paths {

    private GraphSearch graphSearch;

    public PathsImpl(GraphSearch graphSearch) {
        this.graphSearch = graphSearch;
    }

    @Override
    public boolean hasPathTo(int v) {
        return graphSearch.marked(v);
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!graphSearch.marked(v)) return null;
        Stack<Integer> ret = new Stack<>();
        for (int x = v; x != graphSearch.source(); x = graphSearch.pathTo(x)) {
            ret.push(x);
        }
        ret.push(graphSearch.source());
        return ret;
    }
}
