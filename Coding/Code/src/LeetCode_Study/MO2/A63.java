package LeetCode_Study.MO2;

import java.util.List;

public class A63 {
    class trie{
        public trie[] children;
        public boolean isEnd;
        public trie() {
            children = new trie[26];
            isEnd = false;
        }
    }
    class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {
            trie root = new trie();
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
            String []words = sentence.split(" ");
            StringBuffer sent = new StringBuffer();
            for (int j=0;j<words.length;j++){
                String word = words[j];
                trie cur = root;
                for (int i = 0; i<word.length();i++){
                    char c = word.charAt(i);
                    if (cur.children[c-'a']==null){
                        sent.append(word);
                        break;
                    }
                    else if (cur.children[c-'a'].isEnd){
                        sent.append(word, 0, i + 1);
                        break;
                    }else {
                        cur = cur.children[c-'a'];
                    }
                    if(i==word.length()-1){
                        sent.append(word);
                        break;
                    }
                }
                if (j!=words.length-1){
                    sent.append(" ");
                }
            }
            System.out.println(sent);
            return sent.toString();
        }
    }
}
