package LeetCode_Study.MO2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class A61 {
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->nums1[a[0]]+nums2[a[1]]-nums1[b[0]]-nums2[b[1]]);
            List<List<Integer>> res = new ArrayList<>();
            int m = nums1.length;
            int n= nums2.length;
            for (int i=0;i<Math.min(k,m);i++){
                pq.offer(new int[]{i,0});
            }
            for (;k>0&&!pq.isEmpty();k--){
                int []now = pq.poll();
                List<Integer> list = new ArrayList<>();
                list.add(nums1[now[0]]);
                list.add(nums2[now[1]]);
                res.add(list);
                if (now[1]+1<n){
                    pq.offer(new int[]{now[0],now[1]+1});
                }
            }
            return res;
        }
    }
}
