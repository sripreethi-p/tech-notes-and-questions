package com.dsa.algorithms.problems.leetcode;

import com.dsa.algorithms.domain.trees.Node;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePostOrderTraversal590 {

    /*
    Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
    Nary-Tree input serialization is represented in their level order traversal.
    Each group of children is separated by the null value
     */

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
         traversePostOrder(root, result);
         return result;
    }

    private void traversePostOrder(Node root, List<Integer> list) {
        if (root != null) {
            for (Node child : root.children) {
                traversePostOrder(child, list);
            }
            list.add(root.val);
        }

    }
}
