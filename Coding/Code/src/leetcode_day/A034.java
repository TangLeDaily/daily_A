package leetcode_day;

import java.util.HashMap;

public class A034 {
    public static void main(String[] args) {
        System.out.println(new A034().subarraySum(new int[]{3,4,7,2,-3,1,4,2}, 7));
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hmp = new HashMap<>();
        hmp.put(0,1);
        int sum = 0;
        int count = 0;
        for (int i=0;i< nums.length;i++){
            nums[i]+=sum;
            sum=nums[i];
            if (hmp.containsKey(sum-k)){
                count+=hmp.get(sum-k);
            }
            hmp.put(sum,hmp.getOrDefault(sum,0)+1);
        }
        return count;
    }

//    public int subarraySum(int[] nums, int k) {
//        int count = 0, pre = 0;
//        HashMap < Integer, Integer > mp = new HashMap < > ();
//        mp.put(0, 1);
//        for (int i = 0; i < nums.length; i++) {
//            pre += nums[i];
//            if (mp.containsKey(pre - k)) {
//                count += mp.get(pre - k);
//            }
//            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
//        }
//        return count;
//    }

}
