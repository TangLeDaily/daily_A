package leetcode_day;

import java.lang.reflect.Method;
import java.util.HashMap;

public class A035 {
    public static void main(String[] args) {
        System.out.println(new A035().findMaxLength(new int[]{1,0,1,1,0,1,0,0,0,1}));
    }

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hmp = new HashMap<>();
        hmp.put(0,-1);
        int sum = 0;
        int max_len = 0;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i]>0?nums[i]:-1;
            if (hmp.containsKey(sum)){
                int len = i-hmp.get(sum);
                max_len= Math.max(max_len, len);
            }
            else hmp.put(sum,i);
        }
        return max_len;
    }
}
