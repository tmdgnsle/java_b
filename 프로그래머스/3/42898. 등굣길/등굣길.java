class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;

        int[][] dp = new int[n + 1][m + 1];
        boolean[][] blocked = new boolean[n + 1][m + 1];

        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            blocked[y][x] = true;
        }

        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;

                if (blocked[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        return dp[n][m];
    }
}