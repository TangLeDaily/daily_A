package LeetCode_Study.MO2;

import java.util.Deque;
import java.util.LinkedList;

public class A36 {
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<>();
            int n = tokens.length;
            for (int i=0;i<n;i++){
                String str = tokens[i];
                if (isNumber(str)){
                    stack.push(Integer.parseInt(str));
                }
                else {
                    int num2= stack.pop();
                    int num1 = stack.pop();
                    switch (str) {
                        case "+":
                            stack.push(num1 + num2);
                            break;
                        case "-":
                            stack.push(num1 - num2);
                            break;
                        case "*":
                            stack.push(num1 * num2);
                            break;
                        case "/":
                            stack.push(num1 / num2);
                            break;
                        default:
                    }
                }
            }
            return stack.pop();
        }
        public boolean isNumber(String token) {
            return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
        }
    }
}
