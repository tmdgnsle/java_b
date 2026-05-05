import java.util.*;
class Solution {
    
    public long solution(int[] a, int[][] edges) {
        int n = a.length;
        long[] values = new long[n];
        long sum = 0;
        for(int i = 0; i<n; i++){
            sum += a[i];
            values[i] = a[i];
        }
        
        if(sum != 0) return -1;
        
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> order = new ArrayList<>();
        parent[0] = 0;
        stack.push(0);
        
        while(!stack.isEmpty()){
            int now = stack.pop();
            order.add(now);
            
            for(int next: graph[now]){
                if(parent[next] == -1){
                    parent[next] = now;
                    stack.push(next);
                }
            }
        }
        
        long answer = 0;
        
        for(int i = order.size() -1; i>0; i--){
            int now = order.get(i);
            int p = parent[now];
            
            answer += Math.abs(values[now]);
            values[p] += values[now];
        }
        
        return answer;
    }
}