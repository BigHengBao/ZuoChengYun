package day1;

import java.util.Arrays;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/20/16:41
 * title：选择排序
 */
public class InsertSortTest {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 2, 6, 1, 3, 9, 2};
        System.out.println("排序前： " + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 1; i < arr.length; i++) { // 0~~i做到有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
