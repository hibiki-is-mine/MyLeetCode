package middle;

import common.ListNode;
import org.junit.Test;

public class q24 {
    @Test
    public void test(){
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode listNode = swapPairs(node);
        System.out.println(listNode);
    }
    public ListNode swapPairs(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while (slowPointer.next != null ){
            slowPointer.next = fastPointer.next;
            fastPointer.next =slowPointer;

            if (slowPointer.next == null){
                break;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next.next;
        }
        return newHead;
    }
}
