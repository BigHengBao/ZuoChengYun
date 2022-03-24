package day13;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/24/10:06
 * title：贪心算法--->按最低字典序拼接字符串
 * 给定一个字符串类型的数组strs，找到一种拼接方式，使得把所有字符串拼起来之后形成的字符串具有最低的字典序。
 */
public class StrSort {

    public static void main(String[] args) {
        String[] strs = {"s","hikj","o","022"};
        System.out.println(new StrSort().getLowest(strs));
    }
    //自定义比较器
    public class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);  //那个小放前面
        }
    }

    public String getLowest(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (String str : strs) {
            res += str;
        }
        return res;
    }

}
