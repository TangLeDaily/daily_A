package LeetCode_Study.MO2;

public class A69 {
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int n = arr.length;
            int left = 0, right = n-2, res = n;
            while (left<=right){
                int mid = (right-left)/2+left;
                if (arr[mid]>arr[mid+1]){
                    res = mid;
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
            return res;
        }
    }
}
