import java.util.*;
class Solution {
    
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] wire: wires){
            int a = wire[0];
            int b = wire[1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for(int[] wire: wires){
            int a = wire[0];
            int b = wire[1];
            
            visited = new boolean[n+1];
            int count = dfs(a, a, b);
            int other = n - count;
            
            answer = Math.min(answer, Math.abs(count - other));
        }
        
        return answer;
    }
    
    
    static int dfs(int current, int cutA, int cutB){
        visited[current] = true;
        
        int count = 1;
        
        
        for(int next: graph[current]){
            if((current == cutA && next == cutB) || (current == cutB && next == cutA)){
                continue;
            }
            
            if(!visited[next]){
                count += dfs(next, cutA, cutB);
            }
        }
        
        return count;
    }
}