package LeetCode_Study.MO2;

public class A73 {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1;
            int right = 0;
            for (int pie:piles){
                right = Math.max(right,pie);
            }
            int res = right;
            while (left<right){
                int mid = (right-left)/2+left;
                long time = getTime(piles, mid);
                if (time<=h){
                    res=mid;
                    right = mid;
                }else {
                    left = mid+1;
                }
            }
            return res;
        }

        public long getTime(int[] piles, int speed){
            long time = 0;
            for (int pie:piles){
                time+=(pie+speed-1)/speed;
            }
            return time;
        }
    }
}
