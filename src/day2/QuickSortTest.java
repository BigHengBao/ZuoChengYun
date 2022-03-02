package day2;

import java.util.Arrays;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/21/13:31
 * title：快速排序
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 2, 6, 1, 3, 9, 2};
        System.out.println("排序前： " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    //arr[left...right]排好序
    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2) {
            return;
        }
        if (left < right) {
            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
            int[] p = partition(arr, left, right);
            quickSort(arr, left, p[0] - 1);
            quickSort(arr, p[1] + 1, right);
        }

    }

    /**
     * 处理arr[left..right]的方法
     * 默认以arr[right]做划分arr[right]-> p ,< p,==p,
     * 返回等于区域(左右边界),所以返回一个长度为2的数组p[]
     */
    public static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (arr[left] < arr[right]) {  //当前数 < 划分值
                swap(arr, ++less, left++);
            } else if (arr[left] > arr[right]) {  //当前数 > 划分值
                swap(arr, --more, left);
            } else {
                left++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
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
