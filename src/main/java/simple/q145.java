package simple;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 使用迭代后序遍历二叉树
 */
public class q145 {
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> integerList = new ArrayList<>(16);
        if (root == null){
            return integerList;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                integerList.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return integerList;
    }
}
