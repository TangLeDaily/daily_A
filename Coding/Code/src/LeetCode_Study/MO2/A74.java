package LeetCode_Study.MO2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A74 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][2];
            }
                Arrays.sort(intervals,(a,b)->a[0]-b[0]);
                List<int[]> list = new ArrayList<>();
                for (int i=0;i<intervals.length;i++){
                    int L = intervals[i][0];
                    int R = intervals[i][1];
                    if (list.size() == 0|| list.get(list.size()-1)[1]<L){
                        list.add(new int[]{L,R});
                    }else {
                        list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],R);
                    }
                }
                return list.toArray(new int[list.size()][]);
        }
    }
}
