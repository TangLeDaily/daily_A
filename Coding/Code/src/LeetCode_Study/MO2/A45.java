package LeetCode_Study.MO2;

import java.util.LinkedList;
import java.util.Queue;

public class A45 {
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
        int num;
        int ch;
        public int findBottomLeftValue(TreeNode root) {
            num = 0;
            ch = 0;
            dfs(root,0);
            return num;
        }
        public void dfs(TreeNode root, int h){
            if (root==null) return;
            h++;

            if (h>ch){
                ch = h;
                num = root.val;
            }
            dfs(root.left,h);
            dfs(root.right,h);
        }
    }
    class Solution2 {
        public int findBottomLeftValue(TreeNode root) {
            int res = 0;
            Queue<TreeNode> qe = new LinkedList<>();
            qe.offer(root);
            while (!qe.isEmpty()){
                TreeNode t = qe.poll();
                if (t.right!=null){
                    qe.offer(t.right);
                }
                if (t.left!=null){
                    qe.offer(t.left);
                }
                res = t.val;
            }
            return res;
        }
    }
}
