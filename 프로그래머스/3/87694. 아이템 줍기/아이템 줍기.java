import java.util.*;

class Solution {
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 1. 좌표 2배 확대 (테두리만 걸을 수 있도록 하기 위해)
        board = new int[101][101]; // 원래 50x50을 100x100으로
        
        // 2. 사각형들을 board에 그리기
        for(int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2; 
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            // 사각형 내부를 2로, 테두리를 1로 표시
            for(int i = x1; i <= x2; i++) {
                for(int j = y1; j <= y2; j++) {
                    if(i == x1 || i == x2 || j == y1 || j == y2) {
                        // 테두리인 경우, 이미 내부(2)가 아니라면 테두리(1)로 설정
                        if(board[i][j] != 2) {
                            board[i][j] = 1;
                        }
                    } else {
                        // 내부는 2로 설정 (걸을 수 없는 영역)
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        // 3. 내부에 둘러싸인 테두리는 걸을 수 없으므로 제거
        for(int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2; 
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            // 테두리 중에서 내부에 있는 부분을 2로 변경
            for(int i = x1 + 1; i < x2; i++) {
                for(int j = y1 + 1; j < y2; j++) {
                    board[i][j] = 2;
                }
            }
        }
        
        // 4. BFS로 최단거리 찾기
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    static int bfs(int startX, int startY, int targetX, int targetY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            // 목표 지점에 도착
            if(x == targetX && y == targetY) {
                return dist / 2; // 2배 확대했으므로 2로 나누기
            }
            
            // 4방향 탐색
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위 체크
                if(nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                
                // 테두리(1)이고 방문하지 않은 곳만 이동 가능
                if(board[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        
        return -1; // 도달 불가능 (실제로는 발생하지 않음)
    }
}