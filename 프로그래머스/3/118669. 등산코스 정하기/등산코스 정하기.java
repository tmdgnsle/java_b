import java.util.*;
class Solution {
    
    static class Node{
        int to;
        int time;
        
        Node(int to, int time){
            this.to = to;
            this.time = time;
        }
    }
    
    static int n;
    static ArrayList<Node>[] arr;
    static HashSet<Integer> summit;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        this.n = n;
        arr = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int[] path: paths){
            int p1 = path[0];
            int p2 = path[1];
            int time = path[2];
            arr[p1].add(new Node(p2, time));
            arr[p2].add(new Node(p1, time));
        }
        summit = new HashSet<>();
        for(int s: summits){
            summit.add(s);
        }
        
        int[] intensity = dijkstra(gates);
        
        Arrays.sort(summits);
        
        int minS = 0;
        int minI = Integer.MAX_VALUE;
        
        for(int s: summits){
            if(intensity[s] < minI){
                minI = intensity[s];
                minS = s;
            }
        }
        
        
        
        return new int[] {minS, minI};
    }
    
    static int[] dijkstra(int[] gates){
        int[] intensity = new int[n+1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        
        for(int gate: gates){
            intensity[gate] = 0;
            pq.offer(new Node(gate, 0));
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.to;
            int nowIntensity = cur.time;
            
            if(intensity[now] < nowIntensity){
                continue;
            }
            
            if(summit.contains(now)) continue;
            
            for(Node next: arr[now]){
                int nextIntensity = Math.max(nowIntensity, next.time);
                
                if(intensity[next.to] > nextIntensity){
                    intensity[next.to] = nextIntensity;
                    pq.offer(new Node(next.to, nextIntensity));
                }
            }
        }
        return intensity;
    }
}