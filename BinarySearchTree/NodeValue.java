package com.dsa.BinarySearchTree;

class NodeValue {

    int minNode;
    int maxNode;
    int maxSize;
    int sum;
    int maxSum;

    NodeValue(int minNode, int maxNode, int maxSize) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }

    NodeValue(int minNode, int maxNode, int sum, int maxSum) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.sum = sum;
        this.maxSum = maxSum;
    }

}