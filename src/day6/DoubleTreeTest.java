package day6;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/25/10:01
 * title：二叉树的遍历
 */
public class DoubleTreeTest {
    static class Node<T> {
        T value;
        Node left;
        Node right;
    }

    public static void main(String[] args) {

    }

    // 1.递归遍历法
    public static void process(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);  //先序遍历
        process(head.left);
        System.out.println(head.value); //中序遍历
        process(head.right);
        System.out.println(head.value);  //后序遍历
    }

    //2.非递归法
    //先序遍历
    private static void preProcess(Node head) {
        System.out.println("pre-order:");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                stack.pop();
                System.out.println(" " + head.value);
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    //后序遍历
    private static void posProcess(Node head) {
        System.out.println("pos-order: ");
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
        }
    }

    //中序遍历
    public static void inProcess(Node head) {
        System.out.println("pos-order: ");
        Stack<Node> stack = new Stack<>();
        if (head != null) {
            stack.add(head);
            head = head.left;
        } else {
            head = stack.pop();
            System.out.println(" " + head.value);
            head = head.right;
        }
    }

    //3.广度优先遍历
    public static void levelProcess(Node head) {
        if (head == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(" " + head.value);
            if (cur.left != null) {
                queue.add(head.left);
            }
            if (cur.right != null) {
                queue.add(head.right);
            }
        }
    }
}
