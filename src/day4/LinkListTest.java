package day4;

import org.w3c.dom.Node;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/23/18:55
 * title：链表
 */
public class LinkListTest {
    public static void main(String[] args) {

    }

    static class Node {
        int value;
        Node next;
    }

    //1)输入链表头节点，奇数长度返回中点，偶数长度返回上中点
    public static Node midOrUpMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {  //// find mid node
            slow = slow.next;   // slow -> mid
            fast = fast.next.next;  //fast -> end
        }
        return slow;
    }

    //2)输入链表头节点，奇数长度返回中点，偶数长度返回下中点
    public static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {  //// find mid node
            slow = slow.next;   // slow -> mid
            fast = fast.next.next;  //fast -> end
        }
        return slow;
    }
}
