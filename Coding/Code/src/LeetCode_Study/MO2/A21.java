package LeetCode_Study.MO2;

import java.util.Deque;
import java.util.LinkedList;

public class A21 {



      public class ListNode {
          int val;
          ListNode next;
         ListNode() {}
        ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dum = new ListNode(0,head);
            int len = getLength(head);
            ListNode cur = dum;
            for (int i=0;i<len-n;i++){
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return dum.next;
        }
        public int getLength(ListNode head) {
            int length = 0;
            while (head != null) {
                ++length;
                head = head.next;
            }
            return length;
        }
    }

    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dum = new ListNode(0,head);
            Deque<ListNode> dq = new LinkedList<>();
            ListNode cur = dum;
            while (cur!=null){
                dq.push(cur);
                cur = cur.next;
            }
            for (int i=0;i<n;i++){
                dq.pop();
            }
            ListNode pre = dq.pop();
            pre.next=pre.next.next;
            return dum.next;
        }
    }

    class Solution3 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dum = new ListNode(0,head);
            ListNode l=dum;
            ListNode r = head;
            for (int i=0;i<n;i++){
                r=r.next;
            }
            while (r!=null){
                r=r.next;
                l=l.next;
            }
            l.next=l.next.next;
            return dum.next;
        }
    }
}
