package LeetCode_Study.MO2;

public class A18 {
    class Solution {
        public boolean isPalindrome(String s) {
            StringBuffer SB = new StringBuffer();
            for (int i=0;i<s.length();i++){
                if (Character.isLetterOrDigit(s.charAt(i)))
                    SB.append(Character.toLowerCase(s.charAt(i)));
            }
            StringBuffer SB2 = new StringBuffer(SB).reverse();
            return SB.toString().equals(SB2.toString());
        }
    }

    class Solution2 {
        public boolean isPalindrome(String s) {
            int n=s.length();
            int l=0;
            int r = n-1;
            while (l<r){
                while (l<r && !Character.isLetterOrDigit(s.charAt(l))){
                    l++;
                }
                while (l<r && !Character.isLetterOrDigit(s.charAt(r))){
                    r--;
                }
                if (l<r){
                    if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                        return false;
                    }
                    l++;
                    r--;
                }
            }
            return true;
        }
    }
}
