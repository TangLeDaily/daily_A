package leetcode_day;

public class A022 {
    public static void main(String[] args) {
        int n = 4;
        int nums[][] = new int[n][n];
        int i_min=0;
        int j_min=0;
        int i_max=n;
        int j_max =n;
        int i=0;
        int j =0;
        int k=1;
        while (nums[i][j]==0){
            nums[i][j]=k;
            k++;
            System.out.println("this-k: "+k+" i: "+i+" j: "+j);
            if (i==i_min && j==j_min){
                j++;
                j_max--;
                i_max--;
            }
            else if (i==i_min && j<j_max){
                j++;
            }
            else if (j==j_max && i==i_min){
                i++;
                j_min++;
            }
            else if (j==j_max && i<i_max){
                i++;
            }
            else if (j==j_max && i==i_max){
                j--;
                i_min++;
                // j_min = j_min+1;
            }
            else if (i==i_max && j>j_min){
                j--;
            }
            else if (i==i_max && j==j_min) {
                i--;
            }
        }
        for (int a=0;a<n;a++){
            for (int b=0;b<n;b++){
                System.out.println(nums[a][b]);
            }
        }
    }
}
