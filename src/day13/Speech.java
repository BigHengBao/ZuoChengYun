package day13;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/24/11:02
 * title：贪心算法---------安排最多的宣讲场次
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
 * 给你每一个项目开始的时间和结束的时间(给你一个数组，里面是一个个具体项目)，
 * 你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。返回这个最多的宣讲场次。
 */
public class Speech {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 获取最佳的宣讲安排
     * @param programs  会议
     * @param cur  当前时间
     * @return
     */
    public int getBestArrange(Program[] programs, int cur) {
        Arrays.sort(programs, new MyComparator());
        int res = 0;
        for (int i = 0; i < programs.length; i++) {
            // 只有当前时间早于第i个项目的开始时间时，才可以安排
            if (cur < programs[i].start) {
                res++;
                cur = programs[i].end;  //当前时间改为结束时间
            }
        }
        return res;
    }

    // 按照项目的结束时间早来排序，即实现小根堆
    public static class MyComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }
}
