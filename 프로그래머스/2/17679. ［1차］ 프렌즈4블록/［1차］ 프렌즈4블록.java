import java.util.*;
class Solution {
    static int answer;
    static char[][] b;
    public int solution(int m, int n, String[] board) {
        answer = 0;
        
        b = new char[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                b[i][j] = board[i].charAt(j);
            }
        }
        
        simulate(m, n);
        
        return answer;
    }
    
    static void simulate(int m, int n){
        while(true){
            int count = 0;
            char[][] newB = new char[m][n];
            boolean[][] destroy = new boolean[m][n];
            
            for(int i = 0; i<m-1; i++){
                for(int j = 0; j<n-1; j++){
                    if(isValid(i, j)){
                        destroy[i][j] = true;
                        destroy[i][j+1] = true;
                        destroy[i+1][j] = true;
                        destroy[i+1][j+1] = true;
                    }
                }
            }
            
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    if(destroy[i][j]){
                        newB[i][j] = 'a';
                        count++;
                    }else {
                        newB[i][j] = b[i][j];
                    }
                }
            }
            
            if(count == 0) break;
            answer += count;
            
            for(int j = 0; j<n; j++){
                for(int i = m-1; i>=0; i--){
                   int idx = i;
                    if(newB[i][j] == 'a'){
                        while(idx >= 0 && newB[idx][j] == 'a'){
                            idx--;
                        }
                        if(idx < 0) continue;
                        char temp = newB[idx][j];
                        newB[idx][j] = 'a';
                        newB[i][j] = temp;
                    }
                    
                }
            }
            b = newB;
            
        }
    }
    
    static boolean isValid(int x, int y){
        return b[x][y] != 'a' && b[x][y] == b[x][y+1] && b[x][y] == b[x+1][y] && b[x][y] == b[x+1][y+1];
    }
}