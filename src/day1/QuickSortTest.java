package day1;

import java.util.Arrays;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/20/17:07
 * title：
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 2, 6, 1, 3, 9, 2};
        System.out.println("排序前： " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 分区过程
     * a[] 待分区数组
     * left 待分区数组最小下标
     * right 待分区数组最大下标
     */
    public static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int temp = qSort(a, left, right);
            quickSort(a, left, temp - 1);
            quickSort(a, temp + 1, right);
        }
    }

    /**
     * 排序过程
     * a 待排序数组
     * left 待排序数组最小下标
     * right 待排序数组最大下标
     *
     * @return 排好序之后基准数的位置下标，方便下次的分区
     */
    public static int qSort(int[] a, int left, int right) {
        int temp = a[left];//定义基准数，默认为数组的第一个元素
        while (left < right) {//循环执行的条件
            while (left < right && a[right] > temp) {
                right--;
            }

            if (left < right) {
                a[left++] = a[right];
            }

            while (left < right && a[left] <= temp) {
                left++;
            }
            if (left < right) {
                a[right--] = a[left];
            }
        }

        a[left] = temp;
        return left;
    }
}
