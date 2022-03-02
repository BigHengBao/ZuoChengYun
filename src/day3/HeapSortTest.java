package day3;

import java.util.Arrays;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/22/19:29
 * title：堆排序
 */
public class HeapSortTest {
    public static void main(String[] args) {
        int[] arr = {2, 2, 0, 0, 1, 0, 2, 0, 2};
        System.out.println("排序前: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序前: " + Arrays.toString(arr));
    }

    //堆排序
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);

        while (heapSize > 0) {
            heapIfy(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    // 构造大根堆（通过新插入的数上升）
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }

    }

    //将剩余的数构造成大根堆（通过顶端的数下降）
    public static void heapIfy(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;  //左孩子下标
        while (left < heapSize) {  //下方还有左孩子
            //两个孩子中，把较大的孩子的下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //父和较大孩子值较大的给largest
            largest = arr[index] < arr[largest] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
