package LeetCode_Study.MO2;

import java.util.HashSet;
import java.util.Set;

public class A22 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public class Solution {

        public ListNode detectCycle(ListNode head) {
            ListNode dum = head;
            Set<ListNode> set = new HashSet<>();
            while (dum!=null){
                if (set.contains(dum)) return dum;
                set.add(dum);
                dum = dum.next;
            }
            return null;
        }
    }

    public class Solution2 {

        public ListNode detectCycle(ListNode head) {
            if (head==null) return head;
            ListNode fast = head;
            ListNode low = head;
            while (fast!=null){
                low = low.next;
                if (fast.next!=null)
                    fast = fast.next.next;
                else return null;
                if (fast==low){
                    ListNode ppp = head;
                    while (ppp!=low){
                        ppp = ppp.next;
                        low = low.next;
                    }
                    return ppp;
                }
            }
            return null;
        }
    }
}
