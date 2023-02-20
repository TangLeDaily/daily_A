package LeetCode_Study.JZ_Offer_II;

import java.util.HashMap;

public class M14 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length()<s1.length()) return false;
        HashMap<String,Integer> hmp = new HashMap<>();
        HashMap<String,Integer> hmpp = new HashMap<>();
        for (int i=0;i<s1.length();i++){
            hmp.put(s1.substring(i,i+1),hmp.getOrDefault(s1.substring(i,i+1),0)+1);
        }
        for (int i=0;i<s1.length();i++){
            if (hmp.containsKey(s2.substring(i,i+1))){
                hmpp.put(s2.substring(i,i+1),hmpp.getOrDefault(s2.substring(i,i+1),0)+1);
            }
        }
        if (hmp.equals(hmpp)){
            return true;
        }
        int left=0;
        int right=s1.length()-1;
        while (right<s2.length()-1){
            if (hmp.containsKey(s2.substring(left,left+1))){
                hmpp.put(s2.substring(left,left+1),hmpp.getOrDefault(s2.substring(left,left+1),0)-1);
            }
            left++;
            right++;
            if (hmp.containsKey(s2.substring(right,right+1))){
                hmpp.put(s2.substring(right,right+1),hmpp.getOrDefault(s2.substring(right,right+1),0)+1);
            }
            if (hmp.equals(hmpp)){
                return true;
            }
        }
        return false;
    }
}
