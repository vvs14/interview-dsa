package me.vvs.tree.binarytree;


import java.util.*;

public class BinaryTreeOperations {

    /**
     * Insert as child of a node which has either child as null.
     * using BFS aka Level Order Traversal.
     *
     * @param root
     * @param key
     * @return
     */
    public BinaryTreeNode insertKey(BinaryTreeNode root, Integer key) {
        if (root == null) return new BinaryTreeNode(key);
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
//            System.out.print();
            if (node.isLeftNull()){
                node.setLeft(new BinaryTreeNode(key));
                break;
            }
            else queue.add(node.getLeft());
            if (node.isRightNull()) {
                node.setRight(new BinaryTreeNode(key));
                break;
            }
            else queue.add(node.getRight());
        }
        return root;
    }

    /**
     * Search and return BinaryTreeNode that has same key as passed.
     * Assuming non-null key and target.
     *
     * @param root
     * @param target
     * @return
     */
    public boolean searchKey(BinaryTreeNode root, Integer target){
        if (root == null) return false;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            if (node.getKey() != null && node.getKey().intValue() == target.intValue()) return true;
            if (!node.isLeftNull()) queue.add(node.getLeft());
            if (!node.isRightNull()) queue.add(node.getRight());
        }
        return false;
    }

    public static void main(String[] args){

        /**
               1
            /    \
           2      3
         /  \      \
         4    6      5
         */
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode rootLeft = new BinaryTreeNode(2);
        rootLeft.setLeft(new BinaryTreeNode(4));
        rootLeft.setRight(new BinaryTreeNode(6));
        BinaryTreeNode rootRight = new BinaryTreeNode(3);
        rootRight.setRight(new BinaryTreeNode(5));
        root.setLeft(rootLeft);
        root.setRight(rootRight);
        BinaryTreeOperations ops = new BinaryTreeOperations();
        ops.insertKey(root, 8);
        Traversals.levelorder(root);
        ops.insertKey(root, 100);
        Traversals.levelorder(root);
        assert ops.searchKey(root, 100) == true;
        assert ops.searchKey(root, 101) == false;
        assert ops.searchKey(root, 1) == true;
        assert ops.searchKey(root, 2) == true;
    }

}
