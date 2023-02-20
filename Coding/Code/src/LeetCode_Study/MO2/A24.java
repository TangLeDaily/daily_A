package LeetCode_Study.MO2;

import java.util.List;

public class A24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur!=null){
                ListNode nex = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nex;
            }
            return pre;
        }
    }

    class Solution2 {
        public ListNode reverseList(ListNode head) {
           if (head == null || head.next==null){
               return head;
           }
           ListNode newHead = reverseList(head.next);
           head.next.next = head;
           head.next = null;
           return newHead;
        }
    }
}
