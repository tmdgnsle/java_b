import java.util.*;
class Solution {
    public int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();
        
        int startRow = -1, startCol = -1;
        int goalRow = -1, goalCol = -1;
        
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(board[i].charAt(j) == 'R'){
                    startRow = i;
                    startCol = j;
                }
                if(board[i].charAt(j) == 'G'){
                    goalRow = i;
                    goalCol = j;
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        
        queue.offer(new int[] {startRow, startCol, 0});
        visited[startRow][startCol] = true;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int moves = current[2];
            
            if(row == goalRow && col == goalCol){
                return moves;
            }
            
            for(int i = 0; i<4; i++){
                int newRow = row;
                int newCol = col;
                
                while(true){
                    
                    int nextRow = newRow + dr[i];
                    int nextCol = newCol + dc[i];
                    
                    if(nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols || board[nextRow].charAt(nextCol) == 'D'){
                        break;
                    }
                    
                    newRow = nextRow;
                    newCol = nextCol;
                }
                if((newRow == row && newCol == col) || visited[newRow][newCol]){
                    continue;
                }
                visited[newRow][newCol] = true;
                queue.offer(new int[] {newRow, newCol, moves+1});
            }
            
        }
        
        return -1;
    }
    
    
}