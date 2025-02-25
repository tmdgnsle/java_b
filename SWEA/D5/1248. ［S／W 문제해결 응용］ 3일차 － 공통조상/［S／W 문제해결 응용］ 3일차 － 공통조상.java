

import java.util.*;
import java.io.*;

public class Solution {
	static class Node {
		int parent;
		int left;
		int right;

		public Node() {
			this.parent = 0;
			this.left = 0;
			this.right = 0;
		}
	}

	static Node[] tree;
	static int pResult;
	static int cResult;
	static ArrayList<Integer> arr1;
	static ArrayList<Integer> arr2;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1248.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			tree = new Node[V + 1];
			for (int i = 1; i <= V; i++) {
				tree[i] = new Node();
			}
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			arr1 = new ArrayList<>();
			arr2 = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int q1 = Integer.parseInt(st.nextToken());
				int q2 = Integer.parseInt(st.nextToken());
				if (tree[q1].left == 0) {
					tree[q1].left = q2;
				} else {
					tree[q1].right = q2;
				}

				tree[q2].parent = q1;
			}

			arr1.add(p1);
			arr2.add(p2);

			findParent(p1, true);
			findParent(p2, false);

			pResult = 0;
			cResult = 0;

			for (Integer element : arr1) {
				if (arr2.contains(element)) {
					pResult = element; // 첫 번째 발견된 공통 조상이 가장 가까운 공통 조상
					break; // 발견 즉시 루프 종료
				}
			}

			count(pResult);

			System.out.println("#" + t + " " + pResult + " " + cResult);

		}
	}

	static void findParent(int point, boolean where) {
		if (point == 0)
			return;
		if (where) {
			arr1.add(tree[point].parent);
			findParent(tree[point].parent, where);
		} else {
			arr2.add(tree[point].parent);
			findParent(tree[point].parent, where);
		}
	}

	static void count(int point) {
		if (point == 0)
			return;
		cResult++;
		count(tree[point].left);
		count(tree[point].right);

	}

}
