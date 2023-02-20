package LeetCode_Study.JZ_Offer_II;

public class L18 {
    public static void main(String[] args) {
        System.out.println(new L18().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        if (len==1) return true;
        int left = 0;
        int right = len-1;
        while (left<=right){
            if (!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            else {
                if (Character.toLowerCase(s.charAt(left))==Character.toLowerCase(s.charAt(right))){
                    left++;
                    right--;
                }
                else return false;
            }
        }
        return true;
    }
}
