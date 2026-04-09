import java.util.*;
class Solution {
    
    static boolean[][] redV;
    static boolean[][] blueV;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int n, m;
    
    static int redTargetX, redTargetY;
    static int blueTargetX, blueTargetY;
    static int answer = 0;
    static int[][] maze;
    
    public int solution(int[][] maze) {
        this.maze = maze;
        int redX = 0;
        int redY = 0;
        int blueX = 0;
        int blueY = 0;
        
        n = maze.length;
        m = maze[0].length;
        
        redV = new boolean[n][m];
        blueV = new boolean[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(maze[i][j] == 1){
                    redX = i;
                    redY = j;
                }
                if(maze[i][j] == 2){
                    blueX = i;
                    blueY = j;
                }
                if(maze[i][j] == 3){
                    redTargetX = i;
                    redTargetY = j;
                }
                if(maze[i][j] == 4){
                    blueTargetX = i;
                    blueTargetY = j;
                }
            }
        }
        
        redV[redX][redY] = true;
        blueV[blueX][blueY] = true;
        
        dfs(redX, redY, blueX, blueY, 0);
        
        
        
        return answer;
    }
    
    
    static void dfs(int redX, int redY, int blueX, int blueY, int depth){
        if(redX == redTargetX && redY == redTargetY && blueX == blueTargetX && blueY == blueTargetY){
            if(answer != 0){
                answer = Math.min(answer, depth);
            }else{
                answer = depth;
            }
            return;
        }
        
        if(answer != 0 && answer <= depth) return;
        
        List<int[]> nextRed = new ArrayList<>();
        List<int[]> nextBlue = new ArrayList<>();
        
        boolean redTarget = false;
        boolean blueTarget = false;
        
        if(redX == redTargetX && redY == redTargetY) {
            redTarget = true;
            nextRed.add(new int[] {redX, redY});
        }
        if(blueX == blueTargetX && blueY == blueTargetY) {
            blueTarget = true;
            nextBlue.add(new int[] {blueX, blueY});
        }
        
        for(int i = 0; i<4; i++){
            int rnx = redX + dx[i];
            int rny = redY + dy[i];
            int bnx = blueX + dx[i];
            int bny = blueY + dy[i];
            if(!redTarget && rnx >= 0 && rnx < n && rny >= 0 && rny < m && maze[rnx][rny] != 5 && !redV[rnx][rny]) nextRed.add(new int[] {rnx, rny});
            if(!blueTarget && bnx >= 0 && bnx < n && bny >= 0 && bny < m && maze[bnx][bny] != 5 && !blueV[bnx][bny]) nextBlue.add(new int[] {bnx, bny});
        }
        
        for(int[] nr: nextRed){
            for(int[] nb: nextBlue){
                int rnx = nr[0];
                int rny = nr[1];
                int bnx = nb[0];
                int bny = nb[1];
                if(rnx == bnx && rny == bny) continue;
                if(rnx == blueX && rny == blueY && bnx == redX && bny == redY) continue;
                
                redV[rnx][rny] = true;
                blueV[bnx][bny] = true;
                dfs(rnx, rny, bnx, bny, depth + 1);
                redV[rnx][rny] = false;
                blueV[bnx][bny] = false;
                
            }
        }
        
        
    }
}