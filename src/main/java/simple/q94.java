package simple;

import org.junit.Test;
import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class q94 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(2, null, new TreeNode(3)));
        int i = maxDepth(root);
        System.out.println(i);
    }

     public List<Integer> inorderTraversal(TreeNode root){
         ArrayList<Integer> arrayList = new ArrayList<>(16);
         inorderReadTreeNode(arrayList, root);
         return arrayList;
     }
     public void inorderReadTreeNode(ArrayList<Integer> arrayList, TreeNode root){
         if (root == null){
             return;
         }
         inorderReadTreeNode(arrayList, root.left);
         arrayList.add(root.val);
         inorderReadTreeNode(arrayList, root.right);
     }
     /**
      * 使用迭代的方式前序遍历二叉树
      */
     public List<Integer> preorderTraversal(TreeNode root){
         ArrayList<Integer> arrayList = new ArrayList<>(16);
         Stack<TreeNode> stack =  new Stack<>();
         stack.push(root);
         while (!stack.isEmpty()){
             TreeNode node = stack.pop();
             arrayList.add(node.val);
             if (node.left != null){
                 stack.push(node.left);
             }
             if (node.right != null){
                 stack.push(node.right);
             }
         }
         return arrayList;
     }

    /**
     * 使用迭代中序遍历二叉树
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root){
         ArrayList<Integer> arrayList = new ArrayList<>(16);
         if (root == null){
             return arrayList;
         }
         Stack<TreeNode> stack = new Stack<>();
         TreeNode node = root;

         while (node != null||!stack.isEmpty()){
             while (node != null){
                 stack.push(node);
                 node = node.left;
             }
             node = stack.pop();
             arrayList.add(node.val);
             node = node.right;
         }
         return arrayList;
    }
     public boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null && q ==null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
     }

    /**
     * 101. 对称二叉树
     * 简单
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * @param root
     * @return
     */
     public boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }
        if (root.left == null && root.right ==null){
            return true;
        }
        if (root.left == null || root.right == null){
            return false;
        }
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        TreeNode left = root.left;
        TreeNode right = root.right;
        leftStack.push(left);
        rightStack.push(right);

        while (!leftStack.isEmpty() && !rightStack.isEmpty()){
            left = leftStack.pop();
            right = rightStack.pop();
            if (left == null || right == null || left.val != right.val){
                return false;
            }
            if (left.left != null || right.right != null){
                leftStack.push(left.left);
                rightStack.push(right.right);
            }
            if (left.right != null || right.left != null){
                leftStack.push(left.right);
                rightStack.push(right.left);
            }
        }
        return true;
     }
     public int maxDepth(TreeNode root){
         if (root == null) {
             return 0;
         } else {
             int leftHeight = maxDepth(root.left);
             int rightHeight = maxDepth(root.right);
             return Math.max(leftHeight, rightHeight) + 1;
         }
     }
     public TreeNode sortedArrayToBST(int[] nums){
         TreeNode root = sort(nums, 0, nums.length - 1);
        return root;
     }

     public TreeNode sortedListToBST(ListNode head){
         int len = 0;
         ListNode node = head;
         while (node!=null){
            len++;
            node = node.next;
         }
         int[] nums = new int[len];
         int i=0;
         while (head!=null){
             nums[i] = head.val;
             head = head.next;
             i++;
         }
         return sort(nums, 0, nums.length - 1);
     }
     public TreeNode sort(int[] nums, int left, int right){

         if (left <= right){
             int middle = (left+right)/2;
             TreeNode node = new TreeNode(nums[middle]);
             node.left = sort(nums, left, middle-1);
             node.right = sort(nums, middle+1, right);
             return node;
         }
        return null;
     }
     @Test
    public void test2(){
         int[] nums = {1,5,6,7,9,10};
         TreeNode treeNode = sortedArrayToBST(nums);
         System.out.println(treeNode);
     }
}
