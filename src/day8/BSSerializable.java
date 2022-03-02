package day8;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/2/10:25
 * title：二叉树的序列化和反序列化
 */
public class BSSerializable {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }

    //以head为头的二叉树,中序,序列化
    public static String serializeByPre(Node head) {
        if (head == null) {
            return "#_";
        }
        String res = head.value + "_";
        res += serializeByPre(head.left);
        res += serializeByPre(head.right);
        return res;
    }

    //反序列化
    public static Node reconByPreString(String preString) {
        String[] values = preString.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.add(values[i]);
        }
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value == "#") {
            return null;
        }
        Node head = new Node(Integer.parseInt(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
