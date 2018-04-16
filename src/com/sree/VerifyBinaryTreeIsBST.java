package com.sree;

public class VerifyBinaryTreeIsBST {

    class TreeNode {
        private int value;
        private TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
            left = right = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = new TreeNode(left);
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = new TreeNode(right);
        }

        @Override
        public String toString() {
            String result = "";
            if (left != null) {
                result += left.toString();
            }
            result += value + ",";
            if (right != null) {
                result += right.toString();
            }
            return  result;
        }
    }

    TreeNode root;

    public void setRoot(int root) {
        this.root = new TreeNode(root);
    }

    public TreeNode getRoot() {
        return root;
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBST(TreeNode node, int minimum, int maximum) {
        if (node == null) {
            return true;
        }
        return node.getValue() >= minimum &&
                node.getValue() <= maximum &&
                isBST(node.getLeft(), minimum, node.getValue()) &&
                isBST(node.getRight(), node.getValue(), maximum);
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public static void main(String[] args) {
        VerifyBinaryTreeIsBST binaryTree1 = new VerifyBinaryTreeIsBST();
        binaryTree1.setRoot(4);
        binaryTree1.getRoot().setLeft(2);
        binaryTree1.getRoot().setRight(5);
        binaryTree1.getRoot().getLeft().setLeft(1);
        binaryTree1.getRoot().getLeft().setRight(3);
        System.out.println(binaryTree1);
        System.out.println(binaryTree1.isBST());
        VerifyBinaryTreeIsBST binaryTree2 = new VerifyBinaryTreeIsBST();
        binaryTree2.setRoot(3);
        binaryTree2.getRoot().setLeft(2);
        binaryTree2.getRoot().setRight(5);
        binaryTree2.getRoot().getLeft().setLeft(1);
        binaryTree2.getRoot().getLeft().setRight(4);
        System.out.println(binaryTree2);
        System.out.println(binaryTree2.isBST());

    }
}
