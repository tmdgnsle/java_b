

import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] score;
	static boolean[] v;
	static int min;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			score = new int[N][N];
			v = new boolean[N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					score[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bt(0, 0);

			System.out.println("#" + t + " " + min);
		}
	}

	static void bt(int index, int count) {
		if (count == N / 2) {
			int diff = calculateDiff();
			min = Math.min(min, diff);
			return;
		}

		if (index >= N)
			return;

		v[index] = true;
		bt(index + 1, count + 1);

		v[index] = false;
		bt(index + 1, count);

	}

	static int calculateDiff() {
		int A = 0, B = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i] && v[j]) {
					A += score[i][j];
				}
				if (!v[i] && !v[j]) {
					B += score[i][j];
				}
			}
		}
		int result = Math.abs(A - B);

		return result;
	}

}
