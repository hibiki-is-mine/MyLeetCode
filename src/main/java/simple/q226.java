package simple;

import common.ListNode;
import common.TreeNode;
import org.junit.Test;

public class q226 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(invertTree(root));
    }
    public TreeNode invertTree(TreeNode root) {

        reserve(root);
        return root;
    }
    public void reserve(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left !=null){
            reserve(root.left);
        }
        if (root.right !=null){
            reserve(root.right);
        }
        if (root.left != null || root.right != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }
}
