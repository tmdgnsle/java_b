import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int running = 0;                 
        int[] shutdown = new int[24 + k + 1]; // t시에 반납될 서버 수

        for (int t = 0; t < 24; t++) {
            
            running -= shutdown[t];

            
            int required = players[t] / m; // players < m 이면 0, n*m 이상이면 n

            
            if (running < required) {
                int add = required - running;
                answer += add;
                running += add;

                // k시간 뒤 반납 예약
                shutdown[t + k] += add;
            }
        }
        return answer;
    }
}