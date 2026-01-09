import java.util.*;

class Solution {
    static class State {
        int darts;   // 사용한 다트 수 (최소화)
        int singles; // 싱글/불 개수 (최대화)
        State(int d, int s) { darts = d; singles = s; }
    }

    public int[] solution(int target) {
        // 가능한 한 발 점수 목록 만들기: (점수, 싱글/불 여부)
        List<int[]> shots = new ArrayList<>();

        // 싱글 1~20
        for (int i = 1; i <= 20; i++) shots.add(new int[]{i, 1});

        // 더블 2~40
        for (int i = 1; i <= 20; i++) shots.add(new int[]{2 * i, 0});

        // 트리플 3~60
        for (int i = 1; i <= 20; i++) shots.add(new int[]{3 * i, 0});

        // 불 50
        shots.add(new int[]{50, 1});

        // dp 초기화
        State[] dp = new State[target + 1];
        dp[0] = new State(0, 0);

        for (int s = 1; s <= target; s++) {
            dp[s] = new State(1_000_000_000, -1); // 큰 값으로 초기화

            for (int[] shot : shots) {
                int p = shot[0];
                int isSingleOrBull = shot[1];

                if (s - p < 0) continue;
                State prev = dp[s - p];
                // if (prev == null) continue;

                int nd = prev.darts + 1;
                int ns = prev.singles + isSingleOrBull;

                // 더 좋은 상태인지 비교
                if (nd < dp[s].darts || (nd == dp[s].darts && ns > dp[s].singles)) {
                    dp[s] = new State(nd, ns);
                }
            }
        }

        return new int[]{dp[target].darts, dp[target].singles};
    }
}