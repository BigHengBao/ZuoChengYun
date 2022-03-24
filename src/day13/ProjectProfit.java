package day13;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/24/10:39
 * title：贪心酸饭----- 最多做 K 个项目的最大利润
 * ----------------------------------------------------------------------------
 * 题目：costs[]：花费 ，costs[i] 表示 i 号项目的花费 profits[]：利润，
 * profits[i] 表示 i 号项目在扣除花费之后还能挣到的钱(利润)。一次只能做一个项目，
 * 最多做 k 个项目，m 表示你初始的资金。
 * （说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个项目）求你最后获得的最大钱数。
 */
public class ProjectProfit {

    //节点
    public class Node {
        private int profit;
        private int cost;

        public Node(int profit, int cost) {
            this.profit = profit;
            this.cost = cost;
        }
    }

    /**
     * 发现最多的利润
     *
     * @param k        可以执行的项目
     * @param allCosts 预算
     * @param profits  利润
     * @param costs    成本
     * @return 结余
     */
    public int findMaxProfit(int k, int allCosts, int[] profits, int[] costs) {
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(profits[i], costs[i]);
        }
        // 优先级队列是谁小谁放在前面，比较器决定谁小
        PriorityQueue<Node> minPQ = new PriorityQueue<>(new MinCostComponent());
        PriorityQueue<Node> maxPQ = new PriorityQueue<>(new MaxProfitComponent());

        for (int i = 0; i < nodes.length; i++) {
            minPQ.add(nodes[i]);// 将所有的项目插入成本堆中
        }

        //开始解锁新项目
        for (int j = 0; j < k; j++) {
            // 解锁项目的前提条件：成本堆中还有项目未被解锁并且该项目的成本小于当前的总资金
            while (!minPQ.isEmpty() && minPQ.peek().cost <= allCosts) {
                maxPQ.add(minPQ.poll());
            }
            if (maxPQ.isEmpty()) {
                // 如果maxPQ为空，则说明没有当前资金能够解锁的新项目了，之前解锁的项目也做完了，即无项目可做了
                return allCosts;
            }
            allCosts = maxPQ.poll().profit;  // 做利润最大的项目
        }
        return allCosts;
    }


    //成本最小堆
    public class MinCostComponent implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;//小的在前
        }
    }

    // 利润最大堆
    public class MaxProfitComponent implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;  //大的在前
        }
    }
}
