package LeetCode_Study.MO2;

public class A04 {
    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for (int i=0;i<=31;i++){
                int total=0;
                for (int num:nums){
                    total += (num>>i)&1;
                }
                if (total%3!=0){
                    res |=(1<<i);
                }
            }
            return res;
        }
    }
}
