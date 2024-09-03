package com.dsa.algorithms.service.binarytree;

import com.dsa.algorithms.domain.trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class Traversal {
    public List<Integer> inorderTraversal(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraverse(root, list);
        return list;
    }

    public List<Integer> postorderTraversal(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraverse(root, list);
        return list;
    }

    private void postOrderTraverse(BinaryTreeNode root, List<Integer> list) {
        if (root != null) {
            postOrderTraverse(root.getLeft(), list);
            postOrderTraverse(root.getRight(), list);
            list.add(root.getKey());
        }
    }


    private void inOrderTraverse(BinaryTreeNode root, List<Integer> list) {
        if (root != null) {
            inOrderTraverse(root.getLeft(), list);
            list.add(root.getKey());
            inOrderTraverse(root.getRight(), list);
        }
    }
}
