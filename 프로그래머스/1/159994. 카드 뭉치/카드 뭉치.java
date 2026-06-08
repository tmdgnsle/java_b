import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int length1 = cards1.length;
        int length2 = cards2.length;
        int idx1 = 0;
        int idx2 = 0;
        boolean can = true;
        for(int i = 0; i<goal.length; i++){
            if(idx1 < length1 && cards1[idx1].equals(goal[i])){
                idx1++;
                continue;
            }
            if(idx2 < length2 && cards2[idx2].equals(goal[i])){
                idx2++;
                continue;
            }
            
            can = false;
            break;
        }
        
        if(can) return "Yes";
        else return "No";
        
    }
}