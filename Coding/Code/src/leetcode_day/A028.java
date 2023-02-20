package leetcode_day;

public class A028 {
    public static void main(String[] args) {
        System.out.println(11&(1<<2));
    }
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);

                // (num >> i) & 1 将num的第i为拿出来作为一个一位数字（0或者1)
            }
            if (total % 3 != 0) {
                ans |= (1 << i);

                // num | (1<<i) 改变num的第i位数字，将其赋值为1
                // num & (1<<i) 则代表只保留num的第i位，其他舍去，并且如果第i位为0则return 0
            }
        }
        return ans;
    }
}
