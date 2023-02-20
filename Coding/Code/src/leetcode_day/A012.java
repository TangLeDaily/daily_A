package leetcode_day;

import java.util.LinkedList;
import java.util.Queue;

public class A012 {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()){
            int len = q.size();
            Node next = null;
            for (int i=0;i<len;i++){
                Node nowNode = q.poll();
                if (nowNode.left!=null){
                    q.add(nowNode.left);
                }
                if (nowNode.right!=null){
                    q.add(nowNode.right);
                }
                if (next!=null){
                    next.next = nowNode;
                }
                next = nowNode;
            }
        }
        return root;
    }
}
