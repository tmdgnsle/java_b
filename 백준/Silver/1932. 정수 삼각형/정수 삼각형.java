import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] tri = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] D = new int[N + 1][N + 1];

		D[1][1] = tri[1][1];

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				D[i][j] = Math.max(D[i - 1][j - 1], D[i - 1][j]) + tri[i][j];
			}
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, D[N][i]);
		}

		System.out.println(max);

	}
}