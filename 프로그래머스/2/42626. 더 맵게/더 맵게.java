import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a: scoville) pq.add(a);
        
        int mixCount = 0;
        while(pq.size() > 1 && pq.peek() < K){
            int a = pq.poll();
            int b = pq.poll();
            
            pq.add(a + (b * 2));
            mixCount++;
        }
        
        if(pq.peek() < K) return -1;
        return mixCount;
    }
}