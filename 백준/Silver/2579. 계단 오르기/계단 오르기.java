import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] stairs = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stairs[i] = sc.nextInt();
		}

		int[][] D = new int[N + 1][2];
		D[1][0] = stairs[1];
		D[1][1] = stairs[1];

		for (int i = 2; i <= N; i++) {
			D[i][0] = D[i - 1][1] + stairs[i];
			D[i][1] = Math.max(D[i - 2][0], D[i - 2][1]) + stairs[i];
		}

		System.out.println(Math.max(D[N][0], D[N][1]));

	}
}