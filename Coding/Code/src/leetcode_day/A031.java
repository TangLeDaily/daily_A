package leetcode_day;

import java.util.*;

public class A031 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length<3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> LLI = new ArrayList<>();
        HashMap<List<Integer>,Boolean> hmp=new HashMap<>();
        for (int i=0;i<nums.length-2;i++){
            int center = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left<right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    int finalI = i;
                    List<Integer> LI = new ArrayList<>();
                    LI.add(nums[i]);
                    LI.add(nums[left]);
                    LI.add(nums[right]);
                    if (!hmp.containsKey(LI))
                        LLI.add(LI);
                    left++;
                    hmp.put(LI,true);
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else right--;
            }
        }
        return LLI;
    }
}
