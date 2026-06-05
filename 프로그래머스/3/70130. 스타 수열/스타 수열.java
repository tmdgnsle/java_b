import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int n = a.length;
        
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num: a){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        for(int x: count.keySet()){
            if(count.get(x) * 2 <= answer) continue;
            
            int pair = 0;
            for(int i = 0; i<n-1; i++){
                if(a[i] == a[i+1]) continue;
                if(a[i] != x && a[i+1] != x) continue;
                
                pair++;
                i++;
            }
            answer = Math.max(answer, pair*2);
        }
        
        return answer;
    }
}