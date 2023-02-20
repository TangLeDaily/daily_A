package leetcode_day;

public class A004 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int a_len = matrix.length;
        int b_len = matrix[0].length;
        int left = 0;
        int right = matrix.length-1;
        while (true){
            int mid_idx = (right-left+1)/2+left;
            if (target == matrix[mid_idx][0]){
                return true;
            }
            else if (right == left){
                int mini_left = 0;
                int mini_right = matrix[0].length-1;
                while (true){
                    int mini_mid_idx = (mini_right - mini_left) /2 + mini_left;
                    System.out.println("Mini_left"+mini_left);
                    System.out.println("mini_right"+mini_right);
                    if (target == matrix[right][mini_mid_idx]){
                        return true;
                    }
                    else if(mini_left == mini_right){
                        return false;
                    }
                    else if (target>matrix[right][mini_mid_idx]){
                        mini_left = mini_mid_idx+1;
                    }
                    else{
                        mini_right = mini_mid_idx;
                    }
                }
            }
            else if (target>matrix[mid_idx][0]){
                left = mid_idx;
            }
            else{
                right = mid_idx-1;
            }
        }
        // return false;
    }

    public static void main(String[] args) {
        int [][]ma = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        if (searchMatrix(ma, 79)){
            System.out.println("True");
        }
        else System.out.println("False");
    }
}

