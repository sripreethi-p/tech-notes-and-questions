package com.dsa.algorithms.domain.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private LinkedList<Integer> adjLists[];
    private boolean visited[];
    private int vertices;


    // Graph creation
    @SuppressWarnings("unchecked")
    Graph(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    // Add edges
    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    // DFS algorithm
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adj : adjLists[vertex]) {
            if (!visited[adj])
                DFS(adj);
        }
    }

    // BFS algorithm
    void BFS(int startNode) {
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[vertices];

      // Mark the current node as visited and enqueue it
        visited[startNode] = true;
        queue.add(startNode);

      // Iterate over the queue
      while (!queue.isEmpty()) {
        // Dequeue a vertex from queue and print it
        int currentNode = queue.poll();
        System.out.print(currentNode + " ");

        // Get all adjacent vertices of the dequeued vertex currentNode
        // If an adjacent has not been visited, then mark it visited and enqueue it
        for (int neighbor : adjLists[currentNode]) {
          if(!visited[neighbor]) {
            visited[neighbor] = true;
            queue.add(neighbor);
          }
        }
      }



    }

}
