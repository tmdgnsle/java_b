import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[5001];

		D[0] = -1;
		D[1] = -1;
		D[2] = -1;
		D[3] = 1;
		D[4] = -1;
		D[5] = 1;

		for (int i = 6; i <= N; i++) {
			if (D[i - 3] == -1 && D[i - 5] == -1) {
				D[i] = -1;
				continue;
			}
			if (D[i - 5] == -1) {
				D[i] = D[i - 3] + 1;
				continue;
			}
			if (D[i - 3] == -1) {
				D[i] = D[i - 5] + 1;
				continue;
			}

			D[i] = Math.min(D[i - 3], D[i - 5]) + 1;

		}

		System.out.println(D[N]);

	}
}