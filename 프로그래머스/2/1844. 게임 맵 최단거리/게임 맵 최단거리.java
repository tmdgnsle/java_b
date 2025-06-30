import java.util.*;
class Solution {
    static int answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] v;
    static int w, h;
    public int solution(int[][] maps) {
        
        w = maps[0].length;
        h = maps.length;
        
        answer  = Integer.MAX_VALUE;
        
        v = new boolean[h][w];
        

        
        bfs(maps);
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
    
    static void bfs(int[][] map){
        Queue<int[]> queue = new LinkedList<>();
        v[0][0] = true;
        queue.add(new int[] {0, 0, 1});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int count = current[2];
            
            if(cx == h-1 && cy == w-1){
                    answer = count;
                    break;
                }
            
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                
                
                if(canMove(nx, ny, map)){
                    v[nx][ny] = true;
                    queue.add(new int[] {nx, ny, count+1});
                }
            }
        }
    }
    
    static boolean canMove(int nx, int ny, int[][] map){
        if(nx < 0 || ny < 0 || nx >= h || ny >= w) return false;
        if(v[nx][ny] || map[nx][ny] == 0) return false;
        
        return true;
    }
    
}