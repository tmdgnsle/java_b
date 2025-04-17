import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[][] colors;
    static boolean[][] v;

    static int count1, count2;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        colors = new String[N][N];
        v = new boolean[N][N];


        count1 = 0;
        count2 = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                colors[i][j] = str.substring(j, j + 1);
                
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) {
                    bfs(i, j);
                    count1++;
                }
            }
        }

        v = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (colors[i][j].equals("G")) {
                    colors[i][j] = "R";
                }

            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) {
                    bfs(i, j);
                    count2++;
                }
            }
        }

        System.out.println(count1 + " " + count2);

    }


    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        v[x][y] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (!v[nx][ny] && colors[cx][cy].equals(colors[nx][ny])) {
                    q.add(new int[]{nx, ny});
                    v[nx][ny] = true;
                }

            }

        }

    }
}