package simple;

import org.junit.Test;
import common.ListNode;

import java.util.HashSet;

/**
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */
public class q141 {
    @Test
    public void test(){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        node2.next = head;
        boolean b = hasCycle2(head);
        System.out.println(b);
    }
    public boolean hasCycle(ListNode head){
        HashSet<ListNode> set = new HashSet<>(16);
        while (head!=null){
            if (!set.contains(head)){
                set.add(head);
            }else {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    public boolean hasCycle2(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode slowIndex = head;
        ListNode fastIndex = head.next;

        while ( fastIndex.next != null && fastIndex.next.next != null){
                slowIndex = slowIndex.next;
                fastIndex = fastIndex.next.next;
            if (slowIndex == fastIndex){
                return true;
            }
        }
        return false;
    }
}
