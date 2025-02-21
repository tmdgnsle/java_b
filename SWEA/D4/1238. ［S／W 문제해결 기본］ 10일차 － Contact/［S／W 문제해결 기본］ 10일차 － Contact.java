

import java.io.*;
import java.util.*;

public class Solution {
	static int N, K;
	static ArrayList<Integer>[] A;
	static boolean[] v;
	static int[] d;
	static int result;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			A = new ArrayList[101];

			for (int i = 0; i <= 100; i++) {
				A[i] = new ArrayList<Integer>();
			}
			v = new boolean[101];
			d = new int[101];
			result = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());

				A[p1].add(p2);
			}

			BFS(K);
			int max_d = 0;
			for (int i = 0; i < 101; i++) {
				if (max_d <= d[i]) {
					max_d = d[i];
					result = i;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

	static void BFS(int p) {
		Queue<Integer[]> q = new LinkedList();
		v[p] = true;
		q.add(new Integer[] { p, 1 });

		while (!q.isEmpty()) {
			Integer[] now = q.poll();
			int num = now[0];
			int depth = now[1];
			d[num] = depth;

			for (int i = 0; i < A[num].size(); i++) {
				int next = A[num].get(i);
				if (!v[next]) {
					q.add(new Integer[] { next, depth + 1 });
					v[next] = true;
				}
			}

		}

	}

}
