package leetcode_day;

import java.util.Arrays;

public class A036 {
    public static void main(String[] args) {
        System.out.println(new A036().pivotIndex(new int[]{}));
    }
    public int pivotIndex(int[] nums) {
        int tsum = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i=0;i< nums.length;i++){

            if (sum == tsum-sum-nums[i]){
                return i;
            }
            sum+=nums[i];
        }
        return -1;
    }
}
