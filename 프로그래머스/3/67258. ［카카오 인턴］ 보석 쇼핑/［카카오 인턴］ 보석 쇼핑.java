import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        
        Set<String> set = new HashSet<>();
        
        
        for(String gem: gems){
            set.add(gem);
        }
        
        int types = set.size();
        
        System.out.println(gems.length);
        
        int left = 0;
        
        
        int min_start = Integer.MAX_VALUE;
        int min_end = Integer.MAX_VALUE;
        int min_diff = Integer.MAX_VALUE;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int right = 0; right<gems.length; right++){
            map.put(gems[right], map.getOrDefault(gems[right], 0)+1);
            
            while(map.size() == types){
                
                int current_diff = right - left;
                if(current_diff < min_diff){
                    min_start = left;
                    min_end = right;
                    min_diff = current_diff;
                }
                
                map.put(gems[left], map.get(gems[left]) - 1);
                if(map.get(gems[left])==0){
                    map.remove(gems[left]);
                }
                left++;
            }
        }
        
        
        int[] answer = {min_start+1, min_end+1};
        return answer;
    }
}