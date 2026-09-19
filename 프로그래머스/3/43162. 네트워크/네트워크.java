import java.util.*;
class Solution {
    static int answer = 0;
    static int n;
    static ArrayList<Integer>[] nets;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        this.n = n;
        nets = new ArrayList[n];
        for(int i = 0; i<n; i++){
            nets[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(computers[i][j] == 1){
                    nets[i].add(j);
                }
            }
        }
        
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(int num){
        visited[num] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        
        while(!queue.isEmpty()){
            int c = queue.poll();
            for(int next: nets[c]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}