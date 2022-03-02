package day8;

import org.w3c.dom.Node;

import javax.xml.stream.events.NotationDeclaration;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/2/9:50
 * title：求二叉树对应节点的后继节点
 */
public class BehindNodeTest {
    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;
    }

    public static void main(String[] args) {

    }

    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getMostRight(node.right);
        } else {  //无右子树
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getMostRight(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
