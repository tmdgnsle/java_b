import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_7465.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new ArrayList[N + 1];
			v = new boolean[N + 1];

			for (int i = 1; i <= N; i++) {
				arr[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());

				arr[p1].add(p2);
				arr[p2].add(p1);
			}

			int count = 0;

			for (int i = 1; i <= N; i++) {
				if (!v[i]) {
					bfs(i);
					count++;
				}
			}

			System.out.println("#" + t + " " + count);

		}
	}

	static void bfs(int now) {
		Queue<Integer> queue = new LinkedList<>();
		v[now] = true;
		queue.add(now);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int next : arr[current]) {
				if (!v[next]) {
					v[next] = true;
					queue.add(next);
				}
			}
		}

	}

}
