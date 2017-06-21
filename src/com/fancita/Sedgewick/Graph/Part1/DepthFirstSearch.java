package com.fancita.Sedgewick.Graph.Part1;

import com.fancita.utils.FastIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by ashutosh on 13/3/17.
 */
public class DepthFirstSearch implements GraphSearch {

    private boolean[] marked;
    private int count;
    private int[] pathTo;
    private int s;

    public DepthFirstSearch(GraphInterface g, int s) {
        this.s = s;
        marked = new boolean[g.V()];
        pathTo = new int[g.V()];
        dfs(g, s);
    }

    private void dfs(GraphInterface g, int s) {
        marked[s] = true;
        count++;
        for (int v : g.adj(s)){
            if (!marked[v]) {
                pathTo[v] = s;
                dfs(g, v);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }

    @Override
    public int source() {
        return s;
    }

    @Override
    public int pathTo(int v) {
        return pathTo[v];
    }


    /* main */
    public static void main(String[] args) {
        try {
            FastIO fastIO = new FastIO(new FileInputStream(new File("/home/ashutosh/IdeaProjects/Hackerrank/src/com/fancita/Sedgewick/Graph/tinyG.txt")));
            Graph g = new Graph(fastIO.reader);
            DepthFirstSearch dfs = new DepthFirstSearch(g, 0);
            System.out.println("Marked .. ");
            for (int i = 0; i < g.V(); i++) {
                System.out.println(dfs.marked(i) + " ");
            }
            System.out.println("\nCount ..\n" + dfs.count());

            System.out.println("\npath to vertex 6..");
            PathsImpl paths = new PathsImpl(dfs);
            Iterable<Integer> it = paths.pathTo(6);
            if (it != null) {
                for (Integer i : it) {
                    System.out.print(i + " ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
