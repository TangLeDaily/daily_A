package LeetCode_Study.MO2;

public class A40 {
    class Solution {
        public int maximalRectangle(String[] matrix) {
            int m = matrix.length;
            if (m==0) return 0;
            int n = matrix[0].length();
            int [][]lj = new int[m][n+1];
            for (int i=0;i<m;i++){
                for (int j=1;j<=n;j++){
                    int num = matrix[i].charAt(j-1)-'0';
                    lj[i][j] = num==0?num:num+lj[i][j-1];
                }
            }
            int res = 0;
            for (int i=0;i<m;i++) {
                for (int j = 1; j <= n; j++) {
                    int num = matrix[i].charAt(j-1)-'0';
                    if (num==0) continue;
                    int width = lj[i][j];
                    int mian = width;
                    for (int k = i-1;k>=0;k--){
                        width = Math.min(width, lj[k][j]);
                        mian = Math.max(mian,width*(i-k+1));
                    }
                    res = Math.max(res, mian);

                }
            }
            return res;

        }
    }
}
