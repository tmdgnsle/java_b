import java.util.*;

class Solution {
    static int[][] cost;
    static int[][] hint;
    static HashMap<Integer, Integer> have;
    static int answer;
    static int n;

    public int solution(int[][] cost, int[][] hint) {
        Solution.cost = cost;
        Solution.hint = hint;

        have = new HashMap<>();
        answer = Integer.MAX_VALUE;
        n = cost.length;

        dfs(0, 0);

        return answer;
    }

    static void dfs(int idx, int current) {
        if (current >= answer) return;

        if (idx == n) {
            answer = Math.min(answer, current);
            return;
        }

        int hintCount = have.getOrDefault(idx, 0);

        if (hintCount >= cost[idx].length) {
            hintCount = cost[idx].length - 1;
        }

        current += cost[idx][hintCount];

        if (idx == n - 1) {
            dfs(idx + 1, current);
            return;
        }

        int hintCost = hint[idx][0];

        // 힌트 사는 경우
        for (int i = 1; i < hint[idx].length; i++) {
            int key = hint[idx][i] - 1; 
            have.put(key, have.getOrDefault(key, 0) + 1);
        }

        dfs(idx + 1, current + hintCost);

        // 되돌리기
        for (int i = 1; i < hint[idx].length; i++) {
            int key = hint[idx][i] - 1;
            have.put(key, have.get(key) - 1);

            if (have.get(key) == 0) {
                have.remove(key);
            }
        }

        // 힌트 안 사는 경우
        dfs(idx + 1, current);
    }
}