package simple;

import common.ListNode;
import org.junit.Test;

public class q206 {
    @Test
    public void test(){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode node = reverseList(head);
        System.out.println(node);
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            //获取当前指针的下一位
            ListNode temp = curr.next;
            //当前节点指向它的前一位
            curr.next = prev;
            //将当前节点的引用赋值为prev
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
