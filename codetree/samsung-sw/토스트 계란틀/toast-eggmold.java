import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int L;
    static int R;

    static int[][] map;
    static boolean[][] visited;

    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while (true) {
            visited = new boolean[n][n];

            // 이번 반복에서 계란 이동이 발생했는지 확인
            boolean moved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (!visited[i][j]) {
                        // 연결된 계란틀의 개수가 2개 이상이라면 이동 발생
                        if (bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            // 어떤 그룹에서도 계란 이동이 없었다면 종료
            if (!moved) {
                break;
            }

            answer++;
        }

        System.out.println(answer);
    }

    static boolean bfs(int startX, int startY) {
        Queue<Point> queue = new ArrayDeque<>();

        // 현재 그룹에 포함된 칸들을 저장
        ArrayList<Point> group = new ArrayList<>();

        queue.offer(new Point(startX, startY));
        group.add(new Point(startX, startY));

        visited[startX][startY] = true;

        // 현재 그룹의 계란 총합
        int sum = map[startX][startY];

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int direction = 0; direction < 4; direction++) {
                int nx = current.x + dx[direction];
                int ny = current.y + dy[direction];

                // 격자 밖이면 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                // 이미 현재 이동에서 확인한 칸이면 무시
                if (visited[nx][ny]) {
                    continue;
                }

                int difference =
                        Math.abs(map[current.x][current.y] - map[nx][ny]);

                // 계란 양의 차이가 이동 범위에 포함되는 경우
                if (difference >= L && difference <= R) {
                    visited[nx][ny] = true;

                    queue.offer(new Point(nx, ny));
                    group.add(new Point(nx, ny));

                    sum += map[nx][ny];
                }
            }
        }

        // 자기 자신만 그룹에 포함됐다면 이동이 발생하지 않음
        if (group.size() == 1) {
            return false;
        }

        // 그룹 전체가 가지게 될 계란의 양
        int newAmount = sum / group.size();

        for (Point point : group) {
            map[point.x][point.y] = newAmount;
        }

        return true;
    }
}