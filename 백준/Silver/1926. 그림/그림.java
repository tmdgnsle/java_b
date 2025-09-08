import java.io.*;
import java.util.*;

public class Main {
    static int[][] draws;
    static boolean[][] v;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n;
    static int m;
    static int max;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        draws = new int[n][m];
        v = new boolean[n][m];
        max = 0;
        count = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                draws[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (draws[i][j] == 1 && !v[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count + " " + max);

    }

    static void bfs(int x, int y) {
        v[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 1});

        int size = 1;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            max = Math.max(max, size);

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isValid(nx, ny)) {
                    size += 1;
                    q.add(new int[]{nx, ny});
                    v[nx][ny] = true;
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && draws[x][y] == 1 && !v[x][y];
    }

}