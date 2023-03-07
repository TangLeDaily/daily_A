package LeetCode_Study.MO2;

import java.util.ArrayList;
import java.util.List;

public class A52 {
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
        List<Integer> list;
        public TreeNode increasingBST(TreeNode root) {
            list = new ArrayList<>();
            dfs(root);
            TreeNode start = new TreeNode(-1);
            TreeNode node = start;
            for (int no:list){
                node.right = new TreeNode(no);
                node = node.right;
            }
            return start.right;
        }

        public void dfs(TreeNode root){
            if (root==null) return;
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }
    }
}
