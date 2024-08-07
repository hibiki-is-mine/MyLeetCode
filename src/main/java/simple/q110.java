package simple;

import common.TreeNode;
import org.junit.Test;

import java.util.Stack;

public class q110 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(1, new TreeNode(2),new TreeNode(3));
        isBalanced(root);
    }
    public boolean isBalanced(TreeNode root) {
        return true;
    }
}
