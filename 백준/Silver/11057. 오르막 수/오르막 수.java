import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 1)
			System.out.println(10);
		else {
			int[][] dp = new int[n + 1][10];
			for (int i = 0; i < 10; i++) {
				dp[1][i] = 1;
			}

			for (int i = 2; i <= n; i++) {
				for (int j = 0; j < 10; j++) {
					int sum = 0;
					for (int k = 0; k <= j; k++) {
						sum += dp[i - 1][k] % 10007;
					}
					dp[i][j] = sum;
				}

			}

			int result = 0;
			for (int i = 0; i < 10; i++) {
				result = (result + dp[n][i]) % 10007;
			}

			System.out.println(result);

		}
	}
}