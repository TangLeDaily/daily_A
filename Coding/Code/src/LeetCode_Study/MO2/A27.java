package LeetCode_Study.MO2;

import java.util.ArrayList;
import java.util.List;

public class A27 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public boolean isPalindrome(ListNode head) {
            List<Integer> LL = new ArrayList<>();
            ListNode dum = head;
            while (dum!=null){
                LL.add(dum.val);
                dum = dum.next;
            }
            int l=0;
            int r=LL.size()-1;
            while (l<r){
                if (!LL.get(l).equals(LL.get(r))){
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }

    class Solution2 {
        public boolean isPalindrome(ListNode head) {
            if (head==null) return true;

            ListNode fast = head;
            ListNode low = head;
            while (fast.next!=null && fast.next.next!=null){
                low = low.next;
                fast = fast.next.next;
            }
            ListNode l2 = low.next;
            low.next = null;

            ListNode pre = null;
            ListNode cur = l2;
            while (cur!=null){
                ListNode nex = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nex;
            }
            l2 = pre;

            ListNode l1 = head;
            while (l2!=null){
                if (l1.val!=l2.val){
                    return false;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            return true;
        }
    }

    class Solution3 {

        private ListNode front;
        public boolean isPalindrome(ListNode head) {
            front = head;
            return cc(head);
        }
        private boolean cc(ListNode head){
            if (head!=null){
                if (!cc(head.next)){
                    return false;
                }
                if (head.val!=front.val){
                    return false;
                }
                front = front.next;
            }
            return true;
        }
    }
}
