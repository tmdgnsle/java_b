import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i = 0; i<queue1.length; i++){
            sum1 += queue1[i];
            q1.add(queue1[i]);
            sum2 += queue2[i];
            q2.add(queue2[i]);
        }
        if(sum1 == sum2) return 0;
        if((sum1 + sum2) % 2 == 1) return -1;
        
        int answer = 0;
        
        while(true){
            
            if(answer > 4 * queue1.length) break;
            
            if(sum1 == sum2) return answer;
            
            if(sum1 > sum2){
                int num = q1.poll();
                sum1 -= num;
                q2.add(num);
                sum2 += num;
                
            }else {
                int num = q2.poll();
                sum2 -= num;
                q1.add(num);
                sum1 += num;
            }
            answer++;
        }
        
        
        
        
        
        
        return -1;
    }
}