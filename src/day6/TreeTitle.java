package day6;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/25/11:48
 * title：二叉树,题目：找到树中哪一层最宽：
 */
public class TreeTitle {
    static class Node<T> {
        T value;
        Node left;
        Node right;
    }

    public static void main(String[] args) {

    }

    // hash表法
    public static int getMaxLevelTree(Node head) {
        if (head == null) {
            return 0;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1; //当前层
        int curLevelNodes = 0;  //当前层节点数
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
            System.out.println(" " + head.value);
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(head.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(head.right);
            }
        }
        return max;
    }
}
