package leetcode_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A008 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);// xiao --> da
        int len = nums.length;
        List<List<Integer>> nnn = new ArrayList<List<Integer>>();
        for(int i=0;i<len;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int a=nums[i];
            int b_idx = i+1;
            int c_idx = len-1;
            while (b_idx<c_idx && b_idx != len && c_idx!=i-1){
                if(a+nums[b_idx]+nums[c_idx]==0){

                    List<Integer> list = new ArrayList<Integer>();
                    list.add(a);
                    list.add(nums[b_idx]);
                    list.add(nums[c_idx]);
                    nnn.add(list);
                    while (nums[b_idx+1]==nums[b_idx] && b_idx<c_idx && b_idx != len-2)  {
                        b_idx++;
                    }
                    b_idx++;
                    while (nums[c_idx-1]==nums[c_idx] && b_idx<c_idx && c_idx!=i+1) {
                        c_idx--;
                    }
                    c_idx--;
                }
                else if (a+nums[b_idx]+nums[c_idx]<0){
                    // b >>
                    while (nums[b_idx+1]==nums[b_idx] && b_idx<c_idx && b_idx != len-2)  {
                        b_idx++;
                    }
                    b_idx++;
                }
                else {
                    while (nums[c_idx-1]==nums[c_idx] && b_idx<c_idx && c_idx!=i+1) {
                        c_idx--;
                    }
                    c_idx--;
                }
            }
        }
        return nnn;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

}
