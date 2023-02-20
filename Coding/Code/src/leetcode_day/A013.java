package leetcode_day;

public class A013 {
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null){
            return false;
        }
        return isSametree(root,subRoot) || isSametree(root.left, subRoot) || isSametree(root.right, subRoot);
    }

    public boolean isSametree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null){
            return true;
        }
        if (root == null || subRoot == null){
            return false;
        }
        if (root.val != subRoot.val){
            return false;
        }
        return isSametree(root.left, subRoot.left) && isSametree(root.right, subRoot.right);
    }
}
