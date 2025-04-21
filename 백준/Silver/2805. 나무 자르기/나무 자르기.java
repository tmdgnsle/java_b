import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		long[] trees = new long[N];
		long maxTree = Long.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			maxTree = Math.max(maxTree, trees[i]);
		}

		long left = 0;
		long right = maxTree;

		long result = 0;

		while (left <= right) {
			long mid = (left + right) / 2;

			long sum = 0;
			for (int i = 0; i < N; i++) {
				long temp = trees[i] - mid;
				if (temp > 0) {
					sum += temp;
				}
			}

			if (sum >= M) { // sum == M 인 경우도 이 조건에 포함
				result = mid;
				left = mid + 1; // 더 큰 높이가 가능한지 확인
			} else { // sum < M
				right = mid - 1;
			}

		}

		System.out.println(result);

	}
}