import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean exists = false;
        for(String w: words){
            if(target.equals(w)){
                exists = true;
                break;
            }
        }
        if(!exists) return 0;
        
        Queue<String> q = new LinkedList<>();
        Queue<Integer> steps = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        q.add(begin);
        steps.add(0);
        
        while(!q.isEmpty()){
            String cur = q.poll();
            int step = steps.poll();
            
            if(cur.equals(target)) return step;
            
            for(int i = 0; i<words.length; i++){
                if(!visited[i] && canChange(cur, words[i])){
                    visited[i] = true;
                    q.add(words[i]);
                    steps.add(step+1);
                }
            }
            
        }
        
        
        return 0;
    }
    
    static boolean canChange(String current, String word){
        int diff = 0;
        for(int i = 0; i<current.length(); i++){
            if(current.charAt(i) != word.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return diff == 1;
    }
}