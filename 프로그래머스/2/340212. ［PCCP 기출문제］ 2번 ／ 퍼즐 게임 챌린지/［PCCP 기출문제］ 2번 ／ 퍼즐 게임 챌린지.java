import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int max_diff = Integer.MIN_VALUE;
        for(int diff: diffs){
            max_diff = Math.max(max_diff, diff);
        }
        
        int start = 1;  // 수정: 0 → 1
        int end = max_diff;
        
        while(start < end){
            int level = (start + end) / 2;
            
            int prev = 0;
            long time = 0;
            for(int i = 0; i < diffs.length; i++){
                int cur_time = times[i];
                if(level >= diffs[i]){
                    time += cur_time;
                } else {
                    time += (cur_time + prev) * (diffs[i] - level) + cur_time;   
                }
                prev = times[i];
            }
            
            if(time > limit){
                start = level + 1;
            } else {
                end = level;  // answer 업데이트 제거
            }
        }
        
        return start;  // 수정: answer → start
    }
}