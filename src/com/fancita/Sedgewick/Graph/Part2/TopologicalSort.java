package com.fancita.Sedgewick.Graph.Part2;

import com.fancita.utils.FastIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Stack;

/**
 * Created by ashutosh on 15/3/17.
 */
public class TopologicalSort {

    private boolean[] marked;
    private Stack<Integer> stack;
    private DirectedCycle directedCycle;

    public TopologicalSort(Digraph dg) {
        marked = new boolean[dg.V()];
        stack = new Stack<>();
        directedCycle = new DirectedCycle(dg);
        if (!directedCycle.hasCycle()) {
            DepthFirstOrders dfo = new DepthFirstOrders(dg);
            stack = dfo.getReversePostOrder();
        }
    }

    public boolean isDAG() {
        return !directedCycle.hasCycle();
    }

    public Iterable<Integer> order() {
        return stack;
    }

    public Stack<Integer> getTSOrder() {
        return stack;
    }


    /* main */
    public static void main(String[] args) {
        FastIO fastIO = null;
        try {
            fastIO = new FastIO(new FileInputStream(new File("/home/ashutosh/IdeaProjects/Hackerrank/src/com/fancita/Sedgewick/Graph/Part2/tinyDG.txt")));
            Digraph dg = new Digraph(fastIO.reader);
            System.out.println(dg.toString());

            TopologicalSort ts = new TopologicalSort(dg);
            System.out.println("isDAG = " + ts.isDAG() + "\n");
            if (ts.isDAG()) {
                Stack<Integer> st = ts.getTSOrder();
                for (Integer i : st) {
                    System.out.println(i);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
