import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // 1. 시간 범위 설정
        long left = 1; // 최소 시간: 1분
        
        int maxTime = Integer.MIN_VALUE;
        
        for(int time: times){
            maxTime = Math.max(maxTime, time);
        }
        
        long right = (long) n * maxTime; // 최대 시간: 가장 느린 심사관이 모든 사람을 처리
        
        long answer = right;
        
        // 2. 이분 탐색
        while(left <= right) {
            long mid = (left + right) / 2;
            
            // mid 시간 동안 심사 가능한 사람 수 계산
            long totalPeople = 0;
            for(int time : times) {
                totalPeople += mid / time;
                // 오버플로우 방지
                if(totalPeople >= n) break;
            }
            
            if(totalPeople >= n) {
                // n명 이상 심사 가능 → 시간을 줄여볼 수 있음
                answer = mid;
                right = mid - 1;
            } else {
                // n명 심사 불가능 → 시간을 늘려야 함
                left = mid + 1;
            }
        }
        
        return answer;
    }
}