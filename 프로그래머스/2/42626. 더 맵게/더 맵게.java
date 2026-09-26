import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s: scoville){
            pq.offer(s);
        }
        
        while(true){
            if(pq.peek() >= K) break;
            
            int first = pq.poll();
            if(pq.isEmpty()) return -1;
            
            int second = pq.poll();
            pq.offer(first + 2*second);
            answer++;
            
            
        }
        
        
        return answer;
    }
}