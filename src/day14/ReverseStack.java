package day14;

import java.util.Stack;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/26/19:56
 * title：逆序栈问题
 * 给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能使用递归函数，如何实现
 */
public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        integers.add(1);
        integers.add(6);
        integers.add(23);
        integers.add(-5);
        System.out.println("之前： "+integers);
        reverse(integers);
        System.out.println("之后： "+integers);
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int f = f(stack);
        reverse(stack);
        stack.push(f);
    }

    public static int f(Stack<Integer> stack) {
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }
}
