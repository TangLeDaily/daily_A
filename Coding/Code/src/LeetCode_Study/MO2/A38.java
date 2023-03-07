package LeetCode_Study.MO2;

import java.util.Deque;
import java.util.LinkedList;

public class A38 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> stack = new LinkedList<>();
            int length = temperatures.length;
            int []ans = new int[length];
            for (int i=0;i<length;i++){
                int tm = temperatures[i];
                while (!stack.isEmpty() && tm>temperatures[stack.peek()]){
                    int p = stack.pop();
                    ans[p] = i-p;
                }
                stack.push(i);
            }
            return ans;
        }
    }
}
