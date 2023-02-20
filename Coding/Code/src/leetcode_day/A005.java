package leetcode_day;

public class A005 {
    public static int findMin(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len-1;
        int mini = 0;
        while (true){
            int mid_idx = (high-low)/2 + low;
            mini = nums[mid_idx];
//            System.out.println("high  -- "+high);
//            System.out.println("low  -- "+low);
            if (high == low){
                return mini;
            }
            else if (nums[high] > nums[mid_idx]){
                // 右边是正常数组，所以取左边
                high = mid_idx;
            }
            else {
                // 右边异常
                low = mid_idx+1;
            }
        }
    }

    public static void main(String[] args) {
        int []nums = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }
}
