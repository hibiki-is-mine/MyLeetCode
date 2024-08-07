package simple;

import common.TreeNode;
import org.junit.Test;

public class q111 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),new TreeNode(3));
        System.out.println(minDepth(root));
    }
    public int minDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = minDepth2(root.left);
        int rightDepth = minDepth2(root.right);

        if(leftDepth == 0 && rightDepth == 0){//同时左右节点深度同时位0说明是叶子节点，返回1
            return 1;
        }else if (leftDepth == 0){//左节点深度为0，说明左节点为空，返回右节点深度
            return rightDepth+1;
        }else if (rightDepth == 0){
            return leftDepth+1;//右节点深度为0，说明右节点为空，返回左节点深度
        }else {//左右节点深度都不为0，说明此节点有左右节点，返回其中深度较小的那一个
            return Math.min(rightDepth, leftDepth) + 1;
        }
    }
    public int minDepth(TreeNode root){
        if (root == null){
            return 0;
        } else if (root.left == null && root.right == null){
            return 1;
        } else if (root.left ==null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        }else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

}
