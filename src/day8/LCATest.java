package day8;


/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/2/9:30
 * title：题目：给定二叉树的两个节点Node1,Node2,求出最低公共祖先
 */
public class LCATest {
    static class Node {
        int value;
        Node left;
        Node right;
    }

    public static void main(String[] args) {

    }

    //前提:o1,o2必须是以head为头的节点
    public static Node lowestAncestor(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node left = lowestAncestor(head.left, o1, o2);
        Node right = lowestAncestor(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }
}
