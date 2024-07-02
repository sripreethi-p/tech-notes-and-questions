package com.dsa.algorithms.domain.trees;

public class BinaryTreeNode {
    int key;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int item)
    {
        key = item;
        left = right = null;
    }
}
