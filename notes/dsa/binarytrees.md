## Binary Trees

### Properties 
1. Max no.of nodes at 'l' level = 2<sup>l</sup>
2. Max total no.of nodes in a 'h' height tree = 2<sup>h</sup> - 1
3. Min no.of levels in a 'n' nodes tree = log<sub>2</sub><sup>n+1</sup>


### Types of Traversals
1. Inorder (DFS) : Left → Root → Right
2. Preorder (DFS) : Root → Left → Right
3. Postorder (DFS) : Left → Right → Root
4. Level Order Traversal (BFS) : Level after level


### Types of Trees
1. Fully/Proper Binary Tree—each node has either 0 or 2 children
2. Binary Search Tree : left.val < root.val < right.val 
2. Degenerate/Pathological Tree—every node has a child (like linked-list performance wise)
3. Skewed Binary Tree—either only left nodes or only right nodes
4. 