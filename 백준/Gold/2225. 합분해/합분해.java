import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		final int MOD = 1_000_000_000;

		// dp[k][n] = 정수 k개를 더해서 그 합이 n이 되는 경우의 수
		long[][] dp = new long[K + 1][N + 1];

		// 초기화: 1개의 숫자로 n을 만드는 방법은 1가지 (n 자체)
		for (int n = 0; n <= N; n++) {
			dp[1][n] = 1;
		}

		// 점화식: dp[k][n] = dp[k-1][0] + dp[k-1][1] + ... + dp[k-1][n]
		// 최적화: dp[k][n] = dp[k][n-1] + dp[k-1][n]
		for (int k = 2; k <= K; k++) {
			for (int n = 0; n <= N; n++) {
				if (n == 0) {
					dp[k][n] = 1; // k개 숫자로 합이 0이 되는 경우는 모두 0을 선택하는 1가지
				} else {
					dp[k][n] = (dp[k][n - 1] + dp[k - 1][n]) % MOD;
				}
			}
		}

		System.out.println(dp[K][N]);
	}
}