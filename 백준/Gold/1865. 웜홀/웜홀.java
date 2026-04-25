import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 지점 수
            int M = Integer.parseInt(st.nextToken()); // 도로 수
            int W = Integer.parseInt(st.nextToken()); // 웜홀 수

            List<Edge> edges = new ArrayList<>();

            // 도로: 양방향
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                edges.add(new Edge(S, E, T));
                edges.add(new Edge(E, S, T));
            }

            // 웜홀: 단방향, 시간 감소 => 음수 간선
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                edges.add(new Edge(S, E, -T));
            }

            boolean hasNegativeCycle = bellmanFord(N, edges);

            sb.append(hasNegativeCycle ? "YES" : "NO").append("\n");
        }

        System.out.print(sb);
    }

    static boolean bellmanFord(int N, List<Edge> edges) {
        int[] dist = new int[N + 1];

        // 모든 정점을 시작점처럼 보기 위해 전부 0으로 둠
        Arrays.fill(dist, 0);

        // N번 완화
        for (int i = 1; i <= N; i++) {
            boolean updated = false;

            for (Edge edge : edges) {
                if (dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                    updated = true;

                    // N번째에도 갱신되면 음수 사이클 존재
                    if (i == N) return true;
                }
            }

            if (!updated) break;
        }

        return false;
    }
}