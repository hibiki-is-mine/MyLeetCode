package simple;

import common.ListNode;

public class q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            if (pA == null){
                pA = headB;
            } else{
                pA = pA.next;
            }
            if(pB == null){
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }
}
