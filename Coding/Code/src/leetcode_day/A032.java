package leetcode_day;

public class A032 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int sum=0;

        for (int i=0;i<nums.length;i++){
            int temp=1;
            for (int j=i;j<nums.length;j++){
                temp*=nums[j];
                if (temp<k) sum++;
                else break;
            }
        }
        return sum;
    }
}
