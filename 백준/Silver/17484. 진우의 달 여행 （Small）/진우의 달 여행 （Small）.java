import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x;
        int y;
        int dIdx;
        int value;

        Node(int x, int y, int dIdx, int value) {
            this.x = x;
            this.y = y;
            this.dIdx = dIdx;
            this.value = value;
        }
    }

    static int N, M;
    static int[][] map;
    static int[] dy = {-1, 0, 1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            bfs(i);
        }

        System.out.println(answer);

    }


    static void bfs(int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, y, -1, map[0][y]));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == N - 1) {
                answer = Math.min(answer, node.value);
                continue;
            }

            for (int i = 0; i < 3; i++) {
                if (i == node.dIdx) continue;
                int nx = node.x + 1;
                int ny = node.y + dy[i];

                if (!isValid(nx, ny)) continue;

                queue.add(new Node(nx, ny, i, node.value + map[nx][ny]));
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}