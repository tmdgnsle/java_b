import java.util.*;
class Solution {
    static ArrayList<Integer>[] arr;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        arr = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<edge.length; i++){
            int p1 = edge[i][0];
            int p2 = edge[i][1];
            arr[p1].add(p2);
            arr[p2].add(p1);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int d = cur[1];
            
            if(d > dist[node]) continue;
            
            for(int next: arr[node]){
                int newDist = d+1;
                if(newDist < dist[next]){
                    dist[next] = newDist;
                    pq.offer(new int[] {next, newDist});
                }
            }
        }
        
        int maxDist = 0;
        for(int i = 2; i<=n; i++){
            maxDist = Math.max(maxDist, dist[i]);
        }
        
        int count = 0;
        
        for(int i = 2; i<=n; i++){
            if(dist[i] == maxDist){
                answer ++;
            }
        }
        
        return answer;
    }
}