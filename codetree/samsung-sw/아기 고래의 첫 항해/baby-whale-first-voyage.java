import java.util.*;
import java.io.*;

public class Main {
    static int N, r, c, d;
    static int[][] map;
    static boolean[][] visited;

    // 1: 위, 2: 아래, 3: 왼쪽, 4: 오른쪽
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    static int[][] priority = {
            {},
            {1, 3, 4, 2}, // 위
            {2, 4, 3, 1}, // 아래
            {3, 2, 1, 4}, // 왼쪽
            {4, 1, 2, 3}  // 오른쪽
    };

    static class Node {
        int x, y, dist, dir;

        Node(int x, int y, int dist, int dir) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[r][c] = true;
        System.out.println(r + " " + c);

        while (true) {
            if (moveNear()) {
                System.out.println(r + " " + c);
                continue;
            }

            Node next = findNext();

            if (next == null) break;

            r = next.x;
            c = next.y;
            d = next.dir;
            visited[r][c] = true;

            System.out.println(r + " " + c);
        }
    }

    static boolean moveNear() {
        for (int i = 0; i < 4; i++) {
            int nd = priority[d][i];

            int nx = r + dx[nd];
            int ny = c + dy[nd];

            if (!isValid(nx, ny)) continue;
            if (visited[nx][ny]) continue;

            r = nx;
            c = ny;
            d = nd;
            visited[r][c] = true;

            return true;
        }

        return false;
    }

    static Node findNext() {
        Queue<Node> q = new LinkedList<>();
        boolean[][] check = new boolean[N + 1][N + 1];

        q.add(new Node(r, c, 0, d));
        check[r][c] = true;

        Node answer = null;

        int[] bfsDir = {3, 2, 4, 1}; // 왼쪽, 아래, 오른쪽, 위

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (!visited[cur.x][cur.y]) {
                if (answer == null ||
                        cur.dist < answer.dist ||
                        cur.dist == answer.dist && cur.x < answer.x ||
                        cur.dist == answer.dist && cur.x == answer.x && cur.y < answer.y) {
                    answer = cur;
                }
            }

            for (int nd : bfsDir) {
                int nx = cur.x + dx[nd];
                int ny = cur.y + dy[nd];

                if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if (map[nx][ny] == 1) continue;
                if (check[nx][ny]) continue;

                check[nx][ny] = true;
                q.add(new Node(nx, ny, cur.dist + 1, nd));
            }
        }

        return answer;
    }

    static boolean isValid(int x, int y) {
        return x >= 1 && y >= 1 && x <= N && y <= N && map[x][y] == 0;
    }
}