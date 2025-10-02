import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 1. 시간을 분 단위로 변환하여 배열에 저장
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = timeToMinute(book_time[i][0]); // 입실 시간
            times[i][1] = timeToMinute(book_time[i][1]) + 10; // 퇴실 시간 + 청소 시간 10분
        }
        
        // 2. 입실 시간 기준으로 정렬
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        
        // 3. 우선순위 큐를 사용하여 퇴실 시간 관리 (최소 힙)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] time : times) {
            // 가장 빨리 퇴실하는 시간이 현재 입실 시간보다 작거나 같으면 해당 방 사용 가능
            if (!pq.isEmpty() && pq.peek() <= time[0]) {
                pq.poll(); // 사용 가능한 방 제거
            }
            // 현재 예약의 퇴실 시간 추가
            pq.add(time[1]);
        }
        
        // 4. 큐에 남아있는 개수가 필요한 객실 수
        return pq.size();
    }
    
    // 시간 문자열을 분 단위로 변환
    static int timeToMinute(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        return hour * 60 + minute;
    }
}