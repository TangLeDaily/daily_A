package leetcode_day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class A026 {

    public static void main(String[] args) {
        System.out.println(new A026().diffWaysToCompute("2*3-4*5"));
    }

    HashMap<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if (expression.length()==0) return new ArrayList<>();
        if (map.containsKey(expression)) return map.get(expression);
        List<Integer> now_res = new ArrayList<>();
        int num = 0;

        boolean nofu = true;
        for (int i=0;i<expression.length();i++){
            if (fu(expression.charAt(i))){
                nofu = false;
                List<Integer> zuo_res = diffWaysToCompute(expression.substring(0,i));
                List<Integer> you_res = diffWaysToCompute(expression.substring(i+1));
                for (int j=0;j<zuo_res.size();j++)
                    for (int k=0;k<you_res.size();k++)
                        now_res.add(jisuan(zuo_res.get(j),expression.charAt(i),you_res.get(k)));
            }
            if (nofu) num = num*10 + expression.charAt(i) - '0';
        }
        if (nofu) now_res.add(num);
        map.put(expression, now_res);
        return now_res;
    }
    public boolean fu(char tr){
        if (tr == '+' || tr == '-' ||tr == '*') return true;
        else return false;
    }
    public int jisuan(int a, char b, int c){
        switch (b){
            case '+':return a+c;
            case '-':return a-c;
            case '*':return a*c;
            default:return-99999;
        }
    }
}
