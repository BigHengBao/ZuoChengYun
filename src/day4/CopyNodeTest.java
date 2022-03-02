package day4;

import org.w3c.dom.Node;

import java.util.HashMap;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/23/20:17
 * title：拷贝有特殊指针的链表
 */
public class CopyNodeTest {
    public static void main(String[] args) {

    }

    // 常规法，hashmap
    public static Node process1(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node curNode = head;
        while (curNode != null) {
            map.put(curNode, new Node(curNode.value));
            curNode = curNode.next;
        }
        curNode = head;
        while (curNode != null) {
            // map.get(cur) 新
            map.get(curNode).next = map.get(curNode.next);
            map.get(curNode).rand = map.get(curNode.rand);
            curNode = curNode.next;
        }
        return map.get(head);
    }

    //2.装B版
    public static Node process2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;

        // copy node and link to every node
        //1->2
        //1-> 1’->2
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        // set copy node rand
        //1->1’->2->2'
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.next.rand : null;
            cur = next;
        }

        // head head.next
        Node res = head.next;
        cur = head;
        // split
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    static class Node {
        int value;
        Node next;
        Node rand;

        public Node(int value) {
            this.value = value;
        }
    }
}
