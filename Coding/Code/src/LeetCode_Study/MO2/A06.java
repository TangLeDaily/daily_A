package LeetCode_Study.MO2;

public class A06 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int l=0;
            int len = numbers.length;
            int r=len-1;
            while (l<r){
                if (numbers[l]+numbers[r]==target){
                    return new int[]{l,r};
                }
                else if (numbers[l]+numbers[r]>target){
                    r--;
                }
                else l++;
            }
            return new int[]{0,0};
        }
    }

    class Solution2 {
        public int[] twoSum(int[] numbers, int target) {
            int len = numbers.length;
            for (int i=0;i<len;i++){
                int l=i+1;
                int r=len-1;
                int mid;
                int tar = target-numbers[i];
                while (l<=r){
                    mid = (r-l)/2+l;
                    if (numbers[mid]==tar){
                        return new int[]{i,mid};
                    }
                    else if (numbers[mid]>tar){
                        r=mid-1;
                    }
                    else l=mid+1;
                }
            }
            return new int[]{0,0};
        }
    }
}
