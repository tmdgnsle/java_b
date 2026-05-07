import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[][] map;
    static int[][] dp;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, map[i][j]);
                maxH = Math.max(maxH, map[i][j]);
            }
        }

        int left = 0;
        int right = maxH - minH;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canMakeRoad(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canMakeRoad(int limit) {
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dfs(i, j, limit) >= K) {
                    return true;
                }
            }
        }

        return false;
    }

    static int dfs(int x, int y, int limit) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        dp[x][y] = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            int diff = map[nx][ny] - map[x][y];

            if (diff <= 0) continue;
            if (diff > limit) continue;

            dp[x][y] = Math.max(dp[x][y], dfs(nx, ny, limit) + 1);

            if (dp[x][y] >= K) return dp[x][y];
        }

        return dp[x][y];
    }
}