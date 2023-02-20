package LeetCode_Study.MO2;

public class A28 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node head){
        Node cur = head;
        Node last = null;
        while (cur!=null){
            Node next = cur.next;
            if (cur.child!=null){
                Node childlast = dfs(cur.child);

                // next = cur.next;
                cur.next = cur.child;
                cur.child.prev = cur;

                if (next!=null){
                    childlast.next = next;
                    next.prev = childlast;
                }

                cur.child = null;
                last = childlast;
            }else {
                last =cur;
            }
            cur = next;
        }
        return last;
    }
}
