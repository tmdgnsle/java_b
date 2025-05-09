import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int result;
	static boolean[] v;
	static Node[] le;

	static class Node {
		int start;
		int end;

		Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	static class Current {
		int current;
		int count;

		Current(int current, int count) {
			this.current = current;
			this.count = count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = Integer.MAX_VALUE;

		le = new Node[N + M];

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			le[i] = new Node(start, end);

		}

		v = new boolean[101];
		bfs();

		System.out.println(result);

	}

	static void bfs() {
		v[1] = true;
		Queue<Current> queue = new LinkedList<>();
		queue.add(new Current(1, 0));

		while (!queue.isEmpty()) {
			Current current = queue.poll();

			for (int i = 0; i < N + M; i++) {
				if (le[i].start == current.current) {
					current = new Current(le[i].end, current.count);
				}
			}
			for (int i = 1; i <= 6; i++) {
				int next = current.current + i;
				if (next < 100 && !v[next]) {
					v[next] = true;
					queue.add(new Current(next, current.count + 1));
				}
				if (next == 100) {
					result = Math.min(result, current.count + 1);
				}
			}
		}

	}

}