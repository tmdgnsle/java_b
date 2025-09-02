import java.util.*;

class Solution {
    public int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();
        
        // 시작점과 목표점 찾기
        int startRow = -1, startCol = -1;
        int goalRow = -1, goalCol = -1;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i].charAt(j) == 'R') {
                    startRow = i;
                    startCol = j;
                } else if (board[i].charAt(j) == 'G') {
                    goalRow = i;
                    goalCol = j;
                }
            }
        }
        
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        
        queue.offer(new int[]{startRow, startCol, 0}); // {행, 열, 이동횟수}
        visited[startRow][startCol] = true;
        
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int moves = current[2];
            
            
            if (row == goalRow && col == goalCol) {
                return moves;
            }
            
            
            for (int i = 0; i < 4; i++) {
                int newRow = row;
                int newCol = col;
                
                // 장애물이나 벽에 부딪힐 때까지 계속 이동
                while (true) {
                    int nextRow = newRow + dr[i];
                    int nextCol = newCol + dc[i];
                    
                    // 경계를 벗어나거나 장애물에 부딪히면 멈춤
                    if (nextRow < 0 || nextRow >= rows || 
                        nextCol < 0 || nextCol >= cols || 
                        board[nextRow].charAt(nextCol) == 'D') {
                        break;
                    }
                    
                    newRow = nextRow;
                    newCol = nextCol;
                }
                
                // 이동 후 위치가 현재 위치와 같거나 이미 방문했다면 skip
                if ((newRow == row && newCol == col) || visited[newRow][newCol]) {
                    continue;
                }
                
                // 마지막 위치만 방문 배열 추가
                visited[newRow][newCol] = true;
                queue.offer(new int[]{newRow, newCol, moves + 1});
            }
        }
        
        // 목표점에 도달할 수 없는 경우
        return -1;
    }
}