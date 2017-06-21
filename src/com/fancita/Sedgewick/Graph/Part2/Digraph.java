package com.fancita.Sedgewick.Graph.Part2;

import com.fancita.Sedgewick.Graph.Part1.BreadthFirstSearch;
import com.fancita.Sedgewick.Graph.Part1.DepthFirstSearch;
import com.fancita.Sedgewick.Graph.Part1.GraphInterface;
import com.fancita.Sedgewick.Graph.Part1.PathsImpl;
import com.fancita.utils.FastIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashutosh on 14/3/17.
 */
public class Digraph implements GraphInterface {

    private int V, E;
    private List<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        adj = new List[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public Digraph(FastIO.InputReader reader) {
        V = reader.readInt();
        adj = new List[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        int e = reader.readInt();
        for (int i = 0; i < e; i++) {
            int u = reader.readInt();
            int v = reader.readInt();
            addEdge(u, v);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph ret = new Digraph(V);
        for (int u = 0; u < V; u++) {
            for (Integer v : adj[u]) {
                ret.addEdge(v, u);
            }
        }
        return ret;
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


    /* main */
    public static void main(String[] args) {
        try {
            FastIO fastIO = new FastIO(new FileInputStream(new File("/home/ashutosh/IdeaProjects/Hackerrank/src/com/fancita/Sedgewick/Graph/Part2/tinyDG.txt")));
            Digraph dg = new Digraph(fastIO.reader);
            System.out.println(dg.toString());
            System.out.println("\n" + dg.reverse().toString());

            DepthFirstSearch dfs = new DepthFirstSearch(dg, 0);
            System.out.println("Marked .. ");
            for (int i = 0; i < dg.V(); i++) {
                System.out.println(dfs.marked(i) + " ");
            }
            System.out.println("\nCount ..\n" + dfs.count());

            System.out.println("\npath to vertex 1..");
            PathsImpl paths = new PathsImpl(dfs);
            Iterable<Integer> it = paths.pathTo(1);
            if (it != null) {
                for (Integer i : it) {
                    System.out.print(i + " ");
                }
            }

            System.out.println("BFS....\n");

            BreadthFirstSearch bfs = new BreadthFirstSearch(dg, 6);
            System.out.println("Marked .. ");
            for (int i = 0; i < dg.V(); i++) {
                System.out.println(bfs.marked(i) + " ");
            }
            System.out.println("\nCount ..\n" + bfs.count());

            System.out.println("\npath to vertex 1..");
            PathsImpl pathsbfs = new PathsImpl(bfs);
            Iterable<Integer> itbfs = pathsbfs.pathTo(8);
            if (itbfs != null) {
                for (Integer i : itbfs) {
                    System.out.print(i + " ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
