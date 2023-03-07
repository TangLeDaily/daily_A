package LeetCode_Study.MO2;

import java.util.HashMap;
import java.util.TreeSet;

public class A57 {
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n = nums.length;
            TreeSet<Long> ts = new TreeSet<>();
            for (int i=0;i<n;i++){
                Long select = ts.ceiling((long)nums[i]-(long)t);
                if (select!=null && select<= (long)nums[i]+(long)t){
                    return true;
                }
                ts.add((long)nums[i]);
                if (i>=k){
                    ts.remove((long)nums[i-k]);
                }
            }
            return false;

        }
    }

    class Solution2 {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n= nums.length;
            HashMap<Long, Long> hmp = new HashMap<>();
            long tt = (long)t+1;
            for (int i=0;i<n;i++){
                long idx = getIdx(nums[i], tt);
                if (hmp.containsKey(idx)){
                    return true;
                }
                if (hmp.containsKey(idx - 1) && Math.abs(nums[i] - hmp.get(idx - 1)) < tt) {
                    return true;
                }
                if (hmp.containsKey(idx + 1) && Math.abs(nums[i] - hmp.get(idx + 1)) < tt) {
                    return true;
                }
                hmp.put(idx, (long) nums[i]);
                if (i >= k) {
                    hmp.remove(getIdx(nums[i - k], tt));
                }
            }
            return false;
        }

        public long getIdx(int num, long tt){
            if (num>=0){
                return num/tt;
            }
            return (num+1)/tt-1;
        }
    }
}
