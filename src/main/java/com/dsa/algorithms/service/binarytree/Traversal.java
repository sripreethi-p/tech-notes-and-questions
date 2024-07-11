package com.dsa.algorithms.service.binarytree;

import com.dsa.algorithms.domain.trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class Traversal {
    public List<Integer> inorderTraversal(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }
    private void traverse(BinaryTreeNode root, List<Integer> list) {
        if (root != null) {
            traverse(root.getLeft(), list);
            list.add(root.getKey());
            traverse(root.getRight(), list);
        }
    }
}
