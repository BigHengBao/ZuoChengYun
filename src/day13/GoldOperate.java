package day13;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/24/10:15
 * title：贪心算法----哈夫曼编码--->切分金条总代价最小
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。
 * 比如：长度为20的金条，不管切成长度多大的两半，都要花费20个铜板。一群人想整分整块金条，怎么分最省铜板？
 */
public class GoldOperate {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        System.out.println(new GoldOperate().getLowestCost(arr));
    }

    // 自定义比较器
    public static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2; //负数，说明小的在前
        }
    }

    public Integer getLowestCost(int[] arr) {
        //优先级队列是小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new MyComparator());
        for (int i : arr) {
            pq.add(i);
        }

        int result = 0;
        int costOne = 0; //一次的花费
        while (pq.size() > 1) {
            costOne = pq.poll() + pq.poll();
            result += costOne;
            pq.add(costOne);
        }
        return result;
    }
}
