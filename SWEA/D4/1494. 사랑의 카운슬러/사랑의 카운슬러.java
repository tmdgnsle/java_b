import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] scores;
	static boolean[] selected;
	static long result;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1494.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			scores = new int[N][2];
			selected = new boolean[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				scores[i][0] = Integer.parseInt(st.nextToken());
				scores[i][1] = Integer.parseInt(st.nextToken());
			}

			result = Long.MAX_VALUE;

			dfs(0, 0);

			System.out.println("#" + t + " " + result);

		}
	}

	static void dfs(int idx, int count) {
		if (count == N / 2) {
			calculate();
			return;
		}

		if (idx == N)
			return;

		selected[idx] = true;
		dfs(idx + 1, count + 1);

		selected[idx] = false;
		dfs(idx + 1, count);

	}

	static void calculate() {
		long sumX = 0, sumY = 0;

		for (int i = 0; i < N; i++) {
			if (selected[i]) {
				sumX += scores[i][0];
				sumY += scores[i][1];
			} else {
				sumX -= scores[i][0];
				sumY -= scores[i][1];
			}
		}

		long sum = sumX * sumX + sumY * sumY;
		result = Math.min(result, sum);
	}

}