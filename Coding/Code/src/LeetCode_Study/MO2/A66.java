package LeetCode_Study.MO2;

import java.util.HashMap;

public class A66 {
    class trie{
        public trie[] children;
        public int val;
        public trie() {
            children = new trie[26];
            val = 0;
        }
    }
    class MapSum {
        trie root;
        HashMap<String, Integer> hmp;

        /** Initialize your data structure here. */
        public MapSum() {
            hmp = new HashMap<>();
            root = new trie();
        }

        public void insert(String key, int val) {
            int del = val - hmp.getOrDefault(key,0);
            hmp.put(key,val);
            trie cur = root;
            for (char c:key.toCharArray()){

                if (cur.children[c-'a']==null){
                    cur.children[c-'a'] = new trie();
                }
                cur = cur.children[c-'a'];
                cur.val+=del;
            }
        }

        public int sum(String prefix) {
            trie node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return 0;
                }
                node = node.children[c - 'a'];
            }
            return node.val;
        }
    }
}
