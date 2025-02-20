

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static ArrayList<Integer> result;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		v = new boolean[N + 1];
		result = new ArrayList<>();
		bt();
	}

	static void bt() {
		if (result.size() == M) {
			for (int i = 0; i < result.size(); i++) {
				System.out.print(result.get(i) + " ");
			}
			System.out.println();
			return;
		} else {
			for (int i = 1; i <= N; i++) {
				if (!v[i]) {

					result.add(i);
					v[i] = true;

					bt();
					result.remove(result.size() - 1);
					v[i] = false;
				}
			}
		}
	}
}
