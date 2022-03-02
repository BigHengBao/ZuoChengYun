package day1;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/2/20/10:51
 * title：异或题目，题目：一组数只有两个数出现一次，其他出现两次，找出这两个数：
 */
public class Code02 {
    public static void main(String[] args) {
        int[] arr = {-1, 5, 4, -1, 3, 5, 4, 9};
        process2(arr);
    }

    public static void process2(int[] arr) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        // 取出med中二进制为1的位值（必存在，因为不同值）
        int rightOne = eor & (~eor + 1);
        int eor2 = 0;
        for (int i : arr) {
            if ((i & rightOne) == 0) {
                eor2 ^= i;
            }
        }
        System.out.println("单数次出现的两个数是：" + eor2 + " 和 " + (eor2 ^ eor));
    }
}
