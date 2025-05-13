import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] nums = new long[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}

		int start = 0;
		int end = N - 1;

		long result = Long.MAX_VALUE;

		long rs = 0;
		long re = 0;

		while (start < end) {
			long diff = nums[start] + nums[end];
			

			if (diff == 0) {
				result = diff;
				rs = nums[start];
				re = nums[end];
				break;
			}

			if (Math.abs(diff) <= result) {
				result = Math.abs(diff);
				rs = nums[start];
				re = nums[end];
			}

			if (diff < 0) {
				start++;
			} else {
				end--;
			}
		}

		System.out.println("" + rs + " " + re);

	}

}