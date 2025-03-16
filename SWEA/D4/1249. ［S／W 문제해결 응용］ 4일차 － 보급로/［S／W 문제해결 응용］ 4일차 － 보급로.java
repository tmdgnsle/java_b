import java.io.*;
import java.util.*;

public class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] dist; // 최단 거리 저장 배열
    static int N;

    static class Point implements Comparable<Point> {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost; // 비용이 적은 것이 우선순위 높음
        }
    }

    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("res/input_1249.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];

            // 지도 정보 입력 받기
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE; // 최단 거리 초기화
                }
            }

            // 다익스트라 알고리즘 수행
            int result = dijkstra();

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.print(sb);
    }

    static int dijkstra() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        dist[0][0] = 0; // 시작점 비용은 0
        pq.offer(new Point(0, 0, 0));

        while (!pq.isEmpty()) {
            Point current = pq.poll();
            int x = current.x;
            int y = current.y;
            int cost = current.cost;

            // 목적지에 도달한 경우
            if (x == N - 1 && y == N - 1) {
                return cost;
            }

            // 현재 경로가 이미 알려진 최단 경로보다 비용이 크면 무시
            if (cost > dist[x][y]) continue;

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // 새로운 비용 계산
                int newCost = cost + map[nx][ny];

                // 더 적은 비용으로 갈 수 있다면 업데이트
                if (newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;
                    pq.offer(new Point(nx, ny, newCost));
                }
            }
        }

        // 도달할 수 없는 경우 (실제로는 발생하지 않음)
        return dist[N - 1][N - 1];
    }
}