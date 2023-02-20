package LeetCode_Study.MO2;

import java.util.Arrays;

public class A14 {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int l1 = s1.length();
            int l2 = s2.length();
            if (l2<l1) return false;
            int []sum1 = new int[26];
            int []sum2 = new int[26];
            for (int i=0;i<l1;i++){
                sum1[s1.charAt(i)-'a']++;
                sum2[s2.charAt(i)-'a']++;
            }
            if (Arrays.equals(sum1, sum2)) return true;
            for (int i=l1;i<l2;i++){
                sum2[s2.charAt(i)-'a']++;
                sum2[s2.charAt(i-l1)-'a']--;
                if (Arrays.equals(sum1, sum2)) return true;
            }
            return false;
        }
    }
    class Solution2 {
        public boolean checkInclusion(String s1, String s2) {
            int l1 = s1.length();
            int l2 = s2.length();
            if (l2<l1) return false;
            int []sum = new int[26];
            for (int i=0;i<l1;i++){
                sum[s1.charAt(i)-'a']--;
            }
            int l=0;
            for (int r=0;r<l2;r++){
                int x = s2.charAt(r)-'a';
                sum[x]++;
                while (sum[x]>0){
                    l++;
                    sum[s2.charAt(l)-'a']--;
                }
                if (r-l+1==l1){
                    return true;
                }
            }
            return false;
        }
    }
}
