

import java.util.*;
import java.io.*;

public class Solution {
	static int[] numbers;
	static int[] opers;
	static int N;
	static int min, max;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_4008.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			numbers = new int[N];
			opers = new int[4];
			for (int i = 0; i < 4; i++) {
				opers[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;

			dfs(1, numbers[0]);

			int result = max - min;

			System.out.println("#" + t + " " + result);

		}
	}

	static void dfs(int depth, int current) {
		if (depth == N) {
			min = Math.min(min, current);
			max = Math.max(max, current);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (opers[i] > 0) {
				opers[i]--;
				int next = current;
				switch (i) {
				case (0):
					next += numbers[depth];
					break;
				case (1):
					next -= numbers[depth];
					break;
				case (2):
					next *= numbers[depth];
					break;
				case (3):
					next /= numbers[depth];
					break;
				}
				dfs(depth + 1, next);
				opers[i]++;
			}
		}

	}

}