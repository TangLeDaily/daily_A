package LeetCode_ID;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int b = Integer.MAX_VALUE;

        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<arr.length-1;i++){
            if (arr[i+1] - arr[i] <b){
                res.clear();
                b = arr[i+1] - arr[i];
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                res.add(temp);
            }
            else if (arr[i+1]-arr[i]==b){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                res.add(temp);
            }
            else continue;
        }
        return res;
    }
}
