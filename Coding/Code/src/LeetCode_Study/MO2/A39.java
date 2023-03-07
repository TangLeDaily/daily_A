package LeetCode_Study.MO2;

public class A39 {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int max = 0;
            int l=0;
            int r=0;
            for (int i=0;i<heights.length;i++){
                l = i-1;
                r = i+1;
                if (heights.length * heights[i]> max){
                    while (l>=0 && heights[l]>=heights[i]){
                        l--;
                    }
                    while (r<heights.length && heights[r]>=heights[i]){
                        r++;
                    }
                    max = Math.max(max,(r-l-1)*heights[i]);
                }
            }
            return max;
        }
    }
}
