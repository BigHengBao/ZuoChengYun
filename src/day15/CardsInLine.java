package day15;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/27/10:29
 * title：暴力递归---> 拿牌问题
 */
public class CardsInLine {
    public static void main(String[] args) {
        int[] arr = { 1, 9, 1 };
        System.out.println(win(arr));
        System.out.println(win2(arr));
    }

    //todo:方法一---> 递归
    public static int win(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(first(arr, 0, arr.length - 1), after(arr, 0, arr.length - 1));
    }

    //先手拿牌
    public static int first(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];  // 只剩下一张牌
        }
        return Math.max(arr[left] + after(arr, left + 1, right), arr[right] + after(arr, left, right - 1));
    }

    //后手拿牌
    public static int after(int[] arr, int left, int right) {
        if (left == right) {
            return 0;  // 无牌可拿
        }
        return Math.min(first(arr, left + 1, right), first(arr, left, right - 1));
    }


    //todo:方法2---> 动态规划
    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }

}
