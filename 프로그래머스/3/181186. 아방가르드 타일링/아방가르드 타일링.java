import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    public int solution(int n) {
        long[] dp = new long[Math.max(n + 1, 7)];

        dp[0] = 1;
        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 3;
        if (n >= 3) dp[3] = 10;
        if (n >= 4) dp[4] = 23;
        if (n >= 5) dp[5] = 62;
        if (n >= 6) dp[6] = 170;

        for (int i = 7; i <= n; i++) {
            long val = 0;
            val = (val + dp[i - 1]) % MOD;
            val = (val + 2L * dp[i - 2]) % MOD;
            val = (val + 6L * dp[i - 3]) % MOD;
            val = (val + dp[i - 4]) % MOD;
            val = (val - dp[i - 6]) % MOD;

            // 자바에서 음수 mod 보정
            if (val < 0) val += MOD;

            dp[i] = val;
        }

        return (int) (dp[n] % MOD);
    }
}