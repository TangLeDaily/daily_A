package LeetCode_Study.MO2;

public class A01 {
    class Solution {
        public int divide(int a, int b) {
            if (a==Integer.MIN_VALUE && b==-1)
                return Integer.MAX_VALUE;
            int sign = (a>0)^(b>0)?-1:1;
            a = Math.abs(a);
            b = Math.abs(b);
            int res = 0;
            for (int i=31;i>=0;i--){
                if ((a>>>i)-b>=0){
                    a-=(b<<i);
                    if (res>Integer.MAX_VALUE-(1<<i))
                        return Integer.MIN_VALUE;
                    res+=(1<<i);
                }

            }
            return sign>0?res:-res;
        }
    }
    public static void main(String[] args) {

    }
}
