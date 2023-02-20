package leetcode_day;

public class A018 {
    public static class TreeNode {
        // 二叉树定义
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
    public static int getDepth(TreeNode tree){
        if (tree == null) return 0;
        int tree_left = getDepth(tree.left);
        int tree_right = getDepth(tree.right);
        // 找左右子树最大深度返回
        return tree_left > tree_right ? tree_left+1 : tree_right+1;
    }
}




