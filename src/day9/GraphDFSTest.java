package day9;

import java.util.HashSet;
import java.util.Stack;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/3/11:19
 * title：图的深度优先遍历
 */
public class GraphDFSTest {
    public static void main(String[] args) {

    }

    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {//如果set中没有下一个的节点就继续
                    stack.push(cur);//先把当前的节点重新放进去栈中
                    stack.push(next);//再把下一个节点放进去栈中
                    set.add(next);//set集合中添加下一个节点
                    System.out.println(next.value);//打印下一个节点的值
                    break;//不再继续进行当前的这个循环了，重新回到while循环中，继续下一个节点的遍历先
                }
            }
        }
    }
}
