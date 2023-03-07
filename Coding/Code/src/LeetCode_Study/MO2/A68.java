package LeetCode_Study.MO2;

public class A68 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length-1;
            int res= nums.length;
            while (left<=right){
                int mid = (right-left)/2+left;
                if (target<=nums[mid]){
                    res = mid;
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
            return res;
        }
    }
}
