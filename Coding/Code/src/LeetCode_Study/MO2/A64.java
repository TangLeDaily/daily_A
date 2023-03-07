package LeetCode_Study.MO2;

public class A64 {
    /*
    class trie{
        public trie[] children;
        public boolean isEnd;
        public trie() {
            children = new trie[26];
            isEnd = false;
        }
    }
    */

    class trie{
        public trie[] children;
        public boolean isEnd;
        public trie() {
            children = new trie[26];
            isEnd = false;
        }
    }
    class MagicDictionary {
        trie root;
        /** Initialize your data structure here. */
        public MagicDictionary() {
            root = new trie();
        }

        public void buildDict(String[] dictionary) {
            for (String dict : dictionary){
                trie cur = root;
                for (int i=0;i<dict.length();i++){
                    char c = dict.charAt(i);
                    if(cur.children[c-'a']==null)
                        cur.children[c-'a'] = new trie();
                    cur = cur.children[c-'a'];
                }
                cur.isEnd = true;
            }
        }

        public boolean search(String searchWord) {
            return dfs(searchWord, root, 0, false);
        }

        private boolean dfs(String searchWord, trie node, int pos, boolean modified) {
            if (pos == searchWord.length())
                return modified && node.isEnd;
            int idx = searchWord.charAt(pos) - 'a';
            if (node.children[idx] != null) {
                if (dfs(searchWord, node.children[idx], pos + 1, modified)) {
                    return true;
                }
            }
            if (!modified) {
                for (int i = 0; i < 26; ++i) {
                    if (i != idx && node.children[i] != null) {
                        if (dfs(searchWord, node.children[i], pos + 1, true)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
