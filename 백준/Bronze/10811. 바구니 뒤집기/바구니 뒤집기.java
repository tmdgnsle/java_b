import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] a = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			a[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());

			int[] b = new int[N + 1];

			for (int j = 1; j < first; j++) {
				b[j] = a[j];
			}

			for (int j = N; j > last; j--) {
				b[j] = a[j];
			}

			int sum = first + last;

			for (int j = first; j <= last; j++) {
				b[sum - j] = a[j];
			}

			a = b;

		}

		for (int i = 1; i <= N; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

	}
}