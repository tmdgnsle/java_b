

import java.io.*;
import java.util.*;

public class Solution {
	static int maxCount, minLine, N, core, map[][];
	static int[][] pos = new int[12][2];
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			maxCount = 0;
			minLine = Integer.MAX_VALUE;
			core = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
						continue;

					if (map[i][j] == 1) {
						pos[maxCount][0] = i;
						pos[maxCount][1] = j;
						maxCount++;
					}

				}
			}

			solve(0, 0, 0);

			System.out.println("#" + t + " " + minLine);

		}

	}

	static void solve(int k, int connect, int currentLine) {
		if (k == maxCount) {
			if (core < connect) {
				core = connect;
				minLine = currentLine;
			} else if (core == connect) {
				minLine = Math.min(minLine, currentLine);
			}
		} else {
			int ci = pos[k][0];
			int cj = pos[k][1];
			int newLine = 0;

			for (int i = 0; i < 4; i++) {
				if (isConnectable(ci, cj, i)) {
					newLine = setLine(ci, cj, i, 1);
					solve(k + 1, connect + 1, currentLine + newLine);
					setLine(ci, cj, i, 0);
				}
			}
			solve(k + 1, connect, currentLine);

		}
	}

	static boolean isConnectable(int ci, int cj, int d) {
		int ni = ci;
		int nj = cj;

		while (true) {
			ni += di[d];
			nj += dj[d];
			if (isOutOfRange(ni, nj))
				return true;
			if (map[ni][nj] == 1)
				return false;
		}
	}

	static boolean isOutOfRange(int ci, int cj) {
		if (ci < 0 || ci >= N || cj < 0 || cj >= N)
			return true;

		return false;
	}

	static int setLine(int ci, int cj, int d, int val) {
		int ni = ci;
		int nj = cj;
		int count = 0;

		while (true) {
			ni += di[d];
			nj += dj[d];

			if (isOutOfRange(ni, nj))
				break;
			map[ni][nj] = val;
			count++;

		}
		return count;
	}

}