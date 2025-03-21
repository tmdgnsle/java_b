import java.io.*;
import java.util.*;

public class Main {
	// 북, 동, 남, 서 방향 정의 (문제에서 주어진 방향 기준)
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int N, M; // 방의 크기
	static int[][] map; // 방의 상태 (0: 청소되지 않은 빈 칸, 1: 벽, 2: 청소된 칸)
	static int count = 0; // 청소한 칸의 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로 크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()); // 로봇 청소기 시작 위치 r
		int c = Integer.parseInt(st.nextToken()); // 로봇 청소기 시작 위치 c
		int d = Integer.parseInt(st.nextToken()); // 로봇 청소기 시작 방향

		// 방의 상태 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 로봇 청소기 작동 시작
		cleanRoom(r, c, d);

		System.out.println(count);
	}

	public static void cleanRoom(int r, int c, int d) {
		if (map[r][c] == 0) {
			map[r][c] = 2;
			count++;
		}

		boolean cleaned = false;
		int originalDirection = d;

		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			int nr = r + dx[d];
			int nc = c + dy[d];

			if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
				cleanRoom(nr, nc, d);
				cleaned = true;
				break;
			}
		}

		if (!cleaned) {
			int backDir = (originalDirection + 2) % 4;
			int br = r + dx[backDir];
			int bc = c + dy[backDir];

			if (br >= 0 && bc >= 0 && br < N && bc < M && map[br][bc] != 1) {
				cleanRoom(br, bc, originalDirection);
			}

		}

	}
}