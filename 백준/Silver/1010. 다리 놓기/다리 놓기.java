import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		D = new int[31][31];
		for (int i = 0; i < 31; i++) {
			D[i][0] = 1;
			D[i][1] = 1;
			D[i][i] = 1;
		}

		for (int i = 2; i < 31; i++) {
			for (int j = 1; j < i; j++) {
				D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
			}
		}

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();

			System.out.println(D[M][N]);
		}

	}
}