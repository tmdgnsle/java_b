

import java.io.*;
import java.util.*;

public class Solution {

	static Point home, company;
	static int N;
	static Point[] customer;
	static boolean[] v;
	static int result;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			home = new Point(x, y);
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			company = new Point(x, y);
			v = new boolean[N];
			result = Integer.MAX_VALUE;
			customer = new Point[N];

			for (int i = 0; i < N; i++) {
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				customer[i] = new Point(p1, p2);
			}

			bt(0, 0, company);

			System.out.println("#" + t + " " + result);

		}
	}

	static void bt(int depth, int distance, Point current) {
		if (depth == N) {
			int distance_home = distance + Math.abs(current.x - home.x) + Math.abs(current.y - home.y);
			result = Math.min(result, distance_home);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				int next_distance = distance + Math.abs(current.x - customer[i].x)
						+ Math.abs(current.y - customer[i].y);

				if (next_distance < result) {
					v[i] = true;
					bt(depth + 1, next_distance, customer[i]);
					v[i] = false;
				}
			}
		}

	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
