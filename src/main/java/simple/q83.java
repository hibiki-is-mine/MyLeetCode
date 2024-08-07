package simple;

import org.junit.Test;

/**
 * 83. 删除排序链表中的重复元素
 * 简单
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 *
 */
public class q83 {
    @Test
    public void test(){
        ListNode list2 = new ListNode(1, new ListNode(1,new ListNode(2)));
        ListNode node = deleteDuplicates(list2);
        System.out.println(node);
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
    public ListNode deleteDuplicates(ListNode head){
        int preVal = head.val;
        ListNode node = new ListNode(preVal);
        ListNode start = node;
        while (head != null){
            if (preVal != head.val){
                preVal = head.val;
                node.next = new ListNode(preVal);
                node = node.next;
            }
            head = head.next;
        }
        return start;
    }
}
