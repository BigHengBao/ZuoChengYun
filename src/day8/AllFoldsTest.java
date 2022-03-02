package day8;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/2/10:51
 * title：二叉树折纸问题
 */
public class AllFoldsTest {
    public static void main(String[] args) {
        printAllFolds(4);
    }

    public static void printAllFolds(int n) {
        process(1, n, true);
    }

    //  i是节点的层数,n是总层数,down true 凹,down false 凸
    public static void process(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        process(i + 1, n, true);
        System.out.print(down ? "凹 " : "凸 ");
        process(i + 1, n, false);
    }
}
