package leetcode_day;

import java.util.List;

public class A010 {
    public static int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        if (len == 0){
            return 0;
        }
        int bing_num = 1;
        int bing_sum = 1;
        int zu_idx = 0;
        int []bcj = new int[len];
        for (int i=0;i<len; i++){
            bcj[i] = i;
        }
        while (zu_idx<len){
            for (int i=0; i<len; i++){
                if (isConnected[zu_idx][i] == 1){
                    if (bcj[i] != i && bcj[i]!=bcj[zu_idx]){
                        bcj[bcj[i]] = bcj[zu_idx];
                        bcj[i] = bcj[zu_idx];
//                        System.out.println("Zu_idz:"+zu_idx+" i:"+i);
//                        for (int this_c : bcj){
//                            System.out.println(this_c);
//                        }
                        bing_sum--;
                    }
                    else {
                        bcj[i] = bcj[zu_idx];
                    }
                }
            }
            zu_idx++;
        }
        // System.out.println(bing_num-1);
        int sum =0 ;
        for (int i=0;i<len;i++){
            if (bcj[i]==i);
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] isCon = {{1,1,0},{1,1,0},{0,0,1}};
        int[][] isCon2 = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        int temp = findCircleNum(isCon2);
    }
}
