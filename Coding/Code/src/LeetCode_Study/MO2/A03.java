package LeetCode_Study.MO2;

public class A03 {
    class Solution {
        public int[] countBits(int n) {
            int []res = new int[n+1];
            for (int i=0;i<=n;i++){
                res[i] = getone(i);
            }
            return res;
        }
        public int getone(int num){
            int res = 0;
            while (num!=0){
                num&=num-1;
                res++;
            }
            return res;
        }

        public int[] countBits1(int n) {
            int []res = new int[n+1];
            int highBits = 0;
            for (int i=1;i<=n;i++){
                if ((i&(i-1)) == 0) highBits=i;
                res[i] = res[i-highBits]+1;
            }
            return res;
        }

        public int[] countBits2(int n) {
            int []res = new int[n+1];
            int highBits = 0;
            for (int i=1;i<=n;i++){
                res[i] = res[i/2]+i&1;
            }
            return res;
        }
    }
}
