import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] price = new int[2][N + 1];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					price[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[2][N + 1];
			long result = 0;
			if (N == 1) {
				result = Math.max(price[0][1], price[1][1]);
			} else if (N == 2) {
				result = Math.max(price[0][1] + price[1][2], price[0][2] + price[1][1]);
			} else {
				dp[0][1] = price[0][1];
				dp[1][1] = price[1][1];
				dp[0][2] = price[0][2] + dp[1][1];
				dp[1][2] = price[1][2] + dp[0][1];

				result = Math.max(dp[0][2], dp[1][2]);

				for (int i = 3; i <= N; i++) {
					dp[0][i] = Math.max(dp[1][i - 1], Math.max(dp[0][i - 2], dp[1][i - 2])) + price[0][i];
					dp[1][i] = Math.max(dp[0][i - 1], Math.max(dp[0][i - 2], dp[1][i - 2])) + price[1][i];
					result = Math.max(result, Math.max(dp[0][i], dp[1][i]));
				}

				

			}
			System.out.println(result);

		}

	}
}