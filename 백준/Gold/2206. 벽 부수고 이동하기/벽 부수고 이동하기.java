import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] v; // [x][y][canBreak 상태]
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j - 1) - '0';
            }
        }

        answer = bfs();
        System.out.println(answer);
    }

    static int bfs() {
        // canBreak == 0 : 아직 안 부숨
        // canBreak == 1 : 이미 한 번 부숨
        v = new boolean[N + 1][M + 1][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1, 1, 0}); // x, y, count, canBreak
        v[1][1][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            int canBreak = cur[3];

            if (x == N && y == M) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > N || ny < 1 || ny > M) continue;

                // 빈 칸
                if (map[nx][ny] == 0) {
                    if (!v[nx][ny][canBreak]) {
                        v[nx][ny][canBreak] = true;
                        queue.add(new int[]{nx, ny, count + 1, canBreak});
                    }
                }
                // 벽이고, 아직 한 번도 안 부쉈다면
                else {
                    if (canBreak == 0 && !v[nx][ny][1]) {
                        v[nx][ny][1] = true;
                        queue.add(new int[]{nx, ny, count + 1, 1});
                    }
                }
            }
        }

        return -1;
    }
}