package day2;

import java.util.Arrays;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/21/14:29
 * title：荷兰国旗问题
 * 题目：给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class SortColorTest {
    public static void main(String[] args) {
        int[] arr = {2, 2, 0, 0, 1, 0, 2, 0, 2};
        System.out.println("排序前: " + Arrays.toString(arr));
        sortColor(arr, 0, arr.length - 1);
        System.out.println("排序前: " + Arrays.toString(arr));
    }

    public static void sortColor(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int less = left - 1;
        int more = right;
        int index = 0;
        while (index < more) {
            if (arr[index] < 1) {
                swap(arr, index, ++less);
                index++;
            } else if (arr[index] > 1) {
                swap(arr, index, --more);
            } else {
                index++;
            }
        }
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
