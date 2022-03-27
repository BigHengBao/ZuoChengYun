package day15;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/27/10:59
 * title：字母和数字对应问题
 * 规定1和A对应，2和B对应，3和C对应。。
 * 那么一个数字字符串比如“111”，就可以转化为“AAA”，“KA”，和“AK”
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果
 */
public class CharToNum {
    public static void main(String[] args) {
        String str = "12312";
        System.out.println(process(str.toCharArray(), 0));
    }

    public static int process(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (i == '0') {
            return 0;
        }
        if (str[i] == '1') {
            int res = process(str, i + 1);
            if (i + 1 < str.length) {
                res += process(str, i + 2);
            }
            return res;
        }
        if (str[i] == '2') {
            int res = process(str, i + 1);
            if (i + 1 < str.length && str[i + 1] >= '0' && str[i + 1] <= '6') {
                res += process(str, i + 1);
            }
            return res;
        }
        return process(str, i + 1);
    }
}
