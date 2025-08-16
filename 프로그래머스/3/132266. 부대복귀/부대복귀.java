import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            arr[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i<roads.length; i++){
            arr[roads[i][0]].add(roads[i][1]);
            arr[roads[i][1]].add(roads[i][0]);
        }
        
        // destination에서 모든 노드까지의 거리를 한 번에 계산
        int[] dist = bfs(destination, arr, n);
        
        // sources 각각에 대해 O(1)로 답 구하기
        for(int i = 0; i<sources.length; i++){
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
    
    static int[] bfs(int start, ArrayList<Integer>[] arr, int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);  // 초기값 -1 (도달 불가능)
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next: arr[now]){
                if(dist[next] == -1){  // 아직 방문하지 않은 노드
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }
        
        return dist;
    }
}