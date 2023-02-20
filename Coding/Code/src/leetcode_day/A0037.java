package leetcode_day;

public class A0037 {

    int[][] matrix_sum;

    public void NumMatrix(int[][] matrix) {
        int sum=0;
        int x_len = matrix.length;
        int y_len = matrix[0].length;
        matrix_sum = new int[x_len][y_len];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                sum+=matrix[i][j];
                matrix_sum[i][j] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (col1!=0) col1--;
        else if (row1!=0) {row1--;col1=matrix_sum[0].length-1;}
        else return matrix_sum[row2][col2];
        return matrix_sum[row2][col2]-matrix_sum[row1][col1];
    }
}
