package day9;

import java.util.ArrayList;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/3/10:35
 * title：图的节点
 */
public class Node {
    public int value;  //节点的数值
    public int in;  //入度（有多少个节点指向我）
    public int out;  //出度（我指向多少个节点）
    public ArrayList<Node> nexts;  //从我出发能到达的下一级节点，邻居节点
    public ArrayList<Edge> edges;   //从我出发发散出的边的集合

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
