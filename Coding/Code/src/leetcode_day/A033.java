package leetcode_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A033 {
    public static void main(String[] args) {
        System.out.println(new A033().nextGreaterElement(12));
    }
    public int nextGreaterElement(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        if (nums.length==1) return -1;
        int i=nums.length-1;
        List<Character> numlist = new ArrayList<>();
        while (i>0){
            numlist.add(nums[i]);
            if (nums[i]>nums[i-1]){
                for (int j=0;j<numlist.size();j++){
                    if (numlist.get(j) > nums[i-1]){
                        char temp = numlist.get(j);
                        numlist.set(j,nums[i-1]);
                        nums[i-1] = temp;
                        for (int k=i,v=0;k<nums.length;k++,v++){
                            nums[k] = numlist.get(v);
                        }
                        long ans = Long.parseLong(new String(nums));
                        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
                    }
                }
            }
            i--;
        }
        return -1;
    }
}
