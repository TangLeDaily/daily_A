package LeetCode_Study.MO2;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A46 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        List<Integer> res;
        int ch;
        public List<Integer> rightSideView(TreeNode root) {
            res = new ArrayList<>();
            if (root==null) return res;
            dfs(root, 0);
            ch = 0;
            return res;
        }

        public void dfs(TreeNode root, int h){
            if (h==ch){
                ch++;
                res.add(root.val);
            }
            if (root.right!=null){
                dfs(root.right,h+1);
            }
            if (root.left!=null){
                dfs(root.left,h+1);
            }
        }
    }

    class Solution2 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root==null) return res;
            Queue<TreeNode> qe = new LinkedList<>();
            qe.offer(root);
            while (!qe.isEmpty()){
                int len =qe.size();
                int size = len;
                while (len>0){
                    TreeNode t = qe.poll();
                    if (len==size){
                        res.add(t.val);
                    }
                    len--;
                    if (t.right!=null){
                        qe.offer(t.right);
                    }
                    if (t.left!=null){
                        qe.offer(t.left);
                    }
                }
            }
            return res;
        }
    }
}
