package LeetCode_Study.MO2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;

public class A49 {
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
        public int sumNumbers(TreeNode root) {
            return dfs(root,0);
        }

        public int dfs(TreeNode root, int pre){
            if (root==null) return 0;
            int sum = pre*10 + root.val;
            if (root.left == null && root.right == null) {
                return sum;
            } else {
                return dfs(root.left, sum)+dfs(root.right,sum);
            }
        }
    }

    class Solution2 {
        public int sumNumbers(TreeNode root) {
            if (root==null) return 0;
            int sum = 0;
            Queue<TreeNode> qeT = new LinkedList<>();
            Queue<Integer> qeN = new LinkedList<>();
            qeT.offer(root);
            qeN.offer(root.val);
            while (!qeT.isEmpty()){
                TreeNode node = qeT.poll();
                int num = qeN.poll();
                if (node.left==null && node.right==null){
                    sum+=num;
                }else {
                    if (node.left!=null){
                        qeT.offer(node.left);
                        qeN.offer(num*10+node.left.val);
                    }
                    if (node.right!=null){
                        qeT.offer(node.right);
                        qeN.offer(num*10+node.right.val);
                    }
                }
            }
            return sum;
        }
    }
}
