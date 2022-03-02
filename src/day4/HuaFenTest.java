package day4;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/23/19:37
 * title：将单向链表按某值划分成左边小、中间相等、右边大的形式
 */
public class HuaFenTest {
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.value = 1;
        Node node2 = new Node();
        node2.value = 2;
        Node node3 = new Node();
        node3.value = 3;
        Node node4 = new Node();
        node4.value = 1;
        node3.next = node4;
        node1.next = node2;
        node2.next = node3;
        Node node = process(node1, 2);
        while (node!=null){
            System.out.println(node.value);
            node = node.next;
        }

    }

    public static Node process(Node head, int pivot) {
        if (head == null) {
            return null;
        }
        Node sH = null;// small head
        Node sT = null;// small tail
        Node eH = null;// equal head
        Node eT = null;
        Node bH = null;
        Node bT = null;// big tail
        Node next = null; //save next node

        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;  //谁去连大于区域的头，谁就变成eT
        }
        // 上面的if， 不管跑了没有，et
        // all reconnect
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : bH;
    }

    static class Node {
        int value;
        Node next;
    }
}
