package LeetCode_Study.MO2;

public class A19 {
    class Solution {
        public boolean validPalindrome(String s) {
            int l=0;
            int r = s.length()-1;
            while (l<r){
                char c1 = s.charAt(l);
                char c2 = s.charAt(r);
                if (c1 == c2){
                    l++;
                    r--;
                }
                else return dd(s,l,r-1) || dd(s,l+1,r);
            }
            return true;
        }
        public boolean dd(String s, int l, int r){
            while (l<r){
                char c1 = s.charAt(l);
                char c2 = s.charAt(r);
                if (c1 == c2){
                    l++;
                    r--;
                }
                else return false;
            }
            return true;
        }
    }
}
