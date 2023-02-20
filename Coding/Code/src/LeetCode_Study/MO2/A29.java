package LeetCode_Study.MO2;

public class A29 {
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
    class Solution {
        public Node insert(Node head, int insertVal) {
            Node insertnode = new Node(insertVal);
            if (head == null){
                insertnode.next = insertnode;
                return insertnode;
            }
            if (head.next==head){
                head.next=insertnode;
                insertnode.next=head;
                return head;
            }
            Node cur = head;
            Node next = cur.next;
            while (next!=head){
                if (insertVal>=cur.val && insertVal<= next.val){
                    cur.next = insertnode;
                    insertnode.next = next;
                    return head;
                }
                if (cur.val>next.val){
                    if (insertVal> cur.val || insertVal< next.val){
                        cur.next = insertnode;
                        insertnode.next = next;
                        return head;
                    }
                }
                cur = cur.next;
                next = next.next;
            }
            cur.next = insertnode;
            insertnode.next = next;
            return head;

        }
    }
}
