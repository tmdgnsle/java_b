import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] button = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int but = Integer.parseInt(st.nextToken());
			if (but == 1) {
				button[i] = true;
			}
		}

		int personCount = Integer.parseInt(br.readLine());

		for (int t = 0; t < personCount; t++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());

			if (p1 == 1) {
				for (int i = 1; i <= N; i++) {
					if (i % p2 == 0) {
						button[i] = !button[i];
					}
				}
			} else {
				int a = 1;
				button[p2] = !button[p2];
				while (true) {
					int nIdx = p2 + a;
					int pIdx = p2 - a;
					if (nIdx > N || pIdx < 1)
						break;
					boolean next = button[nIdx];
					boolean prev = button[pIdx];

					if (next == prev) {
						button[nIdx] = !button[nIdx];
						button[pIdx] = !button[pIdx];
					} else {
						break;
					}
					a++;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (button[i]) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}

			if (i % 20 == 0)
				System.out.println();

		}

		System.out.println();

	}

}