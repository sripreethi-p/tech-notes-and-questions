package com.dsa.algorithms.problems.leetcode;

import com.dsa.algorithms.domain.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal145 {



    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrderTraverse(root, result);
        return result;

    }

    private void postOrderTraverse(TreeNode root, List<Integer> list) {
        if (root != null) {
            postOrderTraverse(root.getLeft(), list);
            postOrderTraverse(root.getRight(), list);
            list.add(root.getVal());
        }
    }
}
