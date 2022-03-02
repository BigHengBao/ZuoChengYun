package day4;

import java.util.Stack;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/23/19:07
 * title：单链表，回文
 */
public class HuiWenTest {
    public static void main(String[] args) {
//        Node node1 = new Node();
//        node1.value = 1;
//        Node node2 = new Node();
//        node2.value = 2;
//        Node node3 = new Node();
//        node3.value = 3;
//        Node node4 = new Node();
//        node4.value = 1;
//        node3.next = node4;
//        node1.next = node2;
//        node2.next = node3;
//        System.out.println("是回文吗？ process1 " + process1(node1));
//        System.out.println("是回文吗？ process2 " + process2(node1));
//        System.out.println("是回文吗？ process3 " + process3(node1));

    }

    // 1.栈
    public static boolean process1(Node head) {
        if (head == null) {
            return false;
        }
        Stack<Node> stack = new Stack<>();
        Node tail = head;
        while (tail != null) {
            stack.push(tail);
            tail = tail.next;
        }
        tail = head;
        while (tail != null) {
            if (stack.pop().value != tail.value) {
                return false;
            }
            tail = tail.next;
        }
        return true;
    }

    // 2.栈+快慢指针
    public static boolean process2(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        Stack<Node> stack = new Stack<>();
        while (fast.next != null && fast.next.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            stack.push(slow);
        }
        slow = slow.next;
        while (!stack.isEmpty()) {
            if (stack.pop().value != slow.value) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static boolean process3(Node header) {
        if (header == null) {
            return false;
        }
        Node slow = header;
        Node fast = header;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        Node preNode = null;
        Node postNode = null;
        // 后半段反转
        while (slow != null) {
            preNode = slow.next;
            slow.next = postNode;
            postNode = slow;
            slow = preNode;
        }
        Node tailLeft = header;
        Node tailRight = postNode;
        boolean flag = true;
        // 两边向中间判断
        while (tailRight != null) {
            if (tailLeft.value != tailRight.value) {
                flag = false;
                break;
            }
            tailLeft = tailLeft.next;
            tailRight = tailRight.next;
        }
        Node tailNode = null;
        // 后半段链表恢复
        while (postNode != null) {
            preNode = postNode.next;
            postNode.next = tailNode;
            tailNode = postNode;
            postNode = preNode;
        }
        return flag;
    }


    static class Node {
        int value;
        Node next;
    }
}
