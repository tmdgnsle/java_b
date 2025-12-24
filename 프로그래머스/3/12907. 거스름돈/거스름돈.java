import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int coin : money) {          
            for (int sum = coin; sum <= n; sum++) { 
                dp[sum] = (dp[sum] + dp[sum - coin]) % MOD;
            }
        }
        return dp[n];
    }
}