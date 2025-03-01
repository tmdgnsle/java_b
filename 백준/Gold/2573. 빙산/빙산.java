//  빙산

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] ice;
    static int[][] newIce;
    static boolean[][] v;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ice = new int[N][M];

        result = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, ice[i][j]);
            }
        }

        int year = 0;


        while (true) {

            int count = 0;
            v = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!v[i][j] && ice[i][j] != 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            if(count == 0) break;
            if (count > 1) {
                result = year;
                break;
            }

            newIce = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ice[i][j] != 0) {
                        melt(i, j);
                    } else {
                        newIce[i][j] = 0;
                    }
                }
            }
            ice = newIce;
            year++;


        }

        System.out.println(result);


    }

    static void melt(int ci, int cj) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int ni = ci + di[i];
            int nj = cj + dj[i];

            if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
            if (ice[ni][nj] == 0) count++;
        }

        newIce[ci][cj] = ice[ci][cj] - count;
        if (newIce[ci][cj] < 0) newIce[ci][cj] = 0;

    }

    static void dfs(int ci, int cj) {
        if (v[ci][cj]) return;
        v[ci][cj] = true;
        for (int i = 0; i < 4; i++) {
            int ni = ci + di[i];
            int nj = cj + dj[i];

            if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
            if (v[ni][nj]) continue;
            if (ice[ni][nj] != 0) {
                dfs(ni, nj);
            }
        }

    }
}