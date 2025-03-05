import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Node>[] A;
	static long lcm;
	static boolean[] v;
	static long D[];

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		A = new ArrayList[N];
		v = new boolean[N];
		D = new long[N];

		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<Node>();
		}
		lcm = 1;
		for (int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();

			A[a].add(new Node(b, p, q));
			A[b].add(new Node(a, q, p));
			lcm *= (p * q) / gcd(p, q); // 최소공배수들의 곱
		}

		D[0] = lcm;
		DFS(0);
		long mgcd = D[0];
		for (int i = 1; i < N; i++) {
			mgcd = gcd(mgcd, D[i]);
		}
		for (int i = 0; i < N; i++) {
			System.out.print(D[i] / mgcd + " ");
		}

	}

	static void DFS(int node) {
		v[node] = true;
		for (Node i : A[node]) {
			int next = i.getB();
			if (!v[next]) {
				D[next] = D[node] * i.getQ() / i.getP();
				DFS(next);
			}
		}
	}

	static long gcd(long p, long q) {
		if (q == 0)
			return p;
		else
			return gcd(q, p % q);
	}

	static class Node {
		int b;
		int p;
		int q;

		Node(int b, int p, int q) {
			this.b = b;
			this.p = p;
			this.q = q;
		}

		public int getB() {
			return b;
		}

		public int getP() {
			return p;
		}

		public int getQ() {
			return q;
		}

	}

}