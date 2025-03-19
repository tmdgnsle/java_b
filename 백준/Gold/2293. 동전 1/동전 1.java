import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);

		int[] dp = new int[k + 1];
		dp[0] = 1;

		for (int num : nums) {

			for (int i = num; i <= k; i++) {
				dp[i] += dp[i - num];
			}
		}

		System.out.println(dp[k]);

	}
}