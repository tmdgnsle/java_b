import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, X;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;

			// 가로 방향 검사
			for (int i = 0; i < N; i++) {
				if (checkRow(i)) {
					count++;
				}
			}

			// 세로 방향 검사
			for (int j = 0; j < N; j++) {
				if (checkCol(j)) {
					count++;
				}
			}

			System.out.println("#" + tc + " " + count);
		}
	}

	// 가로 방향 활주로 건설 가능 여부 확인
	private static boolean checkRow(int row) {
		boolean[] installed = new boolean[N]; // 경사로 설치 여부

		for (int j = 0; j < N - 1; j++) {
			int diff = map[row][j] - map[row][j + 1];

			if (diff == 0)
				continue; // 높이가 같으면 패스
			if (Math.abs(diff) > 1)
				return false; // 높이 차이가 1보다 크면 불가능

			if (diff == 1) { // 내리막길 (현재 > 다음)
				for (int k = 1; k <= X; k++) {
					if (j + k >= N || installed[j + k] || map[row][j + 1] != map[row][j + k]) {
						return false;
					}
					installed[j + k] = true;
				}
			} else { // 오르막길 (현재 < 다음)
				for (int k = 0; k < X; k++) {
					if (j - k < 0 || installed[j - k] || map[row][j] != map[row][j - k]) {
						return false;
					}
					installed[j - k] = true;
				}
			}
		}

		return true;
	}

	// 세로 방향 활주로 건설 가능 여부 확인
	private static boolean checkCol(int col) {
		boolean[] installed = new boolean[N]; // 경사로 설치 여부

		for (int i = 0; i < N - 1; i++) {
			int diff = map[i][col] - map[i + 1][col];

			if (diff == 0)
				continue; // 높이가 같으면 패스
			if (Math.abs(diff) > 1)
				return false; // 높이 차이가 1보다 크면 불가능

			if (diff == 1) { // 내리막길 (현재 > 다음)
				for (int k = 1; k <= X; k++) {
					if (i + k >= N || installed[i + k] || map[i + 1][col] != map[i + k][col]) {
						return false;
					}
					installed[i + k] = true;
				}
			} else { // 오르막길 (현재 < 다음)
				for (int k = 0; k < X; k++) {
					if (i - k < 0 || installed[i - k] || map[i][col] != map[i - k][col]) {
						return false;
					}
					installed[i - k] = true;
				}
			}
		}

		return true;
	}
}