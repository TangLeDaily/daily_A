package leetcode_day;

import java.util.LinkedList;
import java.util.Queue;

public class A015 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int len = grid.length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int num = 0;
        if (grid[len-1][len-1] != 0 || grid[0][0] != 0){
            return -1;
        }
        while (!q.isEmpty()){
            int this_ceng_num = q.size();
            for (int i=0;i<this_ceng_num;i++){
                int[] now = q.poll();
                if (now[0] == len-1 && now[1] == len-1){
                    // 找到了
                    return num+1;
                }
                for (int x =-1;x<=1;x++){
                    for (int y=-1; y<=1; y++){
                        if (x==0 && y ==0){
                            continue;
                        }
                        if (now[0]+x<len && now[0]+x>=0 && now[1]+y<len && now[1]+y>=0){
                            if (grid[now[0]+x][now[1]+y] == 0){
                                q.add(new int[]{now[0]+x,now[1]+y});
                                grid[now[0]+x][now[1]+y] = 1;
                            }
                        }
                    }
                }
            }
            num++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [][]nums = new int[][]{{0,1,1,0,0,0},{0,1,0,1,1,0},{0,1,1,0,1,0},{0,0,0,1,1,0},{1,1,1,1,1,0},{1,1,1,1,1,0}};
        // System.out.println(shortestPathBinaryMatrix(nums));
    }
}
