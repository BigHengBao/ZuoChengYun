package day2;

import java.util.Arrays;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/21/10:09
 * title：递归实现数组的最大值
 */
public class ArrMax {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 2, 6, 1, 3, 9, 2};
        int max = getMax(arr, 0, arr.length - 1);
        System.out.println("最大值：" + max);

    }

    public static int getMax(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = left + ((right - left) >> 1); // >> 比 / 快
        int leftMax = getMax(arr, left, mid);
        int rightMax = getMax(arr, mid + 1, right);

        return Math.max(leftMax, rightMax);
    }
}
