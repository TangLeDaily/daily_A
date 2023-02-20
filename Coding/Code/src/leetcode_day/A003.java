package leetcode_day;

import java.util.Arrays;

public class A003 {

//    public int[] searchRange(int[] nums, int target) {
//
//    }

    public static int[] searchRanges(int[] nums, int target) {
        int mid_idx = nums.length/2-1;
        int mid = nums[mid_idx];
        if(mid == target){
            int right;
            int left;
            if (mid_idx==0){
                right = mid_idx;
            }
            else{
                int []right_nums = Arrays.copyOfRange(nums, 0, mid_idx-1);
                right = findright(right_nums, target, mid_idx);
            }
            if(mid_idx==nums.length-1){
                left = mid_idx;
            }
            else {
                int []left_nums = Arrays.copyOfRange(nums, mid_idx+1, nums.length-1);
                left = findleft(left_nums, target, mid_idx);
            }

            return new int[]{right, left};
        }
        else if (mid > target){
            int []next_nums = Arrays.copyOfRange(nums, 0, mid_idx-1);
            return searchRanges(next_nums, target);
        }
        else {

            int []next_nums = Arrays.copyOfRange(nums, mid_idx+1, nums.length-1);
            return searchRanges(next_nums, target);
        }
    }

    public static int findright(int[] nums, int target, int last_idx) {
        if(nums.length==1 && nums[0] != target){
            return last_idx;
        }
        int mid_idx = nums.length/2-1;
        int mid = nums[mid_idx];

        if(mid == target){
            int []right_nums = Arrays.copyOfRange(nums, 0, mid_idx-1);
            last_idx = mid_idx;
            return findright(right_nums, target, last_idx);
        }
        else if (mid > target){
            int []next_nums = Arrays.copyOfRange(nums, 0, mid_idx-1);
            return findright(next_nums, target, last_idx);
        }
        else {

            int []next_nums = Arrays.copyOfRange(nums, mid_idx+1, nums.length-1);
            return findright(next_nums, target, last_idx);
        }
    }

    public static int findleft(int[] nums, int target, int last_idx) {
        if(nums.length==1 && nums[0] != target){
            return last_idx;
        }
        int mid_idx = nums.length/2-1;
        int mid = nums[mid_idx];

        if(mid == target){
            int []left_nums = Arrays.copyOfRange(nums, mid_idx+1, nums.length-1);
            last_idx = mid_idx;
            return findleft(left_nums, target, last_idx);
        }
        else if (mid > target){
            int []next_nums = Arrays.copyOfRange(nums, 0, mid_idx-1);
            return findleft(next_nums, target, last_idx);
        }
        else {
            int []next_nums = Arrays.copyOfRange(nums, mid_idx+1, nums.length-1);
            return findleft(next_nums, target, last_idx);
        }
    }

    public static void main(String[] args) {
        int nums[] = {5,7,7,8,8,10};
        System.out.println(searchRanges(nums, 8));
    }

}

