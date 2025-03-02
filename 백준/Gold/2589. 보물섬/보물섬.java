//  보물섬

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] v;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    v = new boolean[N][M];
                    bfs(i, j);
                }

            }
        }

        System.out.println(max);

    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        v[x][y] = true;
        q.add(new int[]{x, y, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int ci = now[0];
            int cj = now[1];
            int distance = now[2];

            if (max < distance) max = distance;

            for (int i = 0; i < 4; i++) {
                int ni = ci + dx[i];
                int nj = cj + dy[i];

                if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
                if (v[ni][nj] || map[ni][nj] == 'W') continue;

                q.add(new int[]{ni, nj, distance + 1});
                v[ni][nj] = true;

            }

        }


    }

}