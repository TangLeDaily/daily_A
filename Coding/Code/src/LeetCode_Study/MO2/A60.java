package LeetCode_Study.MO2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class A60 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> hmp = new HashMap<>();
            for (int num:nums){
                hmp.put(num,hmp.getOrDefault(num,0)+1);
            }
            PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
            for (Map.Entry<Integer,Integer> ent:hmp.entrySet()){
                int num = ent.getKey();
                int pc = ent.getValue();
                if (pq.size()==k){
                    if (pq.peek()[1]<pc){
                        pq.poll();
                        pq.offer(new int[]{num,pc});
                    }
                }else {
                    pq.offer(new int[]{num,pc});
                }
            }
            int res[] = new int[k];
            for (int i=0;i<k;i++){
                res[i] = pq.poll()[0];
            }
            return res;
        }
    }
}
