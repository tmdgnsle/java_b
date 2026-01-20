import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] grid;
    static int[][] fireTime;
    static int[][] jihunTime;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        fireTime = new int[R][C];
        jihunTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(fireTime[i], -1);
            Arrays.fill(jihunTime[i], -1);
        }

        Deque<int[]> fireQ = new ArrayDeque<>();
        Deque<int[]> jihunQ = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'F') {
                    fireQ.add(new int[]{i, j});
                    fireTime[i][j] = 0;
                } else if (grid[i][j] == 'J') {
                    jihunQ.add(new int[]{i, j});
                    jihunTime[i][j] = 0;
                }
            }
        }

        
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int x = cur[0], y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (grid[nx][ny] == '#') continue;
                if (fireTime[nx][ny] != -1) continue;

                fireTime[nx][ny] = fireTime[x][y] + 1;
                fireQ.add(new int[]{nx, ny});
            }
        }

        
        while (!jihunQ.isEmpty()) {
            int[] cur = jihunQ.poll();
            int x = cur[0], y = cur[1];
            int t = jihunTime[x][y];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nt = t + 1;

                
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    System.out.println(nt);
                    return;
                }

                if (grid[nx][ny] == '#') continue;
                if (jihunTime[nx][ny] != -1) continue;

                
                if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= nt) continue;

                jihunTime[nx][ny] = nt;
                jihunQ.add(new int[]{nx, ny});
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}