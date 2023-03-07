package LeetCode_Study.MO2;

public class A53 {
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
        public TreeNode res;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            dfs(root,p.val);
            return res;
        }

        public void dfs(TreeNode root, int value){
            if (root == null) return;
            if (root.val<=value){
                dfs(root.right,value);
            }else {
                res = root;
                dfs(root.left,value);
            }

        }
    }

    class Solution2 {
        TreeNode res;
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            dfs(null,root,p);
            return res;
        }
        public void dfs(TreeNode father,TreeNode root,TreeNode p){
            if(root==null) return;
            if (root==p){
                TreeNode rr = getbest(root.right);
                res = (rr==null)?father:rr;
            }else {
                dfs(root,root.left,p);
                dfs(father,root.right,p);
            }
        }

        public TreeNode getbest(TreeNode root){
            if (root==null) return null;
            TreeNode ss = getbest(root.left);
            return (ss==null)?root:ss;
        }
    }
}
