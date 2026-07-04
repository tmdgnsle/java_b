import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        for(int i = 0; i<s.length(); i++){
            // 홀수
            answer = Math.max(answer, check(s, i, i));
            
            // 짝수
            if(i != s.length() - 1){
                if(s.charAt(i) == s.charAt(i+1)){
                    answer = Math.max(answer, check(s, i, i+1));
                }    
            }
            
        }

        return answer;
    }
    
    static int check(String s, int left, int right){
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right)) break;
            
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}