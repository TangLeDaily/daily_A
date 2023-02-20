package leetcode_day;

public class A001 {

     public static class TreeNode {
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

    static class Solution {


        public int sumRootToLeaf(TreeNode root) {
            return find(root, 0);
        }

        public int find(TreeNode root, int sum){
            sum = sum*2 + root.val;
            int left = 0;
            int right = 0;
            if(root.left != null){
                left = find(root.left, sum);
            }
            if(root.right != null){
                right = find(root.right, sum);
            }
            if (root.left == null && root.right == null){
                return sum;
            }
            else {
                return left+right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode tee = new TreeNode(1,new TreeNode(0, new TreeNode(0), new TreeNode(1)), new TreeNode(1, new TreeNode(0), new TreeNode(1)));
        System.out.println(new Solution().sumRootToLeaf(tee));
    }
}
