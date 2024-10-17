package me.vvs.tree.binarytree;

public class BinaryTreeNode {
    private Integer key;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(Integer key, BinaryTreeNode left, BinaryTreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public boolean isLeftNull(){
        return left == null;
    }

    public boolean isRightNull(){
        return right == null;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {

        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
