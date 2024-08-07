package simple;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历迭代法
 */
public class q144 {
    public List<Integer> preorderTraversal(TreeNode root){

        List<Integer> integerList = new ArrayList<>(16);
        if (root == null){
            return integerList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            integerList.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return integerList;

    }
}
