import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[n + 1][m + 1];
		dp[1][1] = map[1][1];

		if (n == 1 && m == 1) {
			System.out.println(dp[1][1]);
		} else {
			int max = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (i == 1 && j == 1) {
						continue;
					}
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
					max = Math.max(dp[i][j], max);
				}
			}

			System.out.println(max);

		}

	}
}