import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        int[][] snail = new int[n+1][n+1];
        int num = 1;
        int max = 0;
        for(int i = 1; i<=n; i++){
            max += i;
        }
        int x = 1;
        int y = 1;
        int d = 0;
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        while(num <= max){
            snail[x][y] = num;
            boolean changeDirection = false;
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(d == 0){
             if(nx > n || snail[nx][ny] != 0){
                 changeDirection = true;
             }   
            }else if(d == 1){
                if(ny > n || snail[nx][ny] != 0){
                    changeDirection = true;
                }
            }else if(d == 2){
                if(snail[nx][ny] != 0){
                    changeDirection = true;
                }
            }
            
            if(changeDirection){
                d = (d+1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            
            x = nx;
            y = ny;
            num++;
        }
        
        
        int[] answer = new int[max];
        int idx = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=i; j++){
                answer[idx++] = snail[i][j];
            }
        }
        return answer;
    }
}