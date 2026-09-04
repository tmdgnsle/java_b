import java.util.*;
class Solution {
    static int answer;
    static int[] info;
    static ArrayList<Integer>[] tree;
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        this.info = info;
        tree = new ArrayList[info.length];
        
        for(int i = 0; i<info.length; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int[] edge: edges){
            tree[edge[0]].add(edge[1]);
        }
        
        ArrayList<Integer> next = new ArrayList<>();
        
        next.addAll(tree[0]);
        
        dfs(1, 0, next);
        
        return answer;
    }
    
    
    static void dfs(int sheep, int wolf, ArrayList<Integer> next){
        answer = Math.max(answer, sheep);
        
        for(int i = 0; i<next.size(); i++){
            int node = next.get(i);
            
            int nextSheep = sheep;
            int nextWolf = wolf;
            
            if(info[node] == 0) nextSheep++;
            else nextWolf++;
            
            if(nextWolf >= nextSheep) continue;
            
            ArrayList<Integer> nextList = new ArrayList<>(next);
            
            nextList.remove(i);
            
            nextList.addAll(tree[node]);
            
            dfs(nextSheep, nextWolf, nextList);
        }
    }
}