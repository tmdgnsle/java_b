import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> up = new HashMap<>();
        HashMap<String, Integer> benefit = new HashMap<>();
        int length = enroll.length;
        for(int i = 0; i<length; i++){
            up.put(enroll[i], referral[i]);
            benefit.put(enroll[i], 0);
        }
        
        int sLength = seller.length;
        for(int i = 0; i<sLength; i++){
            String p = seller[i];
            int money = 100 * amount[i];
            
            while(true){
                int next = money / 10;
                
                
                int current = money - next;
                benefit.put(p, benefit.getOrDefault(p, 0) + current);
                money = next;
                p = up.get(p);
                if(next < 1) break;
            }
        }
        
        
        
        int[] answer = new int[length];
        for(int i = 0; i<length; i++){
            answer[i] = benefit.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
}