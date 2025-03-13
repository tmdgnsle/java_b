import java.io.*;
import java.util.*;

public class Solution {
	static int V, E;
	static ArrayList<Node> arr;
	static boolean[] v;
	static ArrayList<Integer> result;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1267.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			arr = new ArrayList<>();
			for (int i = 0; i <= V; i++) {
				arr.add(new Node());
			}
			v = new boolean[V + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				arr.get(p1).next.add(p2);
				arr.get(p2).pre.add(p1);
			}

			result = new ArrayList<>();

			for (int i = 1; i <= V; i++) {
				if (arr.get(i).pre.isEmpty()) {

					v[i] = true;
					dfs(i);
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			for (int a : result) {
				sb.append(a + " ");
			}

			System.out.println(sb);

		}

	}

	static void dfs(int current) {
		result.add(current);

		for (int next : arr.get(current).next) {
			if (v[next])
				continue;

			boolean prevent = true;
			for (int pre : arr.get(next).pre) {
				if (!v[pre]) {
					prevent = false;
					break;
				}
			}
			if (prevent) {
				v[next] = true;
				dfs(next);
			}
		}

	}

}

class Node {
	ArrayList<Integer> next;
	ArrayList<Integer> pre;

	Node() {
		next = new ArrayList<>();
		pre = new ArrayList<>();
	}

}
