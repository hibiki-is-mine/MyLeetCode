package simple;

import common.TreeNode;
import org.junit.Test;

public class q222 {

    @Test
    public void test(){
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(countNodes(root));
    }
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }
    public int readNode(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = readNode(root.left);
        int right = readNode(root.right);
        return left + right + 1;
    }
}
