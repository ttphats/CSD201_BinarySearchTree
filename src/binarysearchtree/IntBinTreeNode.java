/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

/**
 *
 * @author SE150968 - Thai Thanh Phat
 */
public class IntBinTreeNode {
    int key;
    IntBinTreeNode left, right;

    public IntBinTreeNode() {
        left = right = null;
    }
        public IntBinTreeNode(int key) {
        this.key = key;
        left = right = null;
    }
    public IntBinTreeNode(int key, IntBinTreeNode left, IntBinTreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public IntBinTreeNode getLeft() {
        return left;
    }

    public void setLeft(IntBinTreeNode left) {
        this.left = left;
    }

    public IntBinTreeNode getRight() {
        return right;
    }

    public void setRight(IntBinTreeNode right) {
        this.right = right;
    }
    
    
}
