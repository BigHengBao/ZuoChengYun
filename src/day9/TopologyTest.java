package day9;

import java.util.*;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/3/11:26
 * title：拓扑排序
 */
public class TopologyTest {
    public static void main(String[] args) {

    }

    // directed graph and no loop
    public static List<Node> sortedTopology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();//记录所有入点
        Queue<Node> zeroInQueue = new LinkedList<>();//记录所有入度为0的节点
        for (Node node : graph.nodes.values()) {//values就是当前所有点的意思
            inMap.put(node, node.in);//将入点全部登记
            if (node.in == 0) {
                zeroInQueue.add(node);//将所有入度为0的节点登记
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);//找出新的入度为0的点
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
