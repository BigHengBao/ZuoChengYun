package day7;

import org.w3c.dom.Node;

import java.util.LinkedList;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/1/19:02
 * title：完全二叉树
 */
public class CSTtest {
    static class Node<T> {
        T value;
        Node left;
        Node right;
    }

    public static void main(String[] args) {

    }

    public static boolean checkCST(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        //标记是否遇到过左右子不双全节点
        boolean leaf = false;
        Node left = null;
        Node right = null;
        if (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;
            if (
                //如果遇到不双全节点后，当前节点不是叶节点
                    (leaf && !(left != null && right != null)) || (left == null && right == null)
            ) {
                return false;
            }
        }
        if (left != null) {
            queue.add(left);
        }
        if (right != null) {
            queue.add(right);
        }
        if (left == null && right == null) {
            leaf = true;
        }
        return true;
    }
}
