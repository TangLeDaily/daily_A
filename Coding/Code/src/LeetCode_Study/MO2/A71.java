package LeetCode_Study.MO2;

import com.sun.org.apache.bcel.internal.generic.LREM;

import java.util.Random;

public class A71 {
    class Solution {
        int pre[];
        int total;
        public Solution(int[] w) {
            pre = new int[w.length];
            pre[0]=w[0];
            for (int i=1;i<w.length;i++){
                pre[i] = pre[i-1]+w[i];
            }
            total = pre[w.length-1];
        }

        public int pickIndex() {
            int x = (int)(Math.random()*total)+1;
            return bb(x);
        }

        public int bb(int x){
            int left = 0, right = pre.length-1;
            while (left<right){
                int mid = (right- left)/2+left;
                if (pre[mid]<x){
                    left = mid+1;
                }else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
