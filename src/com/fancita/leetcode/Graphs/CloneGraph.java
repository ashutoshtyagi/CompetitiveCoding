package com.fancita.leetcode.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ashutosh on 12/3/17.
 */
public class CloneGraph {

    public static void main(String[] args) {

    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> mapContainingClonedNodes = new HashMap<>();
        return cloneNode(node, mapContainingClonedNodes);
    }

    private UndirectedGraphNode cloneNode(UndirectedGraphNode nodeOfOriginalGraph, Map<Integer, UndirectedGraphNode> mapContainingClonedNodes) {
        if (mapContainingClonedNodes.containsKey(nodeOfOriginalGraph.label)) {
            return mapContainingClonedNodes.get(nodeOfOriginalGraph.label);
        }

        UndirectedGraphNode ret = new UndirectedGraphNode(nodeOfOriginalGraph.label);
        mapContainingClonedNodes.put(nodeOfOriginalGraph.label, ret);

        for (UndirectedGraphNode originalGraphNeighbor : nodeOfOriginalGraph.neighbors) {
            ret.neighbors.add(cloneNode(originalGraphNeighbor, mapContainingClonedNodes));
        }

        return ret;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };
}
