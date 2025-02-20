

import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int map[][];
	static int maxCount, minRoom;
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			maxCount = 0;
			minRoom = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int count = dfs(i, j);

					if (count > maxCount) {
						maxCount = count;
						minRoom = map[i][j];
					} else if (count == maxCount) {
						minRoom = Math.min(minRoom, map[i][j]);
					}
				}
			}

			System.out.println("#" + t + " " + minRoom + " " + maxCount);

		}
	}

	static int dfs(int ci, int cj) {
		int count = 1;
		for (int i = 0; i < 4; i++) {
			int ni = ci + di[i];
			int nj = cj + dj[i];

			if (ni < 0 || ni >= N || nj < 0 || nj >= N)
				continue;

			if (map[ni][nj] == map[ci][cj] + 1) {
				count += dfs(ni, nj);
				break;
			}
		}

		return count;
	}

}
