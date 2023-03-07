package LeetCode_Study.MO2;

import java.util.ArrayList;
import java.util.List;

public class A55 {
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
    class BSTIterator {
        private int idx;
        private List<Integer> list;
        public BSTIterator(TreeNode root) {
            idx = 0;
            list = new ArrayList<>();
            toList(root);
        }

        public int next() {
            return list.get(idx++);
        }

        public boolean hasNext() {
            return idx < list.size();
        }

        public void toList(TreeNode root){
            if (root == null) return;
            toList(root.left);
            list.add(root.val);
            toList(root.right);
        }
    }
}
