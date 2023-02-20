package LeetCode_Study.JZ_Offer_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class M15 {
    public List<Integer> findAnagrams(String s2, String s1) {
        List<Integer> res = new ArrayList<>();
        if (s2.length()<s1.length()) return res;
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
            res.add(0);
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
                res.add(left);
            }
        }
        return res;
    }
}
