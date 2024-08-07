package middle;

import common.ListNode;
import org.junit.Test;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class q19 {
    @Test
    public void test(){
        ListNode head = new ListNode(1);
        System.out.println(removeNthFromEnd(head, 1));
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode dummyHead = new ListNode(0, head);
        ListNode fastNode = head;
        ListNode slowNode = dummyHead;
        for (int i = 0; i < n; i++ ) {
            fastNode = fastNode.next;
        }
        while (fastNode != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        slowNode.next = slowNode.next.next;

        return dummyHead.next;
    }
}
