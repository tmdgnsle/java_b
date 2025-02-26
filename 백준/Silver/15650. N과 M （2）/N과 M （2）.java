

import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static ArrayList<Integer> result;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		v = new boolean[N + 1];

		result = new ArrayList();

		bt(0);
	}

	static void bt(int current) {
		if (result.size() == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result.get(i) + " ");
			}
			System.out.println();
			return;
		}
		for (int i = current + 1; i <= N; i++) {
			if (!v[i]) {
				v[i] = true;
				result.add(i);
				bt(i);

				result.remove(result.size() - 1);
				v[i] = false;

			}

		}

	}

}
