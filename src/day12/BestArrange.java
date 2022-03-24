package day12;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/6/20:02
 * title：会议安排问题
 */
public class BestArrange {
    public static void main(String[] args) {

    }

    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProGramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int timePoint) {
        Arrays.sort(programs, new ProGramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (timePoint <= programs[i].start) {
                result++;
                timePoint = programs[i].end;
            }
        }
        return result;
    }
}
