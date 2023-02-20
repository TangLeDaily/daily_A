package LeetCode_Study.MO2;

import java.util.Deque;
import java.util.LinkedList;

public class A25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Deque<Integer> stack1 = new LinkedList<>();
            Deque<Integer> stack2 = new LinkedList<>();
            ListNode dum1 = l1;
            ListNode dum2 = l2;
            while (dum1!=null){
                stack1.push(dum1.val);
                dum1 = dum1.next;
            }
            while (dum2!=null){
                stack2.push(dum2.val);
                dum2 = dum2.next;
            }
            int jin = 0;
            ListNode res = null;
            while (!stack1.isEmpty() || !stack2.isEmpty() || jin!=0){
                int a =stack1.isEmpty()?0:stack1.pop();
                int b = stack2.isEmpty()?0:stack2.pop();
                int cur = a+b+jin;
                jin = cur/10;
                cur %= 10;
                ListNode cnode = new ListNode(cur);
                cnode.next = res;
                res = cnode;
            }
            return res;
        }
    }
}
