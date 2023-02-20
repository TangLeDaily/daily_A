package LeetCode_Study.MO2;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class A17 {
    class Solution {
        HashMap<Character, Integer> hmp1 = new HashMap<>();
        HashMap<Character, Integer> hmp2 = new HashMap<>();
        public String minWindow(String s, String t) {
            int m = s.length();
            int n = t.length();
            for (int i=0;i<n;i++){
                char c = t.charAt(i);
                hmp1.put(c,hmp1.getOrDefault(c,0)+1);
            }
            int l=0;
            int r=-1;

            int cordl=-1;
            int cordr=-1;
            int cordlen = Integer.MAX_VALUE;
            while (r<m){
                r++;
                char c = t.charAt(r);
                if (r<m && hmp1.containsKey(c)){
                    hmp2.put(c,hmp2.getOrDefault(c,0)+1);
                }
                while (contain() && l<=r){
                    if (r-l+1<cordlen){
                        cordlen = r-l+1;
                        cordl = l;
                        cordr = r+1;
                    }
                    char cc = t.charAt(l);
                    if (hmp1.containsKey(cc)){
                        hmp2.put(cc,hmp2.getOrDefault(cc,0)-1);
                    }
                    l++;
                }
            }
            return cordl==-1?"":t.substring(cordl,cordr);
        }

        public boolean contain(){
            for (Map.Entry<Character,Integer> et:hmp1.entrySet()){
                if (hmp2.getOrDefault(et.getKey(),0)<et.getValue()){
                    return false;
                }
            }
            return true;
        }
    }
}
