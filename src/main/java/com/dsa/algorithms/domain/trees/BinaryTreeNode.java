package com.dsa.algorithms.domain.trees;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BinaryTreeNode {
    int key;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int item)
    {
        key = item;
        left = right = null;
    }

    public BinaryTreeNode(int item, BinaryTreeNode left, BinaryTreeNode right) {
        key = item;
        this.left = left;
        this.right = right;
    }
}
