package day9;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/3/10:36
 * title：图的边
 */
public class Edge {
    public int weight;//这个边的权重是多少
    public Node from;//这个边从哪里出发
    public Node to;//这个边到达哪里的

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
