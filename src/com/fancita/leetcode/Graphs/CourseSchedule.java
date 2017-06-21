package com.fancita.leetcode.Graphs;

import java.util.*;

/**
 * Created by ashutosh on 16/3/17.
 */
public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourseSchedule().findOrder(1, EMPTY_2D_ARRAY /*new int[][]{{1,0}, {2, 0}, {3, 1}, {3, 2}}*/)));
    }

    private static final int[] EMPTY_ARRAY = {};
    private static final int[][] EMPTY_2D_ARRAY = {};
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 /*|| prerequisites.length == 0*/) return EMPTY_ARRAY;

        Digraph dg = new Digraph(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            int[] vertices = prerequisites[i];
            dg.addEdge(vertices[1], vertices[0]);
        }

        DirectedCycle dc = new DirectedCycle(dg);
        if (dc.hasCycle()) return EMPTY_ARRAY;

        TopologicalSort ts = new TopologicalSort(dg);
        Stack<Integer> st = ts.getTSOrder();

        int[] ret = new int[dg.V()];
        for (int i = 0; i < dg.V(); i++) {
            ret[i] = st.pop();
        }
        return ret;
    }

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
        
    }

    public class DepthFirstOrders {

        private Queue<Integer> pre, post;
        private Stack<Integer> reversePost;
        private boolean[] marked;

        public DepthFirstOrders(Digraph dg) {
            pre = new ArrayDeque<>(dg.V());
            post = new ArrayDeque<>(dg.V());
            reversePost = new Stack<>();
            marked = new boolean[dg.V()];

            for (int u = 0; u < dg.V(); u++) {
                dfs(dg, u);
            }
        }

        private void dfs(Digraph dg, int u) {
            if (marked[u]) return;
            marked[u] = true;

            pre.add(u);

            for (Integer v : dg.adj(u)) {
                dfs(dg, v);
            }

            post.add(u);
            reversePost.push(u);
        }

        public Queue<Integer> getPreOrder() {
            return pre;
        }

        public Queue<Integer> getPostOrder() {
            return post;
        }

        public Stack<Integer> getReversePostOrder() {
            return reversePost;
        }
        
    }


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

    }

    public class Digraph {

        private int V, E;
        private List<Integer>[] adj;

        public Digraph(int V) {
            this.V = V;
            adj = new List[V];

            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
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

    }


}
