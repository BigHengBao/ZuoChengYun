package day2;

import java.util.Arrays;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/21/10:34
 * title：归并排序(递归)
 */
public class MergeSortTest {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 2, 6, 1, 3, 9, 2};
        System.out.println("排序前： " + Arrays.toString(arr));
        process(arr, 0, arr.length - 1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr,left,mid,right);

    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] helper = new int[right - left + 1];  //辅助数组
        int i = 0; //辅助数组index
        int p1 = left; //left指针
        int p2 = mid + 1;  //right指针
        while (p1 <= mid && p2 <= right) {
            helper[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            helper[i++] = arr[p1++];
        }
        while (p2 <= right) {
            helper[i++] = arr[p2++];
        }
        for (i = 0; i < helper.length; i++) {
            arr[left + i] = helper[i];
        }
    }
}
