package LeetCode_Study.MO2;

import java.util.ArrayList;
import java.util.List;

public class A26 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public void reorderList(ListNode head) {
            if (head==null) return;
            List<ListNode> LL = new ArrayList<>();
            ListNode dum =head;
            while (dum!=null){
                LL.add(dum);
                dum = dum.next;
            }
            int i=0;
            int j=LL.size()-1;
            while (i<j){
                LL.get(i).next = LL.get(j);
                i++;
                if (i==j) break;
                LL.get(j).next = LL.get(i);
                j--;
            }
            LL.get(i).next=null;
        }
    }

    class Solution2 {
        public void reorderList(ListNode head) {
            if (head==null) return;
            ListNode l1 = head;
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

            ListNode l1_temp;
            ListNode l2_temp;
            while (l1!=null && l2!=null){
                l1_temp = l1.next;
                l2_temp = l2.next;
                l1.next = l2;
                l1 = l1_temp;
                l2.next = l1;
                l2 = l2_temp;
            }
        }
    }

}
