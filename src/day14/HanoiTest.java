package day14;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/26/10:36
 * title：暴力递归---> 汉诺塔
 */
public class HanoiTest {
    public static void hanoi(int n) {
        if (n > 0) {
            func(n, "左", "中", "右");
        }
    }

    private static void func(int i, String start, String end, String other) {
        if (i == 1) {
            System.out.println("move 1 from " + start + " to " + end);
        } else {
            func(i - 1, start, other, end);
            System.out.println("move " + i + " from " + start + " to " + end);
            func(i - 1, other,end,start);
        }
    }

    public static void main(String[] args) {
        hanoi(5);
    }
}
