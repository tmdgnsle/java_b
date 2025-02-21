

import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static int[][] v;
	static int start_i, start_j;
	static int end_i, end_j;
	static int N;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_4193.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new int[N][N];

			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					v[i][j] = -1;
				}
			}
			st = new StringTokenizer(br.readLine());
			start_i = Integer.parseInt(st.nextToken());
			start_j = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			end_i = Integer.parseInt(st.nextToken());
			end_j = Integer.parseInt(st.nextToken());

			int result = BFS();

			System.out.println("#" + t + " " + result);

		}
	}

	static int BFS() {
		int result = -1;
		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[] { start_i, start_j, 0 });
		v[start_i][start_j] = 0;
		while (!q.isEmpty()) {
			Integer[] now = q.poll();
			int ci = now[0];
			int cj = now[1];
			int ct = now[2];

			if (ci == end_i && cj == end_j) {
				if (result != -1) {
					result = Math.min(result, ct);
				} else {
					result = ct;
				}
			}

			for (int i = 0; i < 4; i++) {
				int ni = ci + di[i];
				int nj = cj + dj[i];
				int nt = ct + 1;

				if (0 <= ni && ni < N && 0 <= nj && nj < N) {
					if (map[ni][nj] != 1 && v[ni][nj] == -1) {

						if (map[ni][nj] == 2 && nt % 3 != 0) {
							if (nt % 3 == 1) {
								nt += 2;
							} else {
								nt += 1;
							}
						}

						q.add(new Integer[] { ni, nj, nt });
						v[ni][nj] = nt;
					} else if (map[ni][nj] != 1 && v[ni][nj] > nt) {
						if (map[ni][nj] == 2 && nt % 3 != 0) {
							if (nt % 3 == 1) {
								nt += 2;
							} else {
								nt += 1;
							}
						}
						q.add(new Integer[] { ni, nj, nt });
						v[ni][nj] = nt;
					}
				}
			}

		}

		return result;
	}

}
