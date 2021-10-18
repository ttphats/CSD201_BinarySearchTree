/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.Scanner;

/**
 *
 * @author SE150968 - Thai Thanh Phat
 */
public class IntBinTree {

    final int LEFT = 0;
    final int RIGHT = 1;
    IntBinTreeNode root;
    public static Scanner sc = new Scanner(System.in);

    public IntBinTree() {
        root = null;
    }

    protected void visit(IntBinTreeNode p) {
        System.out.println(p.key + "");
    }

    public void inorder(IntBinTreeNode p) {
        if (p != null) {
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }
    }

    public void inorder() {
        inorder(root);
    }

    public IntBinTreeNode search_inorder(int key, IntBinTreeNode p) {
        IntBinTreeNode result = p;
        if (p == null) {
            return null;
        } else if (p.key == key) {
            return p;
        } else {
            result = search_inorder(key, p.left);
            if (result==null) result = search_inorder(key, p.right);
        }
        return result;
    }
    public IntBinTreeNode serch_inorder(int key) {
        return search_inorder(key, root);
    }
    protected IntBinTreeNode input(IntBinTreeNode p) {
        int x;
        System.out.println("Enter an integer for a node, 0 for quit: ");
        x = Integer.parseInt(sc.nextLine());
        if (x!=0 && p==null) {
            p = new IntBinTreeNode(x);
            System.out.println("Left of " + x + ":");
            p.left = input(p.left);
            System.out.println("Right of" + x + ":");
            p.right=input(p.right);
        }
        return p;
    }
    public void input() {
        root = null;
        root = input(root);
    }
    public void breadthFirst() {
        if (root == null) {
            System.out.println("Empty tree!");
            return;
        }
        IntBinTreeNode p = root;
        MyQueue queue = new MyQueue();
        queue.enqueue(p);
        while (!queue.isEmpty()) {
            p = (IntBinTreeNode) queue.dequeue();
            visit(p);
            if (p.left!=null) queue.enqueue(p.left);
            if (p.right!=null) queue.enqueue(p.right);
        }
    }
    protected void inorder_level(IntBinTreeNode p, int L, int level) {
        if (p!= null) {
            if (L==level) visit(p);
            else if (L<level) {
                inorder_level(p.left, L+1, level);
                inorder_level(p.right, L+1, level);
            }
        }
    }
    public void inorder_level(int level) {
        inorder_level(root, 0, level);
    }
    protected int height(IntBinTreeNode p) {
        if ((p==null)|| (p.left==null && p.right==null)) return 0;
        int hL = 1 + height(p.left);
        int hR = 1 + height(p.right);
        return hL > hR ? hL : hR;
    }
    public int height() {
        return height(root);
    }
    
    public static void main(String[] args) {
        IntBinTree tree = new IntBinTree();
        tree.input();
        System.out.println("Inorder-LNR- Recursive Traversal:");
        tree.inorder();
        System.out.println();
        System.out.println("Bread-first Traversal:");
        tree.breadthFirst();
        System.out.println();
        int h = tree.height();
        System.out.println("Height: " + h);
        int x;
        System.out.println("Input a searched value:");
        x = Integer.parseInt(sc.nextLine());
        IntBinTreeNode p = tree.serch_inorder(x);
        if (p==null) System.out.println("The value" + x + " does not exist.");
        else System.out.println("The value " + x + " exists.");
        int level;
        System.out.println("Input a level:");
        level = Integer.parseInt(sc.nextLine());
        if (level>h) System.out.println("This level does not exist!");
        else tree.inorder_level(level);
    }
}
