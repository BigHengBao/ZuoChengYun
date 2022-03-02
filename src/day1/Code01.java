package day1;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/20/10:43
 * title：异或题目，一组数只有一个数出现一次，其他出现两次，找出这个出现一次的数
 */
public class Code01 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 3, 2, 6, 5};
        System.out.println(process1(arr));

    }

    public static int process1(int[] arr) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        return eor;
    }
}
