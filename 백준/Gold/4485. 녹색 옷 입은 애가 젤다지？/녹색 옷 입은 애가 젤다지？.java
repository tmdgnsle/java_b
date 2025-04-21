import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        Node(int x, int y, int cost) {
            super();
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = dijkstra(map, N);

            System.out.println("Problem " + t + ": " + result);

            t++;
        }
    }

    static int dijkstra(int[][] map, int N) {
        int[][] costMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(costMap[i], Integer.MAX_VALUE);
        }

        costMap[0][0] = map[0][0];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, map[0][0]));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int cx = cur.x;
            int cy = cur.y;
            int currentCost = cur.cost;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                int nextCost = currentCost + map[nx][ny];
                if (nextCost < costMap[nx][ny]) {
                    costMap[nx][ny] = nextCost;
                    pq.offer(new Node(nx, ny, nextCost));
                }
            }
        }

        return costMap[N - 1][N - 1];

    }
}