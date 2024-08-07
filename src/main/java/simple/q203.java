package simple;

import common.ListNode;
import org.junit.Test;

public class q203 {
    @Test
    public void test(){
        ListNode head = new ListNode(7, new ListNode(7, new ListNode(2)));
        ListNode node = removeElements(head, 7);
        System.out.println(node);
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode dummyHead =  new ListNode();
        dummyHead.next = head;
        ListNode node = dummyHead;
        while(node.next != null){
            if(node.next.val == val){
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return dummyHead.next;
    }
}
