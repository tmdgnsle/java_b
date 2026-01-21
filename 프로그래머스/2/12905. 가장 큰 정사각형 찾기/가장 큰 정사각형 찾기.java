import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        
        int r = board.length;
        int c = board[0].length;
        int maxLen = 0;
        
        for(int i = 0; i<r; i++) maxLen = Math.max(maxLen, board[i][0]);
        for(int i = 0; i<c; i++) maxLen = Math.max(maxLen, board[0][i]);
        
        for(int i = 1; i<r; i++){
            for(int j = 1; j<c; j++){
                if(board[i][j] == 1){
                    board[i][j] = Math.min(board[i-1][j], Math.min(board[i][j-1], board[i-1][j-1])) + 1;
                    maxLen = Math.max(board[i][j], maxLen);
                }
            }
        }

        return maxLen * maxLen;
    }
}