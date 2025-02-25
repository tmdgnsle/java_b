

import java.util.*;
import java.io.*;

public class Solution {
	static class Node {
		char data;
		int left;
		int right;

		public Node(char data, int left, int right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	static Node[] tree;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1231.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());

			tree = new Node[N + 1];
			sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int node_num = Integer.parseInt(st.nextToken());

				char data = st.nextToken().toCharArray()[0];

				int left = 0;
				int right = 0;
				if (st.hasMoreTokens()) {
					left = Integer.parseInt(st.nextToken());
				}

				if (st.hasMoreTokens()) {
					right = Integer.parseInt(st.nextToken());
				}

				tree[node_num] = new Node(data, left, right);

			}
			inorder(1);
			System.out.println("#" + t + " " + sb);
		}
	}

	static void inorder(int node_num) {
		if (node_num == 0)
			return;
		inorder(tree[node_num].left);
		sb.append(tree[node_num].data);
		inorder(tree[node_num].right);
	}

}
