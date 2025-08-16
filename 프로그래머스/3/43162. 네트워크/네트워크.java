import java.util.*;

class Solution {
    static boolean[] v;
    static ArrayList<Integer>[] arr;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int length = computers.length;
        v = new boolean[length];
        arr = new ArrayList[length];
        
        for(int i = 0; i<length; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<length; i++){
            for(int j = 0; j<length; j++){
                if(i == j) continue;
                
                if(computers[i][j] == 1){
                    arr[i].add(j);
                }
            }
        }
        
        
        for(int i = 0; i<length; i++){
            if(!v[i]){
                answer++;
                dfs(i);
            }
        }
        
        
        
        return answer;
    }
    
    
    static void dfs(int start){
        v[start] = true;
        for(int computer: arr[start]){
            if(!v[computer]){
                dfs(computer);
            }
        }
    }
}