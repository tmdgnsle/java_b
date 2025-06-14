import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(i != j){
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for(int[] fare: fares){
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            map[from][to] = cost;
            map[to][from] = cost;
        }
        
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                for(int k = 1; k<=n; k++){
                    if(map[k][i] != Integer.MAX_VALUE && map[i][j] != Integer.MAX_VALUE){
                        map[k][j] = Math.min(map[k][j], map[k][i] + map[i][j]);
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        for(int temp = 1; temp<=n; temp++){
            int totalCost = map[s][temp] + map[temp][a] + map[temp][b];
            answer = Math.min(answer, totalCost);
        }
        
        
        return answer;
    }
}