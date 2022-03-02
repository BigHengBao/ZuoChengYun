package day7;

import java.util.Stack;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/1/18:43
 * title：搜索二叉树
 */
public class BSTtest {
    static class Node {
        int value;
        Node left;
        Node right;
    }

    public static void main(String[] args) {

    }


    // 1.递归
    public static boolean checkBST(Node head) {
        int preValue = Integer.MIN_VALUE;
        if (head == null) {
            return true;
        }
        boolean isLeftBst = checkBST(head.left);
        if (!isLeftBst) {
            return false;
        }
        if (head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }
        return checkBST(head.right);
    }

    // 2.非递归
    public static boolean inProcess(Node head) {
        if (head == null) {
            return true;
        }
        int preValue = Integer.MIN_VALUE;

        Stack<Node> stack = new Stack<>();
        if (!stack.isEmpty() || head != null) {
            stack.push(head);
            head = head.left;
        } else {
            head = stack.pop();
            if (head.value <= preValue) {
                return false;
            } else {
                preValue = head.value;
            }
            head = head.right;
        }
        return true;
    }

    //3.树形DP,动态规划
    public static ReturnType process(Node head) {
        if (head == null) {
            return null;
        }
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        int min = head.value;
        int max = head.value;
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }
        boolean isBST = true;
        if (leftData != null && (!leftData.isBST || leftData.max >= head.value)) {
            isBST = false;
        }
        if (rightData != null && (!rightData.isBST || rightData.min <= head.value)) {
            isBST = false;
        }
        return new ReturnType(isBST,min,max);
    }

    static class ReturnType {
        public boolean isBST;
        public int min;
        public int max;

        public ReturnType(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
}
