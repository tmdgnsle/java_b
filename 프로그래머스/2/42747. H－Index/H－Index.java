import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int max = citations[citations.length-1];
        for(int h = max; h>= 0; h--){
            int count = 0;
            for(int i = citations.length-1; i>=0; i--){
                if(citations[i] >= h){
                    count++;
                } else {
                    break;
                }
            }
            
            if(count >= h){
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}