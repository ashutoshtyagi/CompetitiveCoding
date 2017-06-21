package com.fancita.Sedgewick.Graph.Part1;

import com.fancita.utils.FastIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ashutosh on 13/3/17.
 */
public class BreadthFirstSearch implements GraphSearch {

    private int s;
    private boolean[] marked;
    private int[] pathTo;
    private int count;

    public BreadthFirstSearch(GraphInterface g, int s) {
        this.s = s;
        marked = new boolean[g.V()];
        pathTo = new int[g.V()];
        bfs(g, s);
    }

    private void bfs(GraphInterface g, int s) {
        Deque<Integer> queue = new ArrayDeque<>(g.V());
        queue.addLast(s);
        while (!queue.isEmpty()) {
            int e = queue.removeFirst();
            for (Integer neighbour : g.adj(e)) {
                if (!marked[neighbour]) {
                    marked[neighbour] = true;
                    pathTo[neighbour] = e;
                    count++;
                    queue.addLast(neighbour);
                }
            }
        }
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
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
            FastIO fastIO = new FastIO(new FileInputStream(new File("/home/ashutosh/IdeaProjects/Hackerrank/src/com/fancita/Sedgewick/Graph/Part1/tinyG.txt")));
            Graph g = new Graph(fastIO.reader);

            BreadthFirstSearch dfs = new BreadthFirstSearch(g, 0);

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
