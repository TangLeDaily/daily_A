package LeetCode_Study.MO2;

import java.util.HashMap;

public class a10 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int res = 0;
            int sum = 0;
            HashMap<Integer,Integer> hmp = new HashMap<>();
            hmp.put(0,1);
            for (int i=0;i<nums.length;i++){
                sum += nums[i];
                if (hmp.containsKey(sum-k)){
                    res+=hmp.get(sum-k);
                }
                hmp.put(sum, hmp.getOrDefault(sum,0)+1);
            }
            return res;
        }
    }
}
