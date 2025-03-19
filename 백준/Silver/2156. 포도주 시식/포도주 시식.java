import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] wine = new int[N + 1];
		int[][] dp = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		dp[1][0] = 0;
		dp[1][1] = wine[1];

		int max = wine[1];

		for (int i = 2; i <= N; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
			dp[i][1] = dp[i - 1][0] + wine[i];
			dp[i][2] = dp[i - 1][1] + wine[i];

			max = Math.max(max, Math.max(dp[i][0], Math.max(dp[i][1], dp[i][2])));

		}

		System.out.println(max);

	}
}