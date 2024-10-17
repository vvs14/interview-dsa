package me.vvs.tree.binarytree;

import java.util.*;

public class Traversals {

    public void preorder(BinaryTreeNode root) {
        if (root == null) return;
        System.out.print(root.getKey() + "->");
        preorder(root.getLeft());
        preorder(root.getRight());
    }

    public void inorder(BinaryTreeNode root) {
        if (root == null) return;
        inorder(root.getLeft());
        System.out.print(root.getKey() + "->");
        inorder(root.getRight());
    }

    public void postorder(BinaryTreeNode root) {
        if (root == null) return;
        postorder(root.getLeft());
        postorder(root.getRight());
        System.out.print(root.getKey() + "->");
    }

    public void levelorder(BinaryTreeNode root) {
        if (root == null) return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode currNode = queue.poll();
            System.out.print(currNode.getKey() + "->");
            if(!currNode.isLeftNull()) queue.add(currNode.getLeft());
            if(!currNode.isRightNull()) queue.add(currNode.getRight());
        }
    }

    public static void main(String[] args) {

        /**
         1
         /  \
         2       3
         /  \      \
         4       6      5
         */
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode rootLeft = new BinaryTreeNode(2);
        rootLeft.setLeft(new BinaryTreeNode(4));
        rootLeft.setRight(new BinaryTreeNode(6));
        BinaryTreeNode rootRight = new BinaryTreeNode(3);
        rootRight.setRight(new BinaryTreeNode(5));
        root.setLeft(rootLeft);
        root.setRight(rootRight);
        Traversals t = new Traversals();
//        t.preorder(root);
//        t.inorder(root);
//        t.postorder(root);
        t.levelorder(root);

    }
}
