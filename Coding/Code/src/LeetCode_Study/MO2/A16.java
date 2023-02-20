package LeetCode_Study.MO2;

import java.util.HashSet;
import java.util.Set;

public class A16 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> hs = new HashSet<>();
            int n = s.length();
            int max = 0;
            int r = -1;
            for (int i=0;i<s.length();i++){
                if (i!=0){
                    hs.remove(s.charAt(i-1));
                }
                while (r+1<n && !hs.contains(s.charAt(r+1))){
                    hs.add(s.charAt(r+1));
                    r++;
                }
                max = Math.max(max,r-i+1);
            }
            return max;
        }
    }
}
