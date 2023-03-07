package LeetCode_Study.MO2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
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

 */
public class A44 {
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
        public List<Integer> largestValues(TreeNode root) {
            if (root==null){
                return new ArrayList<>();
            }
            res = new ArrayList<>();
            dfs(res, root, 0);
            return res;
        }
        public void dfs(List<Integer> list, TreeNode root, int shen){
            if(shen == list.size()){
                list.add(root.val);
            }else {
                list.set(shen, Math.max(list.get(shen),root.val));
            }
            if (root.left!=null){
                dfs(list, root.left,shen+1);
            }
            if (root.right!=null){
                dfs(list, root.right,shen+1);
            }
        }
    }
    class Solution2 {


        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root==null) return res;
            Queue<TreeNode> qe = new LinkedList<>();
            qe.offer(root);
            while (!qe.isEmpty()){
                int len = qe.size();
                int max = Integer.MIN_VALUE;
                while (len>0){
                    len--;
                    TreeNode t = qe.poll();
                    max = Math.max(t.val, max);
                    if (t.left!=null){
                        qe.offer(t.left);
                    }
                    if (t.right!=null){
                        qe.offer(t.right);
                    }
                }
                res.add(max);
            }
            return res;
        }
    }


}
