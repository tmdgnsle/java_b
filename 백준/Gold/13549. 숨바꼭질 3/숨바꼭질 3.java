import java.io.*;
import java.util.*;

public class Main {

	static class Point implements Comparable<Point> {
		int time;
		int cp;

		Point(int time, int cp) {
			this.time = time;
			this.cp = cp;
		}

		@Override
		public int compareTo(Point o) {

			return this.time - o.time;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int result = dijkstra(N, K);
		System.out.println(result);
	}

	static int dijkstra(int N, int K) {
		int[] costMap = new int[100001];
		Arrays.fill(costMap, Integer.MAX_VALUE);

		costMap[N] = 0;

		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0, N));

		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			int cp = cur.cp;
			int currentCost = cur.time;

			if (isValid(2 * cp)) {
				if (currentCost < costMap[2 * cp]) {
					costMap[2 * cp] = currentCost;
					pq.offer(new Point(currentCost, 2 * cp));
				}
			}

			if (isValid(cp + 1)) {
				if (currentCost + 1 < costMap[cp + 1]) {
					costMap[cp + 1] = currentCost + 1;
					pq.offer(new Point(currentCost + 1, cp + 1));
				}
			}

			if (isValid(cp - 1)) {
				if (currentCost + 1 < costMap[cp - 1]) {
					costMap[cp - 1] = currentCost + 1;
					pq.offer(new Point(currentCost + 1, cp - 1));
				}
			}
		}

		return costMap[K];

	}

	static boolean isValid(int point) {
		return point >= 0 && point <= 100000;
	}

}