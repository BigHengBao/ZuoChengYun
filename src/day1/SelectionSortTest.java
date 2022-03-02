package day1;

import java.util.Arrays;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/20/16:25
 * title：选择排序
 */
public class SelectionSortTest {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 2, 6, 1, 3, 9, 2};
        System.out.println("排序前： " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));

    }

    public static void selectionSort(int[] arr) { //范围每次缩小1，从前往后缩
        if (arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;//找范围内最小值，最开始默认是第一个
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex; //是否比目前最小值还小，如果是，则交换，否则不交换；
            }
            swap(arr, i, minIndex);  //将最小值放到范围的第一个数
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
