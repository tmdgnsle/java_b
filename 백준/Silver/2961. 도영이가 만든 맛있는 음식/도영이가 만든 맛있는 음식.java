import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int result;
	static boolean[] v;
	static Taste[] ig;
	static ArrayList<Taste> arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ig = new Taste[N];
		v = new boolean[N];
		result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			ig[i] = new Taste(s, b);
		}

		arr = new ArrayList<>();

		bt(0);

		System.out.println(result);
	}

	static void bt(int depth) {
		if (!arr.isEmpty()) {
			int S = 1;
			int B = 0;

			for (Taste t : arr) {
				S *= t.s;
				B += t.b;
			}

			int temp = Math.abs(S - B);
			result = Math.min(result, temp);

		}
		if (depth == N)
			return;

		for (int i = depth; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				arr.add(ig[i]);
				bt(i);
				v[i] = false;
				arr.remove(arr.size() - 1);
			}
		}

	}

	static class Taste {
		int s;
		int b;

		Taste(int s, int b) {
			this.s = s;
			this.b = b;
		}
	}
}