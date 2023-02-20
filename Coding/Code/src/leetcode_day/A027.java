package leetcode_day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A027 {
    public static void main(String[] args) {

        System.out.println(new A027().countBits(5));
    }
    public int[] countBits(int n) {
        int[] sum = new int[n+1];
        for (int i=0;i<=n;i++){
            String now_two = tentotwo(i);
            int now_num=0;
            for (int j=0;j<now_two.length();j++){
                if (now_two.charAt(j)=='1') now_num++;
            }
            sum[i] = now_num;
        }
        return sum;
    }
    public long twototen(String num){
        long res = 0;
        for (int i=0;i<num.length();i++){
            res*=2;
            res+=num.charAt(i)-'0';
        }
        return res;
    }

    public String tentotwo(int num){
        if (num == 0) return "0";
        List<Integer> yu = new ArrayList<>();
        while (num!=0){
            yu.add(num%2);
            num/=2;
        }
        Collections.reverse(yu);
        String re = "";
        for (int i=0;i<yu.size();i++){
            re = re+String.valueOf(yu.get(i));
        }
        return re;
    }
}
