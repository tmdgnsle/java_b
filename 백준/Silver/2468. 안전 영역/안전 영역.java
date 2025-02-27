//  안전 영역

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[][] map;
    static boolean[][] v;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static int max, min;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        result = Integer.MIN_VALUE;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        for (int i = min - 1; i < max; i++) {
            int count = 0;
            v = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if ((map[j][k] > i) && !v[j][k]) {
                        dfs(i, j, k);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }

        System.out.println(result);

    }

    static void dfs(int height, int ci, int cj) {
        v[ci][cj] = true;
        for (int i = 0; i < 4; i++) {
            int ni = ci + di[i];
            int nj = cj + dj[i];

            if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
            if (v[ni][nj] || map[ni][nj] <= height) continue;

            dfs(height, ni, nj);

        }
    }

}