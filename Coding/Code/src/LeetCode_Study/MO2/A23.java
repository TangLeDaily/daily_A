package LeetCode_Study.MO2;

import java.util.HashSet;

public class A23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public class Solution {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            HashSet<ListNode> HS = new HashSet<>();
            ListNode dum =headA;
            while (dum!=null){
                HS.add(dum);
                dum = dum.next;
            }
            ListNode dum2 = headB;
            while (dum2!=null){
                if (HS.contains(dum2)){
                    return dum2;
                }
                dum2 = dum2.next;
            }
            return null;
        }
    }

    public class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA==null||headB==null){
                return null;
            }
            ListNode pa = headA;
            ListNode pb = headB;
            while (pa!=pb){
                pa = (pa==null)?headB:pa.next;
                pb = (pb==null)?headA:pb.next;
            }
            return pa;
        }
    }
}
