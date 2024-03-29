package leetcode_day;

import java.util.LinkedList;
import java.util.Queue;

public class A016 {
    public void solve(char[][] board) {
        for (int i=0;i<board.length;i++){
            dfs(board,i,0);
            dfs(board,i,board[0].length-1);
        }
        for (int j=0;j<board[0].length;j++){
            dfs(board,0,j);
            dfs(board,board.length-1,j);
        }
        for (int i=0;i<board.length;i++)
            for (int j=0;j<board[0].length;j++){
                if (board[i][j] == 'Z') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
    }
    public void dfs(char[][] board, int i, int j){
        if (i<0 || j<0 || i>board.length || j>board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = 'Z';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
        return;
    }
}
