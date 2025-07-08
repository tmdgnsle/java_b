import java.util.*;
class Solution {
    
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] wear: clothes){
            int value = map.getOrDefault(wear[1],0);
            map.put(wear[1], value+1);
        }
        
        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}