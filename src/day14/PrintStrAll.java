package day14;

import java.util.ArrayList;
import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/26/19:26
 * title：打印一个字符串的全部排列
 */
public class PrintStrAll {
    public static void main(String[] args) {
        System.out.println(permutation("big"));
    }

    public static ArrayList<String> permutation(String str){
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs,0,res);
        return res;

    }
    //str[i..]范围上，所有的字符，都可以在i位置上，后续都去尝试
    //str[0..i-1]范围上，是之前做的选择
    //把所有字符串形成的全排列，加入到res去
    public static void process(char[] str, int i, List<String> res) {
        if (i == str.length) {
            res.add(String.valueOf(str));
        }

        //防止重复排列
        boolean[] visit = new  boolean[26];
        for (int j = i; j < str.length; j++) {
            //分支界限
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                process(str, i + 1, res);
                swap(str, i, j);
            }
        }
    }

    private static void swap(char[] str, int k, int i) {
        char c = str[k];
        str[k] = str[i];
        str[i] = c;
    }
}
