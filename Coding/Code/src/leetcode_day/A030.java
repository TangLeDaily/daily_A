package leetcode_day;

public class A030 {
    public static void main(String[] args) {
        int []n = new A030().twoSum(new int[]{1,2,4,6,10}, 8);
        System.out.println(n[0]);
        System.out.println(n[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int left = 0;
        int right = len-1;
        while (left<=right){
            if (numbers[left]+numbers[right] == target) return new int[]{left, right};
            else if (numbers[left]+numbers[right] < target) left++;
            else right--;
        }
        return new int[]{};
    }
}
