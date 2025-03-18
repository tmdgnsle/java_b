import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}

		dp[0] = num[0];
		int max = num[0];
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
			max = Math.max(dp[i], max);
		}

		System.out.println(max);
	}
}