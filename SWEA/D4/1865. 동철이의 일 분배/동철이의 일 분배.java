import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static double[][] map;
	static boolean[] v;
	static double maxProbability;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_1865.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new double[N][N];
			v = new boolean[N];
			maxProbability = 0;

			// 입력 받을 때 바로 확률로 변환
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()) * 0.01;
				}
			}

			backtrack(0, 1.0);
			sb.append("#").append(t).append(" ").append(String.format("%.6f", maxProbability * 100)).append("\n");
		}
		System.out.print(sb);
	}

	static void backtrack(int depth, double currentProbability) {
		// 가지치기: 현재 확률이 이미 찾은 최대 확률보다 작으면 더 이상 탐색하지 않음
		if (currentProbability <= maxProbability) {
			return;
		}

		// 모든 일을 배분했을 때
		if (depth == N) {
			maxProbability = currentProbability;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				// 현재 확률에 이 선택의 확률을 곱했을 때의 결과가
				// 이미 찾은 최대값보다 작을 수 있다면 탐색하지 않음
				if (currentProbability * map[depth][i] <= maxProbability) {
					continue;
				}

				v[i] = true;
				backtrack(depth + 1, currentProbability * map[depth][i]);
				v[i] = false;
			}
		}
	}
}