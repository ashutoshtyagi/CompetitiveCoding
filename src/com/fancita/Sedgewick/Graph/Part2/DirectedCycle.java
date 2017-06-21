package com.fancita.Sedgewick.Graph.Part2;

import com.fancita.utils.FastIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Stack;

/**
 * Created by ashutosh on 15/3/17.
 */
public class DirectedCycle {

    private boolean hasCycle;
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph dg) {
        hasCycle = false;
        marked = new boolean[dg.V()];
        edgeTo = new int[dg.V()];

        Stack<Integer> stack = new Stack<>();
        for (int u = 0; u < dg.V(); u++) {
            if (!marked[u]) {
                marked[u] = true;
                dfs(dg, u, stack);
            }
        }
    }

    private void dfs(Digraph dg, int u, Stack<Integer> stack) {
        if (hasCycle) return;

        stack.push(u);

        for (Integer v : dg.adj(u)) {
            if (hasCycle) break;
            if (!marked[v]) {
                marked[v] = true;
                edgeTo[v] = u;
                dfs(dg, v, stack);
            } else if (stack.contains(v)) {
                hasCycle = true;
                cycle = new Stack<>();
                for (int x = u; x != v; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(v);
            }
        }

        stack.pop();
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        FastIO fastIO = null;
        try {
            fastIO = new FastIO(new FileInputStream(new File("/home/ashutosh/IdeaProjects/Hackerrank/src/com/fancita/Sedgewick/Graph/Part2/tinyDG.txt")));
            Digraph dg = new Digraph(fastIO.reader);
            System.out.println(dg.toString());

            DirectedCycle dc = new DirectedCycle(dg);
            System.out.println("hasCycle = " + dc.hasCycle() + "\n");
            if (dc.hasCycle()) {
                StringBuilder sb = new StringBuilder();
                for (Integer i : dc.cycle()) {
                    sb.append(i + " ");
                }
                System.out.println("cycle = " + sb.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
