
import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] v;
	static int N, M;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int result_time = 0;

		int total_cheese = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					total_cheese++;
				}
			}
		}

		int result_count = total_cheese;

		while (total_cheese > 0) {
			result_time++;
			result_count = total_cheese;

			v = new boolean[N][M];

			findAir(0, 0);

			total_cheese = meltCheese();
		}

		System.out.println(result_time);
		System.out.println(result_count);

	}

	static void findAir(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		v[x][y] = true;
		map[x][y] = -1;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (!v[nx][ny] && map[nx][ny] != 1) {
					v[nx][ny] = true;
					map[nx][ny] = -1;
					queue.offer(new int[] { nx, ny });
				}

			}
		}

	}

	static int meltCheese() {
		List<int[]> meltingCheese = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (nx < 0 || nx >= N || ny < 0 || ny >= M)
							continue;

						if (map[nx][ny] == -1) {
							meltingCheese.add(new int[] { i, j });
							break;
						}
					}
				}
			}
		}

		for (int[] pos : meltingCheese) {
			map[pos[0]][pos[1]] = -1;
		}

		int remainingCheese = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					remainingCheese++;
				}
			}
		}

		return remainingCheese;

	}

}
