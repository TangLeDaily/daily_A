package leetcode_day;

import java.util.ArrayList;
import java.util.Arrays;

public class A021 {
    public static void main(String[] args) {
        String num = "9876543";
        ArrayList<Integer> nums = new ArrayList<Integer>(){
            {
                for(int j=0;j<num.length();j++)
                    add(num.charAt(j)-'0');
            }
        };
        int del = 4;
        for (int i=0;i<del;i++){
            for (int j=0;j<nums.size();j++){
                if (j!=nums.size()-1)
                    if (nums.get(j)<nums.get(j+1)) {
                        nums.remove(j);
                        break;
                    }
                    else {
                        continue;
                    }
                else {
                    nums.remove(j);
                    break;
                    }
            }
        }
        for (Integer this_int:nums)
            System.out.println(this_int);
    }
}
