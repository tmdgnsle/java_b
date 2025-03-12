import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/input_1245.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] positions = new int[N];
			int[] weights = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				positions[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}

			System.out.print("#" + tc);

			for (int i = 0; i < N - 1; i++) {
				double balancePoint = findBalancePoint(positions, weights, N, positions[i], positions[i + 1]);
				System.out.printf(" %.10f", balancePoint);
			}
			System.out.println();
		}
	}

	private static double findBalancePoint(int[] positions, int[] weights, int n, double left, double right) {
		double mid;

		final double EPSILON = 1e-12;

		while (right - left > EPSILON) {
			mid = (left + right) / 2;

			double force = 0;

			for (int i = 0; i < n; i++) {

				double distance = positions[i] - mid;
				double magnitude = weights[i] / (distance * distance);

				if (distance < 0) {
					force -= magnitude;
				} else {
					force += magnitude;
				}
			}

			if (force < 0) {
				left = mid;
			} else {
				right = mid;
			}
		}

		return left;
	}
}