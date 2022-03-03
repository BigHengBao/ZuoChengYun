package day9;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/3/10:34
 * title：图
 */
public class Graph {
    public HashMap<Integer, Node> nodes;  //点集
    public HashSet edges;  //边集

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet();
    }

    //图生成器
    public Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();//初始化自定义的图
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];//边的权重
            Integer from = matrix[i][1];//from节点的序列
            Integer to = matrix[i][2];//to节点的序列
            if (!graph.nodes.containsKey(from)) {//先检查from节点存在否,不存在就建
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {//再检查to节点存在否,不存在就建立
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);//拿出from点
            Node toNode = graph.nodes.get(to);//拿出to点
            Edge newEdge = new Edge(weight, fromNode, toNode);//建立新的边
            fromNode.nexts.add(toNode);//from的邻接点增加了一个to节点
            fromNode.out++;//from的出度加1
            toNode.in++;//to节点的入度加1
            fromNode.edges.add(newEdge);//from节点的边集增加
            graph.edges.add(newEdge);//加到整个图的边集里
        }
        return graph;
    }
}
