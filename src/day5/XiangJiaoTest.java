package day5;

import org.w3c.dom.Node;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/24/19:18
 * title：题目：：两个可能有环或者五环的单链表，头节点head1和head2，
 * 请实现：两个单链表若相交，返回相交的第一个节点，否则干活null。
 */
public class XiangJiaoTest {
    static class Node {
        int value;
        Node next;
    }

    public static void main(String[] args) {

    }

    // main()直接调用函数
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) { //若两个链表都无环
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {  //若两个链表都有环
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    // 1.传入单链表头节点,若有环则返回欢头节点，否则为null
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    // 2.若两个单链表无环
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {  //相当于无相交
            return null;
        }
        cur1 = n > 0 ? head1 : head2;  //谁长，cur1接谁
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            assert cur1 != null;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            assert cur1 != null;
            cur1 = cur1.next;
            assert cur2 != null;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //两个有环单链表，返回第一个相交节点，否则null
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;  //谁长，cur1接谁
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                assert cur1 != null;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                assert cur1 != null;
                cur1 = cur1.next;
                assert cur2 != null;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
