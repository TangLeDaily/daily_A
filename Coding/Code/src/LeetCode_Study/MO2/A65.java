package LeetCode_Study.MO2;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class A65 {
    class trie{
        public trie[] children;
        public boolean isEnd;
        public String word;
        public trie() {
            children = new trie[26];
            isEnd = false;
        }
    }
    class Solution {
        public int minimumLengthEncoding(String[] words) {
            trie root = new trie();
            HashSet<String> hs = new HashSet<>();
            for (int i = 0;i<words.length;i++){
                String word = words[i];
                List<Character> list = new ArrayList<>();
                trie cur = root;
                for (int j=word.length()-1;j>=0;j--){
                    int cc = word.charAt(j)-'a';
                    if (cur.children[cc] == null){
                        cur.children[cc] = new trie();
                        if (j==0){
                            cur.children[cc].isEnd = true;
                            cur.children[cc].word = word;
                            hs.add(word);
                        }
                    }else{
                        if (j!=0 && cur.children[cc].isEnd){
                            cur.children[cc].isEnd = false;
                            hs.remove(cur.children[cc].word);
                        }
                    }
                    cur = cur.children[cc];
                }
            }
            int sum = 0;
            for (String str:hs){
                sum+=(1+str.length());
            }
            return sum;
        }
    }
}
