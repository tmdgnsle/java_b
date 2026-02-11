import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        
        for(String sk: skill_trees){
            int idx = 0;
            boolean can = true;
            for(char c: sk.toCharArray()){
                if(skill.contains("" + c)){
                    if(skill.charAt(idx) == c){
                        idx++;
                    }else{
                        can = false;
                        break;
                    }
                }
            }
            if(can) answer++;
        }
        
        return answer;
    }
}