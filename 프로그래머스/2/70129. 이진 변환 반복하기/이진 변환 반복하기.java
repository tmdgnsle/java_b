import java.util.*;
class Solution {
    public int[] solution(String s) {
        int deleteZero = 0;
        int changeCount = 0;
        while(!s.equals("1")){
            changeCount++;
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i) == '0') deleteZero++;
                else sb.append(s.charAt(i));
            }
            
            int num = sb.length();
            
            s = Integer.toBinaryString(num);
            
        }
        
        int[] answer = {changeCount, deleteZero};
        return answer;
    }
}