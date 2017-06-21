package com.fancita.Sedgewick.Graph.Part2;

import com.fancita.utils.FastIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ashutosh on 15/3/17.
 */
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


    /* main */
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

            DepthFirstOrders dfo = new DepthFirstOrders(dg);
            Queue<Integer> pre = dfo.getPreOrder();
            Queue<Integer> post = dfo.getPostOrder();
            Stack<Integer> reversePost = dfo.getReversePostOrder();

            /*Iterator<Integer> postIt = post.iterator();
            StringBuilder sbPostIt = new StringBuilder();
            while (postIt.hasNext()) {
                sbPostIt.append(postIt.next() + " ");
            }
            System.out.println("post order = " + sbPostIt.toString());*/

            StringBuilder sbPostIt = new StringBuilder();
            while (!post.isEmpty()) {
                sbPostIt.append(post.poll() + " ");
            }
            System.out.println("post order = " + sbPostIt.toString());

            StringBuilder sbRevPostIt = new StringBuilder();
            while (!reversePost.isEmpty()) {
                sbRevPostIt.append(reversePost.pop() + " ");
            }
            System.out.println("reverse post order = " + sbRevPostIt.toString());

            /*Iterator<Integer> reversePostIt = reversePost.iterator();
            StringBuilder sbRevPostIt = new StringBuilder();
            while (reversePostIt.hasNext()) {
                sbRevPostIt.append(reversePostIt.next() + " ");
            }
            System.out.println("reverse post order = " + sbRevPostIt.toString());*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
