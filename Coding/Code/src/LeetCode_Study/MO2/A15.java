package LeetCode_Study.MO2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A15 {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int m = s.length();
            int n = p.length();
            if (m<n) return new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            int []dt1 = new int[26];
            int []dt2 = new int[26];
            for (int i=0;i<n;i++){
                dt1[s.charAt(i)-'a']++;
                dt2[p.charAt(i)-'a']++;
            }
            if (Arrays.equals(dt1, dt2)) res.add(0);
            for (int j=n;j<m;j++){
                dt1[s.charAt(j)-'a']++;
                dt1[s.charAt(j-n)-'a']--;
                if (Arrays.equals(dt1, dt2)) res.add(j-n+1);
            }
            return res;
        }
    }
}
