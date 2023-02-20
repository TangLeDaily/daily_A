package leetcode_day;


import java.util.Arrays;
import java.util.Collections;

public class A009 {

    public static boolean back(int[] nums, int[] sum, int max, int idx){
        for (int i=0; i<4; i++){
            boolean this_true = false;
            if(sum[i]+nums[idx]>max){
                continue;
            }
            else {
                sum[i]+=nums[idx];
                // System.out.println(idx);
                if (idx+1 != nums.length)
                    this_true = back(nums,sum,max,idx+1);
                else
                    this_true = true;
            }
            if (this_true) return true;
            else{
                sum[i]-=nums[idx];
            }
        }
        return false;
    }

    public static boolean makesquare(int[] matchsticks) {
        int sum[] = new int[]{0,0,0,0};
        Arrays.sort(matchsticks);
        int sum_match = 0;
        for (int i=0; i<matchsticks.length; i++){
            sum_match+=matchsticks[i];
        }
        int avg = sum_match/4;
        return back(matchsticks,sum,avg,0);
    }

    public static void main(String[] args) {
        int []nums = new int[]{
                18,8,20,12,10,1,3,18,7,13,19,2,7,4,12};
        if(makesquare(nums)){
            System.out.println("true");
        }
        else {
            System.out.println("False");
        }
    }
}
