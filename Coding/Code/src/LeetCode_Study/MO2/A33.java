package LeetCode_Study.MO2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class A33 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String,List<String>> hmp = new HashMap<>();
            for (String str:strs){
                char[] strrr = str.toCharArray();
                Arrays.sort(strrr);
                String strr = strrr.toString();
                List<String> list = hmp.getOrDefault(strr, new ArrayList<String>());
                list.add(str);
                hmp.put(strr,list);
            }
            return new ArrayList<List<String>>(hmp.values());
        }
    }
}
