import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.offer(enemy[i]);

            if (n < 0) {

                if (k == 0) {
                    return i;
                }

                // 지금까지 가장 큰 공격에 무적권을 사용한 것으로 변경
                n += pq.poll();
                k--;
            }
        }

        return enemy.length;
    }
}