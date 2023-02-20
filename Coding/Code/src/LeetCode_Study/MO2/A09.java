package LeetCode_Study.MO2;

public class A09 {
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int len = nums.length;
            int res = 0;
            int dot = 1;
            int l=0;
            for (int r=0;r<len;r++){
                dot *=nums[r];
                while (l<=r && dot >= k){
                    dot /= nums[l];
                    l++;
                }
                res += r-l+1;
            }
            return res;
        }
    }
}
