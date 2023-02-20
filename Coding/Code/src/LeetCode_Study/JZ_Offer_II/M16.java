package LeetCode_Study.JZ_Offer_II;

import java.util.HashMap;

public class M16 {

    public static void main(String[] args) {
        System.out.println(new M16().lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        HashMap<String , Integer> hmp = new HashMap<>();
        if (s.length()==0) return 0;
        if (s.length()==1) return 1;
        int left=0;
        int right=0;
        int best=0;
        hmp.put(s.substring(left,left+1),hmp.getOrDefault(s.substring(left,left+1),0)+1);
        while (right<s.length()-1){
            if (!hmp.containsValue(2)){
                best = Math.max(best,right-left+1);
                right++;
                hmp.put(s.substring(right,right+1),hmp.getOrDefault(s.substring(right,right+1),0)+1);
            }
            else {
                hmp.put(s.substring(left,left+1),hmp.getOrDefault(s.substring(left,left+1),0)-1);
                left++;
            }
        }
        if (!hmp.containsValue(2)){
            best = Math.max(best,right-left+1);
        }
        return best;
    }
}
