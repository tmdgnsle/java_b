import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            // 집 + 편의점 n개 + 페스티벌 = 총 n+2개
            Point[] arr = new Point[n + 2];

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i] = new Point(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                );
            }

            // BFS 탐색
            boolean[] visited = new boolean[n + 2];
            Queue<Integer> q = new LinkedList<>();

            q.add(0); // 집 index = 0
            visited[0] = true;

            boolean happy = false;

            while (!q.isEmpty()) {
                int cur = q.poll();

                // 페스티벌 도착
                if (cur == n + 1) {
                    happy = true;
                    break;
                }

                for (int i = 0; i < n + 2; i++) {
                    if (!visited[i] && dist(arr[cur], arr[i]) <= 1000) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }

            sb.append(happy ? "happy\n" : "sad\n");
        }

        System.out.print(sb);
    }

    // 맨해튼 거리 계산
    static int dist(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}