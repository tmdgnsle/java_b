

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] v;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int count;
	static ArrayList<Integer> arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		count = 0;
		arr = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s.substring(j, j + 1));
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j] && map[i][j] == 1) {

					arr.add(dfs(i, j, 1));
					count++;
				}
			}
		}

		arr.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}

		});

		System.out.println(count);
		for (int a : arr) {
			System.out.println(a);
		}

	}

	static int dfs(int ci, int cj, int cc) {
		if (v[ci][cj])
			return 0;

		v[ci][cj] = true;

		for (int i = 0; i < 4; i++) {
			int ni = ci + di[i];
			int nj = cj + dj[i];

			if (ni < 0 || ni >= N || nj < 0 || nj >= N)
				continue;
			if (v[ni][nj] || map[ni][nj] == 0)
				continue;

			cc = dfs(ni, nj, cc + 1);

		}

		return cc;
	}

}
