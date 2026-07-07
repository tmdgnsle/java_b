import java.util.*;
class Solution {
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int[][] picture;
    static int m;
    static int n;
    static boolean[][] v;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        this.m = m;
        this.n = n;
        this.picture = picture;

        int[] answer = new int[2];
        
        v = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(picture[i][j] != 0 && !v[i][j]){
                    bfs(i, j);
                    numberOfArea++;
                }
            }
        }
        
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        v[x][y] = true;
        int area = 1;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if(v[nx][ny] || picture[cx][cy] != picture[nx][ny]) continue;
                
                v[nx][ny] = true;
                q.add(new int[] {nx, ny});
                area++;
            }
        }
        
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
    }
}