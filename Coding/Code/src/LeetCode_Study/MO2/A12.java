package LeetCode_Study.MO2;

import java.util.Arrays;

public class A12 {
    class Solution {
        public int pivotIndex(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            int s = 0;
            for (int i=0;i<nums.length;i++){
                s+=nums[i];
                if (2*s-nums[i] == sum){
                    return i;
                }
            }
            return -1;
        }
    }
}
