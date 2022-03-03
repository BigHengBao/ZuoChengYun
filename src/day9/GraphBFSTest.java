package day9;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/3/10:50
 * title：图的广度优先遍历
 */
public class GraphBFSTest {
    public static void main(String[] args) {

    }

    public static void bfs(Node node) {//广(宽)度优先遍历
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> map = new HashSet<>();
        queue.add(node);
        map.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();//将当前节点拿出来
            System.out.println(cur.value);//打印当前的节点
            for (Node next : cur.nexts) {//遍历当前节点的所有邻接点
                if (!map.contains(next)) {//如果有某个邻接点已经在set里边了，就不再需要了
                    map.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
