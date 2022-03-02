package day4;

import java.util.Arrays;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/23/10:31
 * title：基数排序(桶排序)
 */
public class RadixSortTest {
    public static void main(String[] args) {
        int[] arr = {2, 2, 0, 0, 1, 0, 2, 0, 2};
        System.out.println("排序前: " + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("排序前: " + Arrays.toString(arr));

    }
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxBits(arr));
    }
    /**
     * 正经排序
     * @param arr    数组
     * @param left   左边界
     * @param right  右边界
     * @param digits 最大值位数
     */
    public static void radixSort(int[] arr, int left, int right, int digits) {
        final int radix = 10;  //表示10进制
        int i = 0, j = 0;
        int[] helper = new int[right - left + 1];  //辅助数组
        // 有多少位进多少次
        for (int d = 1; d <= digits; d++) {
            int[] count = new int[radix];  //相当于 桶
            // 相当于进桶
            for (i = left; i <= right; i++) {
                j = getDigits(arr[i], d); //得到arr[i]的第d位的数
                count[j]++; //count数频+1
            }
            for (i = 1; i < radix; i++) {
                count[i] += count[i - 1];  //求位数累加
            }
            //相当于出桶
            for (i = right; i >= left; i--) {
                j = getDigits(arr[i], d);
                helper[count[j] - 1] = arr[i];
                count[j]--;
            }
            //copy helper to arr
            for (i = left, j = 0; i <= right; i++, j++) {
                arr[i] = helper[j];
            }
        }
    }

    // 找出最大值并计算出位数
    public static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static int getDigits(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }
}
