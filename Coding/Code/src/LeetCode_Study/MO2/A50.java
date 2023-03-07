package LeetCode_Study.MO2;

import java.util.HashMap;

public class A50 {
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
        public int pathSum(TreeNode root, long targetSum) {
            if (root == null) return 0;
            long ret = dfs(root,targetSum);
            ret += pathSum(root.left, targetSum);
            ret += pathSum(root.right, targetSum);
            return (int)ret;
        }

        public long dfs(TreeNode root, long targetSum){
            long res = 0;
            if (root == null) return res;
            if (root.val == targetSum) res++;
            res += dfs(root.left, targetSum-root.val);
            res += dfs(root.right, targetSum-root.val);
            return res;
        }
    }
    class Solution1 {
        HashMap<Long,Integer> hmp;
        public int pathSum(TreeNode root, long targetSum) {
            hmp = new HashMap<>();
            hmp.put(0L,1);
            return dfs(root,targetSum, 0);
        }

        public int dfs(TreeNode root, long targetSum, long sum){
            if (root == null) return 0;
            int res = 0;
            sum += root.val;
            res = hmp.getOrDefault(sum - targetSum, 0);
            hmp.put(sum,hmp.getOrDefault(sum,0)+1);
            res += dfs(root.left,targetSum, sum);
            res += dfs(root.right,targetSum, sum);
            hmp.put(sum,hmp.getOrDefault(sum,0)-1);
            return res;
        }

    }

}
