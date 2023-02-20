package LeetCode_Study.MO2;

import java.util.HashMap;

public class A31 {
    class LRUCache {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
            DLinkedNode(){}
            DLinkedNode(int a, int b){
                key =a;
                value = b;
            }
        }

        private HashMap<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size=0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;

        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 如果 key 存在，先通过哈希表定位，再移到头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null){
                DLinkedNode newNode = new DLinkedNode(key,value);
                cache.put(key, newNode);
                addToHead(newNode);
                size++;
                if (size>capacity){
                    DLinkedNode res = removeTail();
                    cache.remove(res.key);
                    size--;
                }
            }else {
                node.value=value;
                moveToHead(node);
            }
        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            head.next.prev=node;
            node.next = head.next;
            head.next = node;
        }
        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }
        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

    }
}
