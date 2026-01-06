import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        long sum = 0;
        for (int w : works) {
            sum += w;
        }
        if (sum <= n) {
            return 0;
        }

        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) {
            pq.offer(w);
        }

        
        for (int i = 0; i < n; i++) {
            int cur = pq.poll();      
            if (cur == 0) break;      
            pq.offer(cur - 1);        
        }

        
        long answer = 0;
        while (!pq.isEmpty()) {
            long w = pq.poll();
            answer += w * w;
        }

        return answer;
    }
}