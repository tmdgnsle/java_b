import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = discount.length-1; i>=9; i--){
            if(isPossible(want, number, discount, i)){
                answer++;   
            }
        }
        
        return answer;
    }
    
    static boolean isPossible(String[] want, int[] number, String[] discount, int idx){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        
        for(int i = idx; i > idx - 10; i--){
            if(!map.containsKey(discount[i])){
                return false;
            }
            
            int count = map.get(discount[i]);
            
            if(count == 0){
                return false;
            }
            
            map.put(discount[i], count - 1);
            
        }
        
        return true;
        
    }
    
}