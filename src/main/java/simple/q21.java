package simple;

import org.junit.Test;

import java.util.List;

/**
 * 21. 合并两个有序链表
 * 简单
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author hibiki
 */
public class q21 {

    @Test
    public void test(){
        ListNode list1 = null;
        ListNode list2 = new ListNode(1, new ListNode(3));
        ListNode listNode = mergeTwoListNode(list1, list2);
        System.out.println(listNode);
    }
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "val:"+val+"\n"+next;
        }
    }

    public ListNode mergeTwoListNode(ListNode list1, ListNode list2){
        ListNode node = new ListNode();
        ListNode head = node;
        while (list1 != null && list2 != null){
            int val1 = list1.val;
            int val2 = list2.val;
            if (val1 < val2){
                node.next = new ListNode(val1);
                list1 = list1.next;
                node = node.next;
            }else{
                node.next = new ListNode(val2);
                list2 = list2.next;
                node = node.next;
            }
        }
        if (list1 == null){
            node.next = list2;
        }
        if (list2 == null){
            node.next = list1;
        }
        return head.next;
    }
}
