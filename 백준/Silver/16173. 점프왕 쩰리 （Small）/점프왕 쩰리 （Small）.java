

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] a;
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        v = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        String result = v[n - 1][n - 1] ? "HaruHaru" : "Hing";
        System.out.println(result);
    }

    static void dfs(int i, int j) {
        if (v[i][j]) {
            return;
        }
        v[i][j] = true;
        int d = a[i][j];
        if (d == -1) return;

        int ni = i + d;
        int nj = j + d;
        if (ni < n && !v[ni][j]) {
            dfs(ni, j);
        }
        if (nj < n && !v[i][nj]) {
            dfs(i, nj);
        }

    }
}
