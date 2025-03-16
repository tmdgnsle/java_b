import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    static List<int[]> union; // 연합을 이루는 국가들의 좌표를 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 맵의 크기
        L = Integer.parseInt(st.nextToken()); // 인구 차이 하한
        R = Integer.parseInt(st.nextToken()); // 인구 차이 상한

        map = new int[N][N]; // 인구 정보 저장 배열

        // 인구 정보 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {

            boolean isChanged = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        union = new ArrayList<>();
                        int total = bfs(i, j);

                        if(union.size() > 1){
                            total = total / union.size();
                            for (int[] a : union) {
                                map[a[0]][a[1]] = total;
                            }
                            isChanged = true;
                        }


                    }
                }
            }

            if (!isChanged) break;
            time++;

        }

        System.out.println(time);

    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int total = map[x][y];

        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            union.add(c);
            int cx = c[0];
            int cy = c[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

                int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                if (diff >= L && diff <= R) {
                    total += map[nx][ny];
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }

        }

        return total;
    }
}