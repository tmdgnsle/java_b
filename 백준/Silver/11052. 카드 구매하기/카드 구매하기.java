import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] price = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			// i개의 카드를 구매하기 위한 최대 비용 계산
			for (int j = 1; j <= i; j++) {
				// j개 카드팩을 사고 남은 (i-j)개의 카드 최적 구매 비용과 현재까지의 최댓값 비교
				dp[i] = Math.max(dp[i], dp[i - j] + price[j]);
			}
		}

		System.out.println(dp[n]);

	}
}