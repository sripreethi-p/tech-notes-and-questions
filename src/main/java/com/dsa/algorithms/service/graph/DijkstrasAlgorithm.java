package com.dsa.algorithms.service.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
    static class Node implements Comparable<Node> {
        int v;
        int distance;

        public Node(int v, int distance) {
            this.v = v;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n) {
            if (this.distance <= n.distance) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>> > adj, int S) {
        boolean[] visited = new boolean[V];
        HashMap<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> q = new PriorityQueue<>();


    }
}
