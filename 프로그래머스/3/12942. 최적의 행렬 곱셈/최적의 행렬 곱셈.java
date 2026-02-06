import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;
        int[][] dp = new int[n][n]; // 인덱스 i 부터 j까지의 행렬 연산 횟수 dp[i][j]

        // 큰 값으로 초기화 (i<j만 사용)
        final int INF = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0; // 한 개 행렬은 비용 0
        }

        // len: 구간 길이 (2부터)
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                for (int k = i; k < j; k++) {
                    long cost = (long) dp[i][k]
                            + dp[k + 1][j]
                            + (long) matrix_sizes[i][0] * matrix_sizes[k][1] * matrix_sizes[j][1];

                    // i 부터 j까지의 연산 횟수는 중간에 K를 넣어서
                    // dp[i][k] + dp[k+1][j]
                    // + 이 둘의 연산 횟수 (long) matrix_sizes[i][0] * matrix_sizes[k][1] * matrix_sizes[j][1]
                    
                    if (cost < dp[i][j]) dp[i][j] = (int) cost;
                }
            }
        }

        return dp[0][n - 1];
    }
}