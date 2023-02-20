package LeetCode_Study.MO2;

import java.util.ArrayList;
import java.util.Arrays;

public class A08 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int len= nums.length;
            if (len==0) return 0;
            int l=0;
            int r=0;
            int min= Integer.MAX_VALUE;
            int sum = 0;
            while (r<len){
                sum+=nums[r];
                while (sum>=target){
                    min = Math.min(min,r-l+1);
                    sum-=nums[l];
                    l++;
                }
                r++;
            }
            return min==Integer.MAX_VALUE?0:min;
        }
    }

    class Solution2 {
        public int minSubArrayLen(int target, int[] nums) {
            int len= nums.length;
            if (len==0) return 0;
            int min= Integer.MAX_VALUE;
            int sum[] = new int[len+1];
            for (int i=1;i<len+1;i++){
                sum[i] = sum[i-1]+nums[i-1];
            }
            for (int i=1;i<len+1;i++){
                int tar = target+sum[i-1];
                int b = Arrays.binarySearch(sum, tar);
                if (b<0){
                    b = -b - 1;
                }
                if (b<=len){
                    min = Math.min(min,b-i+1);
                }
            }

            return min==Integer.MAX_VALUE?0:min;
        }
    }
}
