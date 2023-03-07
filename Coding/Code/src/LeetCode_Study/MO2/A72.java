package LeetCode_Study.MO2;

public class A72 {
    class Solution {
        public int mySqrt(int x) {
            if (x==0) return 0;
            int res = (int)Math.exp(0.5*Math.log(x));
            return (long)(res+1)*(res+1)<=x?res+1:res;
        }
    }

    class Solution2 {
        public int mySqrt(int x) {
            if (x==0) return 0;
            int l = 0, r = x, ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if ((long) mid * mid <= x) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return ans;
        }
    }

}
