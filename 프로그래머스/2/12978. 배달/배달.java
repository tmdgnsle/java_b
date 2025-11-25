import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int to;
        int cost;
        
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    
    static List<List<Node>> graph;
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList<>();
        for(int i = 0; i<=N; i++){
            graph.add(new ArrayList<Node>());
        }
        
        for(int[] r: road){
            int a = r[0];
            int b = r[1];
            int c = r[2];
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.cost > dist[cur.to]) continue;
            
            for(Node next: graph.get(cur.to)){
                int newCost = cur.cost + next.cost;
                
                if(newCost < dist[next.to]){
                    dist[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 1; i<=N; i++){
            if(dist[i] <= K) answer++;
        }

        return answer;
    }
}