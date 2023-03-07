package LeetCode_Study.MO2;

public class A62 {
    class Trie {
        private Trie[] children;
        private boolean isEnd;
        /** Initialize your data structure here. */
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie node = this;
            for (int i=0;i<word.length();i++){
                char c = word.charAt(i);
                int idx = c-'a';
                if (node.children[idx]==null){
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            node.isEnd=true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        public Trie searchPrefix(String word){
            Trie node = this;
            for (int i=0;i<word.length();i++){
                char c = word.charAt(i);
                int idx = c-'a';
                if (node.children[idx]==null){
                    return null;
                }
                node = node.children[idx];
            }
            return node;
        }
    }


}
