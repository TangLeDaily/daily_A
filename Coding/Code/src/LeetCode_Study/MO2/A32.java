package LeetCode_Study.MO2;

import java.util.Arrays;
import java.util.HashMap;

public class A32 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length()!=t.length()) return false;
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            Arrays.sort(ss);
            Arrays.sort(tt);
            return Arrays.equals(ss,tt);
        }
    }

    class Solution2 {
        public boolean isAnagram(String s, String t) {
            if (s.length()!=t.length() || s.equals(t)) return false;
            HashMap<Character, Integer> hmp = new HashMap<>();
            for (int i =0;i<s.length();i++){
                char a = s.charAt(i);
                hmp.put(a,hmp.getOrDefault(a,0)+1);
            }
            for (int i =0;i<s.length();i++){
                char a = t.charAt(i);
                hmp.put(a,hmp.getOrDefault(a,0)-1);
                if (hmp.get(a)<0) return false;
            }
            return true;
        }
    }
}
