package simple;

import common.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author cyj
 * @date 2024/09/30
 */
public class q234 {

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        stack.push(node.val);
        if (node.next == null){
            return true;
        }


        while (node.next != null){
            stack.push(node.val);
            node = node.next;
        }



        return stack.isEmpty();
    }
}
