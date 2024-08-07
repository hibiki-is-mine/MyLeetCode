package simple;

import common.TreeNode;
import org.junit.Test;

import java.util.Stack;

public class q104 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3)));
        int i = maxDepth(root);
        System.out.println(i);
    }

    /**
     * 使用迭代的方式查找二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root){
        if (root == null){
            return 0;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(1);

        int maxDepth = 0;
        int minDepth = 0;
        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            maxDepth = Math.max(maxDepth, depth);

            if (node.left != null){
                nodeStack.push(node.left);
                depthStack.push(depth+1);
            }
            if (node.right != null){
                nodeStack.push(node.right);
                depthStack.push(depth+1);
            }
        }
        return maxDepth;
    }

    /**
     * 使用递归的方法获取二叉树最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.min(leftDepth, rightDepth)+1;
    }
}
