package leetcode_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A019 {
    public List<List<Integer>> fi = new ArrayList<List<Integer>>();
    public List<Integer> now= new ArrayList<Integer>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return fi;
    }

    public void dfs(boolean use_last, int idx, int []nums){
        if (idx == nums.length){
            fi.add(new ArrayList<Integer>(now));
            return;
        }
        dfs(false, idx+1, nums);
        if (!use_last && nums[idx] == nums[idx-1]){
            return;
        }
        now.add(nums[idx]);
        dfs(true,idx+1,nums);
        now.remove(now.size()-1);
    }
}
