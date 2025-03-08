import java.io.*;
import java.util.*;

public class Main {
    static boolean v[];
    static char[][] map;
    static int R, C;
    static int result;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        // 65
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        v = new boolean[26];
        result = 1;
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int val = map[0][0] - 65;
        v[val] = true;
        bt(0, 0, 1);

        System.out.println(result);
    }

    static void bt(int x, int y, int count) {
        if (count > result) result = count;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

            int c = map[nx][ny] - 65;
            if (!v[c]) {
                v[c] = true;
                bt(nx, ny, count + 1);
                v[c] = false;
            }
        }
    }
}