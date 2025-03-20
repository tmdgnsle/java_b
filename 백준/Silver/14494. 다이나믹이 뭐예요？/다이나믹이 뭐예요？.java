import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		final int MOD = 1_000_000_007;

		// dp[i][j] = (1,1)에서 (i,j)까지 가는 경우의 수
		long[][] dp = new long[n + 1][m + 1];

		// 초기화
		dp[1][1] = 1; // 시작점

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == 1 && j == 1)
					continue; // 시작점은 이미 초기화됨

				// (i,j)로 오는 방법: (i-1,j), (i,j-1), (i-1,j-1)에서 오는 경우
				long sum = 0;
				if (i > 1)
					sum = (sum + dp[i - 1][j]) % MOD; // 위에서 오는 경우
				if (j > 1)
					sum = (sum + dp[i][j - 1]) % MOD; // 왼쪽에서 오는 경우
				if (i > 1 && j > 1)
					sum = (sum + dp[i - 1][j - 1]) % MOD; // 대각선에서 오는 경우

				dp[i][j] = sum;
			}
		}

		System.out.println(dp[n][m]);
	}
}