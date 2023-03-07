package LeetCode_Study.MO2;

import java.util.*;

public class A75 {
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            HashMap<Integer, Integer> hmp = new HashMap<>();
            for (int num:arr1){
                hmp.put(num,hmp.getOrDefault(num,0)+1);
            }
            List<Integer> list = new ArrayList<>();
            for (int num:arr2){
                int sum = hmp.get(num);
                hmp.remove(num);
                for (int i=0;i<sum;i++){
                    list.add(num);
                }
            }
            List<Integer> list2 = new ArrayList<>();
            for (Map.Entry<Integer,Integer> ent:hmp.entrySet()){
                for (int i=0;i<ent.getValue();i++){
                    list2.add(ent.getKey());
                }
            }
            Collections.sort(list2);
            for (int num:list2){
                list.add(num);
            }
            int[] res = new int[arr1.length];
            for (int i=0;i<list.size();i++){
                res[i]=list.get(i);
            }
            return res;
        }
    }
}
