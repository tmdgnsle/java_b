import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, idx;

        Edge(int to, int idx) {
            this.to = to;
            this.idx = idx;
        }
    }

    static int n, m;
    static ArrayList<Edge>[] graph;
    static boolean[] visited;

    static int componentCount = 0;
    static ArrayList<Integer> nodePath;
    static ArrayList<Integer> edgePath;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (n <= 2) {
            System.out.println(-1);
            return;
        }

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, i));
            graph[v].add(new Edge(u, i));
        }

        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            if (componentCount == 2) {
                System.out.println(-1);
                return;
            }

            componentCount++;

            nodePath = new ArrayList<>();
            edgePath = new ArrayList<>();

            visited[i] = true;
            nodePath.add(i);
            dfs(i);

            // 그래프가 처음부터 하나의 연결그래프였다면
            // DFS 트리에서 마지막 정점 하나를 때면 된다.
            if (edgePath.size() == n - 1) {
                buildSingleComponentAnswer();
                System.out.println(sb);
                return;
            }

            // 첫 번째 컴포넌트 처리 직후:
            // 이미 2개 컴포넌트로 나뉘어 있는 경우 정답 가능 여부 판단
            if (componentCount == 1) {
                if (nodePath.size() * 2 == n) { // 이미 나눠져있는 정점들의 갯수가 서로 같을 때
                    System.out.println(-1);
                    return;
                }

                sb.append(nodePath.size()).append(" ").append(n - nodePath.size()).append("\n");

                for (int node : nodePath) {
                    sb.append(node).append(" ");
                }
                sb.append("\n");

                for (int edge : edgePath) {
                    sb.append(edge).append(" ");
                }
                sb.append("\n");

            } else {
                for (int node : nodePath) {
                    sb.append(node).append(" ");
                }
                sb.append("\n");

                for (int edge : edgePath) {
                    sb.append(edge).append(" ");
                }
                sb.append("\n");
            }


        }
        System.out.println(sb);


    }

    static void dfs(int cur) {
        for (Edge next : graph[cur]) {
            if (visited[next.to]) continue;
            visited[next.to] = true;
            nodePath.add(next.to);
            edgePath.add(next.idx);
            dfs(next.to);
        }
    }

    static void buildSingleComponentAnswer() {
        sb.append(n - 1).append(" ").append(1).append("\n");

        for (int i = 0; i < nodePath.size() - 1; i++) {
            sb.append(nodePath.get(i)).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < edgePath.size() - 1; i++) {
            sb.append(edgePath.get(i)).append(" ");
        }
        sb.append("\n");

        sb.append(nodePath.get(nodePath.size() - 1)).append("\n");
        sb.append("\n"); // 두 번째 트리의 간선 목록(0개)
    }
}