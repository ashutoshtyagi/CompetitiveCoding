package com.fancita.leetcode.Graphs;

import com.fancita.leetcode.LinkedList.ListNode;
import com.fancita.leetcode.LinkedList.Utils;

import java.util.*;

/**
 * Created by ashutosh on 23/5/17.
 */
public class ReconstructItinerary {

    public static void main(String[] args) {
        List<String> list = new ReconstructItinerary().findItinerary(new String[][] {
                /*{"JFK", "ATL"},
                {"ATL", "JFK"},
                {"ATL", "SFO"},
                {"SFO", "ATL"}*/
                {"JFK", "KUL"},
                {"JFK", "NRT"},
                {"NRT", "JFK"}
        });
        System.out.println(Arrays.toString(list.toArray()));
        /*
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        */
    }

    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) return Collections.emptyList();

        List<Path> list = new ArrayList<>(tickets.length);
        for (int i = 0; i < tickets.length; i++) {
            String source = tickets[i][0];
            String destination = tickets[i][1];
            Path path = new Path(source, destination);
            list.add(path);
        }

        Collections.sort(list);

        Map<String, Integer> pathFreqMap = new HashMap<>(tickets.length);
        Map<String, List<String>> graphMap = new HashMap<>(tickets.length);
        for (Path p : list) {
            if (pathFreqMap.containsKey(p.toString())) {
                pathFreqMap.put(p.toString(), pathFreqMap.get(p.toString()) + 1);
            } else pathFreqMap.put(p.toString(), 1);

            if (graphMap.containsKey(p.source)) {
                if (pathFreqMap.get(p.toString()) == 1) {
                    List<String> adjSet = graphMap.get(p.source);
                    adjSet.add(p.destination);
                }
            } else {
                List<String> adjSet = new ArrayList<>();
                adjSet.add(p.destination);
                graphMap.put(p.source, adjSet);
            }
        }

        String source = "JFK";
        for (String destination : graphMap.get(source)) {
            List<String> retList = new ArrayList<>(tickets.length);
            retList.add(source);

            Path path = new Path(source, destination);
            int val = pathFreqMap.get(path.toString());
            pathFreqMap.put(path.toString(), val - 1);

            boolean ret = recurse(/*source, */destination, pathFreqMap, graphMap, retList, tickets.length - 1);
            if (ret) return retList;
            pathFreqMap.put(path.toString(), pathFreqMap.get(path.toString()) + 1);
        }

        return Collections.emptyList();
    }

    private boolean recurse(String source, /*String destination, */Map<String, Integer> pathFreqMap, Map<String,
            List<String>> graphMap, List<String> retList, int totalPathToCover) {
        retList.add(source);

        if (totalPathToCover == 0) return true;

        if (graphMap.containsKey(source)) {
            for (String destination : graphMap.get(source)) {
                Path path = new Path(source, destination);

                int pathFreq = pathFreqMap.get(path.toString());
                if (pathFreq > 0) {
                    pathFreqMap.put(path.toString(), pathFreqMap.get(path.toString()) - 1);

                    boolean ret = recurse(destination, pathFreqMap, graphMap, retList, totalPathToCover - 1);
                    if (ret) return true;

                    pathFreqMap.put(path.toString(), pathFreqMap.get(path.toString()) + 1);
                }
            }
        }

        retList.remove(retList.size() - 1);
        return false;
    }

    private class Path implements Comparable<Path> {
        public String source, destination;

        public Path(String source, String destination) {
            this.source = source;
            this.destination = destination;
        }

        @Override
        public boolean equals(Object obj) {
            Path objPath = (Path) obj;
            return this.source.equals(objPath.source) && this.destination.equals(objPath.destination);
        }

        @Override
        public int compareTo(Path o) {
            int sourceComp = this.source.compareTo(o.source);
            return sourceComp != 0 ? sourceComp : this.destination.compareTo(o.destination);
        }

        @Override
        public String toString() {
            return source + "," + destination;
        }
    }
}
