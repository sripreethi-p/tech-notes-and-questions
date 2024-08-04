# Graphs

Graph Data Structure is a collection of nodes connected by edges. It’s used to represent relationships between different entities.

## Graph Representation

### Adjacency Matrix

For a graph with with n nodes/vertices, you have an adjacency matrix of nXn.

![Adjacency Matrix for an Undirected Graph](/notes/images/adjacency-matrix-undirected.png) ![Adjacency Matrix for a Directed Graph](/notes/images/adajacency-matrix-directed.png)

### Adjacency List

An array of Lists is used to store edges between two vertices. The size of array is equal to the number of vertices (i.e, n). Each index in this array represents a specific vertex in the graph. The entry at the index i of the array contains a linked list containing the vertices that are adjacent to vertex i.

![Adjacency List for an Undirected Graph](/notes/images/adjacency-list-undirected.png) ![Adjacency List for a Directed Graph](/notes/images/adjacency-list-directed.png)

## Graph Traversal

### Depth-First Search (DFS)

Depth-first search is an algorithm for traversing or searching tree or graph data structures. The algorithm starts at the root node (selecting some arbitrary node as the root node in the case of a graph) and explores as far as possible along each branch before backtracking.  


Depth First Search from vertex 1 : 1, 2, 0, 3  
![DFS1](/notes/images/graph-dfs1.png)

Depth First Search from vertex 2 : 2, 0, 1, 3
![DFS2](/notes/images/graph-dfs2.png)

### Breadth-First Search (BFS)

Starting from the root, all the nodes at a particular level are visited first and then the nodes of the next level are traversed till all the nodes are visited.
To do this a queue is used. All the adjacent unvisited nodes of the current level are pushed into the queue and the nodes of the current level are marked visited and popped from the queue.

Breadth First Search from vertex 0 : 0, 1, 2, 3, 4
![BFS](/notes/images/graph-bfs.png)

## 👉 [Implementations (representations, traversals)](../src/main/java/com/dsa/algorithms/domain/graph/Graph.java)


## Shortest Path Algorithms
