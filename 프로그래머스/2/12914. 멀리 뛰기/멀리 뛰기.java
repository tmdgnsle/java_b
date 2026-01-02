import java.util.*;
class Solution {
    public long solution(int n) {
        // long answer = 0;
        long[] counts = new long[n+1];
        counts[1] = 1;
        if(n >= 2) counts[2] = 2;
        
        for(int i = 3; i<= n; i++){
            counts[i] = (counts[i-1] + counts[i-2]) % 1234567;
        }
        
        
        return counts[n] % 1234567;
    }
    
    
    
}