import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int maxNode = 0;
        for(int[] edge: edges){
            maxNode = Math.max(maxNode, edge[0]);
            maxNode = Math.max(maxNode, edge[1]);
        }
        
        int[] in = new int[maxNode + 1];
        int[] out = new int[maxNode + 1];
        
        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            
            out[from]++;
            in[to]++;
        }
        
        int createdNode = 0;
        int donut = 0;
        int stick = 0;
        int eight = 0;
        
        for(int i = 1; i<= maxNode; i++){
            if(in[i] == 0 && out[i] >= 2){
                createdNode = i;
            }
            
            if(in[i] >= 1 && out[i] == 0){
                stick++;
            }
            
            if(in[i] >= 2 && out[i] == 2){
                eight++;
            }
        }
        
        int total = out[createdNode];
        donut = total - stick - eight;
        
        
        
        
        return new int[] {createdNode, donut, stick, eight};
    }
}