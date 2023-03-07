package LeetCode_Study.MO2;

import java.util.LinkedList;
import java.util.Queue;

public class A43 {
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
    class CBTInserter {
        Queue<TreeNode> qe;
        TreeNode root;
        public CBTInserter(TreeNode root) {
            qe = new LinkedList<>();
            this.root = root;

            Queue<TreeNode> ls = new LinkedList<>();
            ls.offer(root);
            while (!ls.isEmpty()){
                TreeNode node = ls.poll();
                if (node.left!=null){
                    ls.offer(node.left);
                }
                if (node.right!=null){
                    ls.offer(node.right);
                }
                if (!(node.left != null && node.right != null)){
                    // 存在一个孩子结点不为空，即表示可以执行insert，所以入可插队
                    qe.offer(node);
                }
            }
        }

        public int insert(int v) {
            TreeNode child = new TreeNode(v);
            TreeNode node = qe.peek();
            int ret = node.val;
            if (node.left == null) {
                node.left = child;
            } else {
                node.right = child;
                qe.poll();
            }
            qe.offer(child);
            return ret;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
