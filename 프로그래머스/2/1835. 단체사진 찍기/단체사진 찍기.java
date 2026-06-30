import java.util.*;
class Solution {
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visited = new boolean[8];
    static ArrayList<Character> line = new ArrayList<>();
    static String[] data;
    static int answer;
    
    public int solution(int n, String[] data) {
        answer = 0;
        this.data = data;
        dfs(0);
        return answer;
    }
    
    static void dfs(int idx){
        if(idx == 8){
            if(check()) answer++;
            return;
        }
        
        for(int i = 0; i<8; i++){
            if(!visited[i]){
                visited[i] = true;
                line.add(friends[i]);
                
                dfs(idx+1);
                
                visited[i] = false;
                line.remove(line.size() - 1);
            }
        }
        
    }
    
    static boolean check(){
        for(String d: data){
            char a = d.charAt(0);
            char b = d.charAt(2);
            char op = d.charAt(3);
            int num = d.charAt(4) - '0';
            
            int posA = 0;
            int posB = 0;
            
            for(int i = 0; i<line.size(); i++){
                if(line.get(i) == a) posA = i;
                if(line.get(i) == b) posB = i;
            }
            
            int distance = Math.abs(posA - posB) - 1;
            
            if(op == '='){
                if(distance != num) return false;
            }else if(op == '<'){
                if(distance >= num) return false;
            }else if(op == '>'){
                if(distance <= num) return false;
            }
            
            
        }
        return true;
    }
    
}