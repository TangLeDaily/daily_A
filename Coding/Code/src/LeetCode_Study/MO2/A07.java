package LeetCode_Study.MO2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A07 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res =new ArrayList<>();
            for (int i=0;i<nums.length;i++){
                if (i>0&&nums[i]==nums[i-1])
                    continue;
                int l=i+1;
                int r=nums.length-1;
                while (l<r){
                    if (l>i+1&&nums[l]==nums[l-1]){
                        l++;
                        continue;
                    }
                    if (r<nums.length-1&&nums[r]==nums[r+1]){
                        r--;
                        continue;
                    }
                    if (nums[l]+nums[r]+nums[i]==0){
                        int finalI = i;
                        int finalL = l;
                        int finalR = r;
                        res.add(new ArrayList<>(){{add(nums[finalL]);add(nums[finalR]);add(nums[finalI]);}});
                        l++;
                        r--;
                    }
                    else if (nums[l]+nums[r]+nums[i]>0){
                        r--;
                    }
                    else l++;
                }
            }
            return res;
        }
    }
}
