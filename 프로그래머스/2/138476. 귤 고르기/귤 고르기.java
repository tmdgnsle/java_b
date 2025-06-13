import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int max_size = 0;
        for(int size: tangerine){
            max_size = Math.max(max_size, size);
        }
        
        int[] tangerine_count = new int[max_size + 1];
        for(int size: tangerine){
            tangerine_count[size]++;
        }
        
        Arrays.sort(tangerine_count);
        
        int answer = 0;
        int idx = max_size;
        while(k > 0 && idx > 0){
            k -= tangerine_count[idx];
            answer++;
            idx--;
        }
        
        
        return answer;
    }
}