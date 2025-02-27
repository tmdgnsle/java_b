

import java.io.*;
import java.util.*;

public class Solution {
	static int N, K;
	static int[][] map;
	static ArrayList<int[]> max_p;
	static int max;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int result;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			v = new boolean[N][N];
			max_p = new ArrayList<int[]>();
			max = Integer.MIN_VALUE;
			result = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max) {
						max_p.clear();
						max = map[i][j];
						max_p.add(new int[] { i, j });
					}
					if (map[i][j] == max)
						max_p.add(new int[] { i, j });
				}
			}

			for (int[] a : max_p) {
				v[a[0]][a[1]] = true;
				dfs(a[0], a[1], max, 1, false);
				v[a[0]][a[1]] = false;
			}

			System.out.println("#" + t + " " + result);

		}
	}

	// 현재 i, 현재 j, 현재 높이, 현재 길이, 높이를 깎은적이 있는지
	static void dfs(int ci, int cj, int h, int len, boolean use) {
		if (result < len)
			result = len;

		for (int i = 0; i < 4; i++) {
			int ni = ci + di[i];
			int nj = cj + dj[i];

			if (ni < 0 || ni >= N || nj < 0 || nj >= N)
				continue;

			if (v[ni][nj])
				continue;

			if (h > map[ni][nj]) {
				v[ni][nj] = true;
				dfs(ni, nj, map[ni][nj], len + 1, use);
				v[ni][nj] = false;
			} else {
				if (!use && (map[ni][nj] - K) < h) {
					v[ni][nj] = true;
					dfs(ni, nj, h - 1, len + 1, !use);
					v[ni][nj] = false;
				}
			}

		}
	}

}
