

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer> result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		result = new ArrayList<Integer>();

		bt(0);
		System.out.println(sb);
	}

	static void bt(int current) {
		if (result.size() == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result.get(i)).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (current <= i) {
				result.add(i);

				bt(i);
				result.remove(result.size() - 1);

			}
		}

	}

}
