package leetcode_day;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class A024 {
    public static int MOD = (int)1e9+7;

    public static void main(String[] args) {
        A024 x = new A024();
        System.out.println(x.numPrimeArrangements(5));
    }







    public int numPrimeArrangements(int n) {
        int zhi_num = 0;
        for (int i=1;i<n+1;i++){
            if (zhi(i)){
                zhi_num++;
            }
        }
        return (int)(jie(zhi_num)*jie(n-zhi_num))%MOD;

    }

    public boolean zhi(int num){
        if (num == 1) return false;
        else for (int i=2;i*i<=num;i++){
            if (num%i == 0) return false;
        }
        return true;
    }

    public int jie(int num){
        int out = 1;
        for (int i=1;i<=num;i++){
            out*=i;
            out%=MOD;
        }
        return out;
    }

    public long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res %= MOD;
        }
        return res;
    }
}
