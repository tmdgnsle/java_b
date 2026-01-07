import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "";
        int num = 0;
        while(str.length() <= (m * t)){
            String current = Integer.toString(num++, n).toUpperCase();
            str += current;
        }
        
        int idx = p;
        for(int i = 0; i<t; i ++){
            answer += str.substring(p-1, p);
            p += m;
        }
        return answer;
    }
}