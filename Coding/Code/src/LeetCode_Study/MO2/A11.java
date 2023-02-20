package LeetCode_Study.MO2;

import java.util.HashMap;

public class A11 {
    class Solution {
        public int findMaxLength(int[] nums) {
            int max = 0;
            HashMap<Integer, Integer> hmp = new HashMap<>();
            hmp.put(0,-1);
            int count = 0;
            for (int i=0;i<nums.length;i++){
                if (nums[i]==1) count++;
                else count--;
                if (hmp.containsKey(count)){
                    max = Math.max(max, i-hmp.get(count));
                }else {
                    hmp.put(count,i);
                }
            }
            return max;
        }
    }

}
