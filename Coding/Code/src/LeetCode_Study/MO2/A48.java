package LeetCode_Study.MO2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A48 {
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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return dfs(root, "");
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String []datalist = data.split(",");
            List<String> list = new ArrayList<String>(Arrays.asList(datalist));
            return dfs2(list);
        }

        public String dfs(TreeNode root, String str){
            if (root==null) str+="None,";
            else {
                str+= root.val+",";
                str = dfs(root.left,str);
                str = dfs(root.right,str);
            }
            return str;
        }

        public TreeNode dfs2(List<String> list){
            if (list.get(0).equals("None")){
                list.remove(0);
                return null;
            }
            TreeNode node  = new TreeNode(Integer.parseInt(list.get(0)));
            list.remove(0);
            node.left = dfs2(list);
            node.right = dfs2(list);
            return node;
        }
    }

}
