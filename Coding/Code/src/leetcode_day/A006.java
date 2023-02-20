package leetcode_day;

public class A006 {
    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len-1;
        while (true){
            int mid_idx = (high-low)/2+low;
//            System.out.println("high  -- "+high);
//            System.out.println("low  -- "+low);
            if (low==high){
                return mid_idx;
            }
//            if (nums[mid_idx]>nums[mid_idx-1] && nums[mid_idx]>nums[mid_idx+1]){
//                return mid_idx;
//            }
            else if (nums[mid_idx]<nums[mid_idx+1]){
                low = mid_idx+1;
            }
            else {
                high = mid_idx;
            }
        }
    }

    public static void main(String[] args) {
        int []nums = {2};
        System.out.println(findPeakElement(nums));
    }
}
