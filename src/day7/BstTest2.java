package day7;

import org.w3c.dom.Node;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/1/19:21
 * title：平衡二叉树
 */
public class BstTest2 {
    static class Node {
        int value;
        Node left;
        Node right;
    }

    public static void main(String[] args) {

    }

    // 判断平衡二叉树
    public static boolean isBalance(Node head) {
        return process(head).isBalanced;
    }

    private static ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        int height = Math.max(leftData.height, rightData.height);
        boolean isBalanced = leftData.isBalanced
                && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;

        return new ReturnType(isBalanced, height);
    }

    static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
