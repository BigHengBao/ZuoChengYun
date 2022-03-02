package day2;

import java.util.Arrays;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/21/14:03
 * title：：给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，
 * 大于num的数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度O(N)。
 */
public class ArraySort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 2, 6, 1, 3, 9, 2};
        System.out.println("排序前： " + Arrays.toString(arr));
        int x = -1;
        int num = 5;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < num){
                swap(arr, i, ++x);
            }
        }
        System.out.println("排序后： " + Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
