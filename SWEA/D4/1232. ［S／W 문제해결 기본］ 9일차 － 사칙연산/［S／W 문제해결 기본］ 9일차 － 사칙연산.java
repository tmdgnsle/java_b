

import java.util.*;
import java.io.*;

public class Solution {
	static class Node {
		String data;
		int left;
		int right;

		public Node(String data, int left, int right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	static Node[] tree;
	static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input_1232.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());

			tree = new Node[N + 1];
			stack = new Stack();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int node_num = Integer.parseInt(st.nextToken());

				String data = st.nextToken();

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

			int result = stack.pop();

			System.out.println("#" + t + " " + result);

		}
	}

	static void inorder(int node_num) {
		if (node_num == 0)
			return;
		inorder(tree[node_num].left);
		inorder(tree[node_num].right);

		int a = 0;
		int b = 0;
		int result = 0;

		switch (tree[node_num].data) {
		case ("*"):
			b = stack.pop();
			a = stack.pop();

			result = a * b;
			stack.push(result);

			break;
		case ("/"):
			b = stack.pop();
			a = stack.pop();

			result = a / b;
			stack.push(result);
			break;
		case ("+"):
			b = stack.pop();
			a = stack.pop();

			result = a + b;
			stack.push(result);
			break;
		case ("-"):
			b = stack.pop();
			a = stack.pop();

			result = a - b;
			stack.push(result);
			break;
		default:
			stack.push(Integer.parseInt(tree[node_num].data));
			break;
		}

	}

}
