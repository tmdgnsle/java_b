

import java.io.*;
import java.util.*;

public class Solution {
	static int[] plan;
	static int d, m, m3, y;
	static int result;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			m3 = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			result = y;
			st = new StringTokenizer(br.readLine());
			plan = new int[12];
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			solve(0, 0);

			System.out.println("#" + t + " " + result);
		}

	}

	static void solve(int month, int fee) {
		if (fee > result)
			return;

		if (month >= 12) {
			result = fee;
		} else {
			solve(month + 1, fee + d * plan[month]);
			solve(month + 1, fee + m);
			solve(month + 3, fee + m3);
		}

	}

}