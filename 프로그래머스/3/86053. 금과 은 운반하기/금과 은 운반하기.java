class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = 4_000_000_000_000_000L; // 충분히 큰 값이라는데 그거 계산하기가 제일 어려운듯
        long answer = right;

        // 이분 탐색 시작
        while (left <= right) {
            long mid = (left + right) / 2; // 현재 시간 후보
            long gold = 0;   // mid 시간 동안 옮길 수 있는 금
            long silver = 0; // mid 시간 동안 옮길 수 있는 은
            long total = 0;  // mid 시간 동안 옮길 수 있는 총량 (금+은)

            // 모든 도시에 대해 계산
            for (int i = 0; i < g.length; i++) {
                // 왕복 시간 (갔다가 돌아오기)
                long roundTime = t[i] * 2L;

                // mid 시간 동안 가능한 왕복 횟수
                long move = mid / roundTime;

                // 남은 시간으로 편도 1번 더 가능하면 +1
                if (mid % roundTime >= t[i]) {
                    move++;
                }
                // 해당 도시에서 운반 가능한 최대 무게
                long amount = move * w[i];
                // 금만 실었다고 가정
                gold += Math.min((long) g[i], amount);
                // 은만 실었다고 가정
                silver += Math.min((long) s[i], amount);
                // 전체 운반량도 제한됨 (금+은 합 기준)
                total += Math.min((long) g[i] + s[i], amount);

            }

            // 목표 달성 가능한지 체크
            if (gold >= a && silver >= b && total >= (long) a + b) {
                answer = mid;      // 가능한 시간 → 정답 후보
                right = mid - 1;  // 더 작은 시간도 가능한지 탐색
            } else {
                left = mid + 1;   // 부족 → 시간 늘리기
            }
        }

        return answer;
    }
}