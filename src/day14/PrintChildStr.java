package day14;

import java.util.ArrayList;
import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/26/19:05
 * title：：暴力递归-->打印一个字符串的全部子序列，包括空字符串
 */
public class PrintChildStr {
    public static void main(String[] args) {
        printChildStr("small");
    }

    public static void printChildStr(String str) {
        char[] chars = str.toCharArray();
        process(chars, 0, new ArrayList<Character>());
    }

    //当前来到i位置，要和不要，走两条路
    //之前的选择，所形成的结果，是str
    private static void process(char[] chars, int i, List<Character> res) {
        if (i == chars.length) {
            printList(res);
            return;
        }
        List<Character> resKeep = copyList(res);
        assert resKeep != null;
        resKeep.add(chars[i]);
        //要当前字符
        process(chars, i + 1, resKeep);

        //不要当前字符
        List<Character> resNoInclude = copyList(res);
        process(chars, i + 1, resNoInclude);
    }

    public static void printList(List<Character> res) {
        System.out.println(res);

    }

    public static List<Character> copyList(List<Character> list) {
        //自己补充
        List<Character> newList = new ArrayList<>(list);
        return newList;
    }
}
